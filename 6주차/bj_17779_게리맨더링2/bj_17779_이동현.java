package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17779_게리멘더링2_구미_4_이동현 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] people;
	static int[][] divide;
	static int[] psum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		people = new int[N+1][N+1];
		divide = new int[N+1][N+1];
		psum = new int[5];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				people[i][j] = stoi(st.nextToken());
			}
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				for (int d1 = 1; d1 < N+1; d1++) {
					for (int d2 = 1; d2 < N+1; d2++) {
						if (1<=i+d1 && i+d1 <= N && 1<=j-d1 && j-d1<=N 
								&& 1<=i+d2 && i+d2<=N && 1<=j+d2 && j+d2<=N
								&& 1<=i+d1+d2 && i+d1+d2 <=N && 1<=j-d1+d2 && j-d1+d2 <=N
								&& 1<=i+d2+d1 && i+d2+d1 <=N && 1<=j+d2-d1 && j+d2-d1 <=N) {
							divide = new int[N+1][N+1];
							psum = new int[5];
							for (int p = 0; p <= d1; p++) {
								divide[i + p][j - p] = 5;
								divide[i + d2 + p][j + d2 - p] = 5;
							}
							for (int q = 0; q <= d2; q++) {
								divide[i + q][j + q] = 5;
								divide[i + d1 + q][j - d1 + q] = 5;
							}
							for (int t = i + 1; t < i + d1 + d2; t++) {
								int flag = -1;
								for (int y = 1; y < N; y++) {
									if (divide[t][y] == 5) flag*= -1;
									if (flag == 1) divide[t][y] = 5;
								}
							}

							for (int r = 1; r < N+1; r++) {
								for (int c = 1; c < N+1; c++) {
									if (1<=r && r < i+d1 && 1<= c && c <= j && divide[r][c] != 5) {
										psum[0] += people[r][c];
										divide[r][c] = 1;
									} else if (1<=r && r <= i+d2 && j < c && c <=N && divide[r][c] != 5) {
										psum[1] += people[r][c];
										divide[r][c] = 2;
									} else if (i + d1 <= r && r<=N && 1<= c && c < j - d1 + d2 && divide[r][c] != 5) {
										psum[2] += people[r][c];
										divide[r][c] = 3;
									} else if (i + d2 < r && r <= N && j-d1+d2 <= c && c <=N && divide[r][c] != 5) {
										psum[3] += people[r][c];
										divide[r][c] = 4;
									} else {
										psum[4] += people[r][c];
										divide[r][c] = 5;
									}
								}
							}
							Arrays.sort(psum);
							min = Math.min(min, psum[4] - psum[0]);
						}
					}
				}
			}
		}
		System.out.println(min);
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
