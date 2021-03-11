package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16967_배열복원하기_구미_4_이동현 {
	static int H,W,X,Y;
	static int[][] A;
	static int[][] B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		H = stoi(st.nextToken());
		W = stoi(st.nextToken());
		X = stoi(st.nextToken());
		Y = stoi(st.nextToken());
		A = new int[H][W];
		B = new int[H+X][W+Y];
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				int num = stoi(st.nextToken());
				B[i][j] = num;
				if (0 <= i && i < H && 0 <= j && j < W && X <= i && i < H+X && Y <= j && j < W+Y) {
					A[i][j] = B[i][j] - A[i - X][j - Y];
				} else if (0 <= i && i < H && 0 <= j && j < W && !(X <= i && i < H+X && Y <= j && j < W+Y)) {
					A[i][j] = B[i][j];
				} else if (!(0 <= i && i < H && 0 <= j && j < W ) && X <= i && i < H+X && Y <= j && j < W+Y) {
					A[i - X][j - Y] = B[i][j];
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
