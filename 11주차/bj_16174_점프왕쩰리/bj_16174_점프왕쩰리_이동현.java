package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16174_점프왕쩰리_구미_4_이동현 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		bfs();
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 2; i++) {
				int nx = cur[0] + dx[i] * map[cur[0]][cur[1]];
				int ny = cur[1] + dy[i] * map[cur[0]][cur[1]];
				if (isAvailable(nx,ny)) {
					if (map[nx][ny] == -1) {
						System.out.println("HaruHaru");
						return;
					}
					q.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		System.out.println("Hing");
		return;
	}
	static boolean isAvailable(int x , int y) {
		if (0<=x && x < N && 0 <= y && y < N && x <=N-1 && y <= N-1 && !visited[x][y]) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
