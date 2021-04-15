package a_11weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://summa-cum-laude.tistory.com/14
//5퍼 틀림
public class Main_bj_20208_진우의민트초코우유 {

	static int n, m, h ,sx,sy;
	static int map[][];
	static ArrayList<int[]> milk;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		milk = new ArrayList<>();
		max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (map[i][j] == 2) {
					milk.add(new int[] { i, j });
				}
			}
		}
		
		dfs(0, sx,sy,m);

		System.out.println(max);
		in.close();

	}

	static void dfs(int cnt, int x,int y,int hp) {

		// 집으로 돌아갈 수 있는지
		if (hp >= getd(x, y, sx, sy)) {
			max = Math.max(cnt, max);
		} 
		
		//for(int []m:map)System.out.println(Arrays.toString(m));
		for (int temp[]:milk) {
			if (map[temp[0]][temp[1]] == 2) {
				int dist = getd(temp[0],temp[1], x, y);
				// 체력으로 움직일 수 있는 곳
				if (hp >= dist) {
					map[temp[0]][temp[1]]= 0;
					
					/* 틀린 코드
						hp -= dist;
						hp += h;
						dfs(cnt + 1,temp[0],temp[1],hp);
					*/
					dfs(cnt + 1,temp[0],temp[1],hp+h-dist);
					map[temp[0]][temp[1]] = 2;
				}
			}
		}
	}

	static int getd(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}
}
