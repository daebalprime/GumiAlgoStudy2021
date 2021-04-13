package bj.gold;

import java.util.*;
import java.io.*;

public class bj_20208_진우의민트초코우유 {
	static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static int N, M, H, max;
	static Pos home;
	static ArrayList<Pos> mincho;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 마을 크기
		M = Integer.parseInt(st.nextToken()); // 진우 초기 체력
		H = Integer.parseInt(st.nextToken()); // 민초 체력 회복량
		map = new int[N][N];
		mincho = new ArrayList<>();
		max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 진우 집
				if (map[i][j] == 1) {
					home = new Pos(i, j);
				}
				// 민초 위치
				else if (map[i][j] == 2) {
					mincho.add(new Pos(i, j));
				}
			}
		}
		
		visited = new boolean[mincho.size()];
		dfs(home, M, 0);
		
		System.out.println(max);
		
		
		br.close();
	}
	
	static void dfs(Pos cur, int hp, int cnt) {
		if (getDist(home, cur) <= hp) {
			max = max > cnt ? max : cnt;
		}
		
		for (int i = 0; i < mincho.size(); i++) {
			if (!visited[i] && getDist(cur, mincho.get(i)) <= hp) {
				visited[i] = true;
				dfs(mincho.get(i), hp - getDist(cur, mincho.get(i)) + H, cnt + 1);
				visited[i] = false;				
			}
		}
	}
	
	static int getDist(Pos cur, Pos target) {
		return Math.abs(cur.x - target.x) + Math.abs(cur.y - target.y);
	}
}


// 진우 집 1, 민초 2, 빈땅 0
// 두 점 사이 거리 구해서 현재체력보다 작거나 같으면 이동 가능
// 이동 후 집으로 올 수 있는지 체크, 올 수 있으면 최댓값 갱신.. 못와도 다른 민초로 이동 되면 계속 이동
