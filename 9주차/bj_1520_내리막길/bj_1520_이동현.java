package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1520_내리막길_구미_4_이동현 {
	static int M, N, cnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map, check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		map = new int[M][N];
		check = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				check[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
		
	}
	static int dfs(int x, int y) {
		if (x == M-1&& y == N-1) return 1;
		if (check[x][y] == -1) {
			check[x][y] = 0; // 방문체크
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isRange(nx,ny)) continue;
				if (map[nx][ny] >= map[x][y]) continue;
				check[x][y] += dfs(nx,ny);
			}
		}
		return check[x][y];
	}
	static boolean isRange(int x, int y) {
		if (0 <= x && x < M && 0 <= y && y < N) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
