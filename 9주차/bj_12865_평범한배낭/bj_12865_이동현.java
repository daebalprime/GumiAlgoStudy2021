package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_12865_평범한배낭_구미_4_이동현 {
	static int[][] costs;
	static int[][] dp;
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		costs = new int[N+1][2];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i] = new int[] {stoi(st.nextToken()),stoi(st.nextToken())};
		}
		
		Arrays.fill(dp[0], 0);
		for (int i = 0; i <= N; i++) dp[i][0] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - costs[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i][0]] + costs[i][1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		//for(int[] a : dp)System.out.println(Arrays.toString(a));
		System.out.println(dp[N][K]);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
