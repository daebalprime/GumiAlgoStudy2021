package bj_gold;

import java.io.*;
import java.util.*;
public class bj_11066_김소빈{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			int[] prefixSum = new int[n+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				prefixSum[i] = prefixSum[i-1]+arr[i];
			}
			int[][] dp = new int[n+1][n+1];
			for(int i = 1; i < n; i++) {
				dp[i][i+1] = arr[i]+arr[i+1]; // i번째부터 i+1번째까지 합 (두 수의 합)
			}
			
			for(int k = 1; k <= n; k++) { //몇 장 묶을지
				for(int from = 1; from+k <= n; from++) {
					int to = from+k;
					dp[from][to] = Integer.MAX_VALUE; //초기화
					for(int i = from; i < to; i++) { //from부터 to까지
						int tmp = dp[from][i]+dp[i+1][to] + prefixSum[to]-prefixSum[from-1]; 
						// from부터i까지 합치는데 드는 비용+ i+1부터 to까지 합치는데 드는 비용 + from부터 to까지의 누적합
						dp[from][to] = Math.min(dp[from][to], tmp);
					}
				}
			}
			System.out.println(dp[1][n]);
		}
	}
}