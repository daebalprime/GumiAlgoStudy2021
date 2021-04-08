package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException{
		final int INF = 987654321;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n][n];
		for(int[] d: dp) {
			Arrays.fill(d, INF);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a-1][b-1] = 1;
			dp[b-1][a-1] = 1;
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				if(i == k) continue;
				for(int j = 0; j < n; j++) {
					if(j == i || j == k) continue;
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
				}
			}
		}
		int ans = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dp[i][j] == INF || i == j) continue;
				sum += dp[i][j];
			}
			if(min > sum) {
				min = sum;
				ans = i;
			}
			sum = 0;
		}
		System.out.println(ans+1);
	}
}
