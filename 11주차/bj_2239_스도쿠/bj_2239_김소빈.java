package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠 {
	static int[][] map = new int[9][9];
	static List<int[]> li = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String in = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = in.charAt(j) - '0';
				if (map[i][j] == 0)
					li.add(new int[] {i,j}); //채워야할 위치 리스트에 저장해서 리스트 dfs로 채우기
			}
		}
		dfs(0);
	}

	private static void dfs(int cnt) {
		if (cnt == li.size()) {
			for (int[] m : map) {
				for (int cur : m) {
					System.out.print(cur);
				}
				System.out.println();
			}
			System.exit(0); //조건에 맞게 다 채우면 바로 종료(가장 최소값 찾는 것이므로)
		}
		int x = li.get(cnt)[0];
		int y = li.get(cnt)[1];
		boolean[] col = new boolean[10];
		boolean[] row = new boolean[10];
		boolean[] squ = new boolean[10];
		for (int i = 0; i < 9; i++) if (map[x][i] != 0) row[map[x][i]] = true;
		for (int i = 0; i < 9; i++) if (map[i][y] != 0) col[map[i][y]] = true;
		for (int i=(x/3)*3,ct=0; ct<3; i++,ct++) {
			for (int j=(y/3)*3,rt=0; rt<3; j++,rt++) {
				if (map[i][j] != 0) squ[map[i][j]] = true;
			}
		}
		// 사용한 숫자 방문처리
		
		for (int k = 1; k < 10; k++) { //한번도 사용하지 않은 숫자 넣어보기
			if(!col[k] && !row[k] && !squ[k]) {
				map[x][y] = k;
				dfs(cnt+1);
				map[x][y] = 0;
			}
		}
	}
}
