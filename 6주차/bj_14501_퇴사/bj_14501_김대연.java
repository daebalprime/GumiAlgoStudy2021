package bj_14501;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][2];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken())-1;
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		for(int i = 0; i < N; i++) {
			int nxt = table[i][0] + i;
			if(nxt < N) {
				dp[i] = table[i][1];
			}
			else {
				continue;
			}
			for(int j = 0; j < N; j++) {
				if(table[j][0]+j < i) {
					dp[i] = Math.max(dp[i], dp[j]+table[i][1]);
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}
}
