package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_7579_앱 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //n개의 앱
		int m = Integer.parseInt(st.nextToken()); //m바이트 확보해야함
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] mem = new int[n];
		for(int i = 0; i < n; i++) {
			mem[i] = Integer.parseInt(st.nextToken()); //활성화 시 필요한 메모리
		}
		st = new StringTokenizer(br.readLine(), " ");
		int[] cost = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken()); //비활성화 시 비용
			sum += cost[i];
		}
		//입력완료 
		int answer = Integer.MAX_VALUE;
		//비활성화 비용을 최소화 하면서 m바이트 만큼의 메모리를 확보해야한다.
		int dp[][] = new int[n+1][sum+1];
		
		for(int i = 1; i <= n; i++) {//i개의 앱을 삭제한다. 
			int memory = mem[i-1], c = cost[i-1];
			for(int j = 1; j <= sum; j++) {//j비용이 드는 경우 앱의 메모리를 dp배열에 저장한다
				if(c <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+memory);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				if(dp[i][j] >= m) {
//					System.out.println(j);
					answer = Math.min(answer, j);
				}
			}
		}
//		for(int[] d: dp) {
//			System.out.println(Arrays.toString(d));
//		}
		System.out.println(answer==Integer.MAX_VALUE?0:answer);
	}
}
