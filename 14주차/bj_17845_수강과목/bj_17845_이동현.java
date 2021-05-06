package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17845_수강과목_구미_4_이동현 {
	static int N,K;
	static long result;
	static int[][] costs;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N 최대 공부시간				K 과목 수
		N = stoi(st.nextToken()); K = stoi(st.nextToken());
		
		costs = new int[K+1][2];
		dp = new long[K+1][N+1];
		
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i][1] = stoi(st.nextToken());
			costs[i][0] = stoi(st.nextToken());
		}
		// 1번이 중요도 0번이 무게
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (j - costs[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i][0]] + costs[i][1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
 		}
		System.out.println(dp[K][N]);
	}
	static int stoi(String s ) {
		return Integer.parseInt(s);
	}

}
