package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_14499_주사위굴리기 {
	static int[] dice = new int[7];
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k; i++) {
			int order = Integer.parseInt(st.nextToken());
			int nx = x+dx[order-1];
			int ny = y+dy[order-1];
			
			if(0<=nx&&nx<n && 0<=ny&&ny<m) {
				dice = roll(order);
				if(map[nx][ny] == 0) map[nx][ny] = dice[6];
				else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				x = nx; y = ny;
				System.out.println(dice[1]);
			}
		}
		//입력완료
		
		
	}
	private static int[] roll(int dir) {
		int[] cur = dice.clone();
		if(dir == 4) {
			cur[6] = dice[2];
			cur[2] = dice[1];
			cur[1] = dice[5];
			cur[5] = dice[6];
		}
		else if(dir == 3) {
			cur[6] = dice[5];
			cur[5] = dice[1];
			cur[1] = dice[2];
			cur[2] = dice[6];
		}
		else if(dir == 1) {
			cur[6] = dice[3];
			cur[3] = dice[1];
			cur[1] = dice[4];
			cur[4] = dice[6];
		}
		else {
			cur[6] = dice[4];
			cur[4] = dice[1];
			cur[1] = dice[3];
			cur[3] = dice[6];
		}
		return cur;
	}
}
