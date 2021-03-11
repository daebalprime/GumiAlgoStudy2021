package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2447_별찍기10_구미_4_이동현 {
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}
		recur(0,0,N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static void recur(int x, int y ,int size) {
		if (size == 1) {
			map[x][y] = '*';
			return;
		}
		
		int divide = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) continue;
				recur(x+divide*i, y + divide*j, divide);
			}
		}
	}
}
