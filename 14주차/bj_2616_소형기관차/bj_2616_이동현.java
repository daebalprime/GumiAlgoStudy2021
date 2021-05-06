package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2616_소형기관차_구미_4_이동현 {
	static int N, max, answer = Integer.MIN_VALUE;
	static int[][] dp;
	static int[] sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		sum = new int[N+1];
		dp = new int[4][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		sum[0] = 0;
		for (int i = 0; i < N; i++) {
			sum[i+1] = sum[i] + stoi(st.nextToken());
		}
		max = stoi(br.readLine());
		for (int i = 1; i < 4; i++) {
			for (int j = i*max; j <= N; j++) {
				if (j - max >= 0) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max] + (sum[j] - sum[j-max]));
				}
			}
		}
		System.out.println(dp[3][N]);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
