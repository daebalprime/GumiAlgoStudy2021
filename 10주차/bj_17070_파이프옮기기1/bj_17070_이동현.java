package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17070_파이프옮기기1_구미_4_이동현 {
	static int N, count;
	static int[][] map;
	static boolean[][] visited;
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
		map[0][0] = -1; map[0][1] = -1;
		visited[0][0] = true; visited[0][1] = true;
		dfs(0,1,-1);
		System.out.println(count);
	}
	// -1 : 가로  		0: 대각선 		1 : 세로
	static void dfs(int x, int y, int vec) {
		if (x == N-1 && y == N-1) {
			count++;
			return;
		}
		
		map[x][y] = -1;

		
		if (vec == -1) {
			if (check(x,y+1)) dfs(x, y + 1, -1);
			if (check(x+1,y+1) &&check(x+1,y) &&check(x,y+1)) dfs(x+1, y+1, 0);
		} else if (vec == 0) {
			if (check(x,y+1)) dfs(x, y+1, -1);
			if (check(x+1,y)) dfs(x+1,y,1);
			if (check(x+1,y+1) &&check(x+1,y) &&check(x,y+1)) dfs(x+1,y+1,0);
		} else {
			if (check(x+1,y)) dfs(x+1, y, 1);
			if (check(x+1,y+1) &&check(x+1,y) &&check(x,y+1)) dfs(x+1,y+1,0);
		}
		map[x][y] = 0;
	}
	static boolean check(int x, int y) {
		if (0<=x && x<N && 0<=y && y < N && map[x][y] != 1) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
