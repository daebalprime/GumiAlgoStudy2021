package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_17845_수강과목 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); //최대 공부시간
		int k = Integer.parseInt(st.nextToken()); //과목 수
		
		int[][] info = new int[k+1][2];
		for(int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken()); //중요도
			info[i][1] = Integer.parseInt(st.nextToken()); //공부시간
		}
		
		int[][] dp = new int[k+1][n+1];
		for(int i = 1; i <= k; i++) { //i과목
			int imp = info[i][0], time = info[i][1];
			for(int j = 1; j <= n; j++) { //j시간
				if(time <= j) {
					dp[i][j] = Math.max(imp+dp[i-1][j-time], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[k][n]);
	}
}
