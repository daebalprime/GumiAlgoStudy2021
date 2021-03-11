package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1012_유기농배추_구미_4_이동현 {
	static int N, M, K, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 0; t < T; t++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = stoi(st.nextToken());
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());
			int x,y;
			arr = new int[N][M];
			visited = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				y = stoi(st.nextToken());
				x = stoi(st.nextToken());
				arr[x][y] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == true || arr[i][j] == 0) continue;
					if (arr[i][j] == 1) {
						bfs(i, j);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void bfs(int x, int y) {
		int nx, ny;
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		while (!q.isEmpty()) {
			int[] tmp = new int[2];
			tmp = q.poll();
			x = tmp[0];
			y = tmp[1];
			for (int i = 0; i < 4;i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (0 <= nx && 0 <= ny && nx <N && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
