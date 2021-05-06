package bj_17845;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[K+1][N+1];
		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			for(int j = 0; j < N+1; j++) {
				if(j >= weight) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[K][N]);
	}
}
