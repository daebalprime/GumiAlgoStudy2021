/*
소형기관차
https://www.acmicpc.net/problem/9466
*/


import java.util.*;
import java.io.*;

public class Main {
	static int n, result, max;
	static int[] train;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	train = new int[n + 1];
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		train[i] = stoi(stk.nextToken()) + train[i - 1];
    	}
    	max = stoi(br.readLine());
    	
    	dp = new int[4][n + 1];
    	
    	for(int i = 1; i <= 3; i++) {
    		for(int j = i * max; j <= n; j++) {
    			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - max] + (train[j] - train[j - max]));
    		}
    	}
    	
    	System.out.println(dp[3][n]);
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}