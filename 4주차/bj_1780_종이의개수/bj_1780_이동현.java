package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_1780_종이의개수_구미_4_이동현 {
	static int N, x, y, a1,a2,a3;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		solve(x, y, N);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
	private static void solve(int x, int y, int size) {
		int tmp = map[x][y];
		boolean flag = true;
		
		loop:for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (tmp != map[x+i][y+j]) {
					flag = false;
					break loop;
				}
			}
		}
		if (flag) {
			if (tmp == -1) a1+=1; 
			else if (tmp == 0) a2+=1; 
			else if (tmp == 1) a3+=1; 
			return;
		}
		int half = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(x+half*i , y + half*j, half);
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
