package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_12865_평범한배낭 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> li = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			li.add(new int[] {w, v});
		}
		
		int[][] dp = new int[n+1][k+1];
		for(int i = 0; i < n; i++) { //짐
			int[] cur = li.get(i);
			for(int j = 0; j <= k; j++) { //무게
				if(j >= cur[0]) {
					dp[i+1][j] = Math.max(dp[i][j], dp[i][j-cur[0]]+cur[1]);
				}
				else {
					dp[i+1][j] = dp[i][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
