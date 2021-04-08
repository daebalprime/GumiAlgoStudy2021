package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_1389_케빈베이커의6단계법칙_구미_4_이동현 {
	static int N, M, min = Integer.MAX_VALUE, minIdx;
	static int[][] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		dist = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			dist[x][y] = 1; dist[y][x] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <=N; j++) {
				if (i!=j && dist[i][j]==0) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				if (k == s) continue;
				for (int e = 1; e <= N; e++) {
					if (s == e || k == e) continue;
					if (dist[s][k]!=Integer.MAX_VALUE && dist[k][e]!=Integer.MAX_VALUE) {
						dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j<=N; j++) {
				if (i == j) continue;
				sum+=dist[i][j];
			}
			if (sum < min) {
				minIdx = i;
				min = sum;
			}
 		}
		System.out.println(minIdx);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
