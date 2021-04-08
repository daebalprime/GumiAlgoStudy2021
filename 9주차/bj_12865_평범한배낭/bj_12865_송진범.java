package bj.dp;

import java.io.*;
import java.util.*;

public class bj_12865_송진범 {

	static int N, W;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		int[][] dp = new int[W+1][N+1];
		int [] weight = new int[N+1];
		int [] profit = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			profit[i] = sc.nextInt();
		}
		
		for (int w = 1; w <= W; w++) {
			for (int n = 1; n <= N; n++) {
				if(w >= weight[n]) {
					dp[w][n] = Math.max(dp[w][n-1], dp[w-weight[n]][n-1] + profit[n]);
				}else {
					dp[w][n] = dp[w][n-1];
				}
			}
			System.out.println(w);
			for (int i = 0; i <= W; i++) {
				System.out.println(Arrays.toString(dp[i]));
			}
		}
		System.out.println(dp[W][N]);
	}
}
