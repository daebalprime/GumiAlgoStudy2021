package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14499_주사위굴리기_구미_4_이동현 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] horizontal, vertical;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		x = stoi(st.nextToken()); y = stoi(st.nextToken());
		K = stoi(st.nextToken());
		map = new int[N][M];
		horizontal = new int[4];
		vertical = new int[4];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = stoi(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int com = stoi(st.nextToken());
			switch(com) {
			case 1:
				solution(3, com);
				break;
			case 2:
				solution(2, com);
				break;
			case 3:
				solution(0, com);
				break;
			case 4:
				solution(1, com);
				break;
			}
		}
		
	}
	static void solution(int dir, int com) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (!isRange(nx,ny)) return;
		move(com);
		if (map[nx][ny] == 0) {
			map[nx][ny] = vertical[0];
		} else {
			vertical[0] = map[nx][ny];
			horizontal[0] = map[nx][ny];
			map[nx][ny] = 0;
		}
		x = nx; y = ny;
		System.out.println(vertical[2]);
	}
	static void move(int com) {
		if (com == 1) { // 동쪽
			int tmp = horizontal[0];
			for (int i = 0; i < 3; i++) {
				horizontal[i] = horizontal[i+1];
			}
			horizontal[3] = tmp;
			vertical[0] = horizontal[0];
			vertical[2] = horizontal[2];
		} else if (com == 2) { // 서쪽
			int tmp = horizontal[3];
			for (int i = 3; i > 0; i--) {
				horizontal[i] = horizontal[i-1];
			}
			horizontal[0] = tmp;
			vertical[0] = horizontal[0];
			vertical[2] = horizontal[2];
		} else if (com == 3) { // 북쪽
			int tmp = vertical[0];
			for (int i = 0; i < 3; i++) {
				vertical[i] = vertical[i+1];
			}
			vertical[3] = tmp;
			horizontal[0] = vertical[0];
			horizontal[2] = vertical[2]; 
		} else if (com == 4) { // 남쪽
			int tmp = vertical[3];
			for (int i = 3; i > 0; i--) {
				vertical[i] = vertical[i-1];
			}
			vertical[0] = tmp;
			horizontal[0] = vertical[0];
			horizontal[2] = vertical[2];
		}
	}
	static boolean isRange(int nx, int ny) {
		if (0<= nx && nx < N && 0<= ny && ny <M) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
