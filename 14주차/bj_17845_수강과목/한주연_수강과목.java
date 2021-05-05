/*
수강 과목
https://www.acmicpc.net/problem/17845
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, k, result;
	static int[][] dp;
	static int[][] reward;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	k = stoi(stk.nextToken());
    	
    	reward = new int[k + 1][2];
    	dp = new int[k + 1][n + 1];
    	int I,T;
    	for(int i = 1; i <= k; i++) {
    		stk = new StringTokenizer(br.readLine());
    		I = stoi(stk.nextToken());
    		T = stoi(stk.nextToken());
    		reward[i][0] = I;		// 중요도
    		reward[i][1] = T;		// 공부 시간
    	}
    	
    	for(int i = 1; i <= k; i++) {
    		for(int j = 1; j <= n; j++) {
    			dp[i][j] = dp[i - 1][j];	// 현재 무게에서 이전까지 과목을 담은 최대 중요도를 넣는다.
    			if(reward[i][1] <= j) {		// 현재 과목을 넣을 수 있으면 이전까지 넣은 최대 중요도에서 추가한다
    				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - reward[i][1]] + reward[i][0]);	// 비교
    			}
    		}
    	}
    	
    	System.out.println(dp[k][n]);
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}