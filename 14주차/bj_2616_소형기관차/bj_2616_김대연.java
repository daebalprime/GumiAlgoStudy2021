package bj_2616;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] passengers = new int[N];
		int[] sum = new int[N];
		int[][] dp = new int[4][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			passengers[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				sum[0] = passengers[i];
			}else {
				sum[i] = sum[i-1]+passengers[i];
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int j = 1; j < 4; j++) {
			for(int i = 0; i < N; i++) {
				if(i>=M) {
					dp[j][i] = Math.max(Math.max(dp[j-1][i], dp[j-1][i-M]+getSum(sum,i,M)),dp[j][i-1]);
				}
				else {
					dp[j][i] = Math.max(dp[j-1][i], getSum(sum,i,M));
//					dp[j][i] = dp[j-1][i];
				}
			}
		}
		System.out.println(dp[3][N-1]);
		br.close();
	}
	static int getSum(int[] sum, int idx, int M) {
		if(idx < M) return sum[idx];
		else return sum[idx]-sum[idx-M];
	}
}
