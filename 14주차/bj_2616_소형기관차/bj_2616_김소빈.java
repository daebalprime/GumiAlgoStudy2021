package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_2616_소형기관차 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		//입력 완료
		int [] sum = new int[n+1];
		for(int i = 1; i <= n; i++) {
			sum[i] += sum[i-1]+nums[i-1];
		}
//		System.out.println(Arrays.toString(sum));
		
		int [][] dp = new int[4][n+1];
		for(int i = 1; i < 4; i++) { //소형차의 개수
			for(int j = i*k; j <= n; j++) { //객차 수 -> i개의 소형차가 j개를 끄는 경우 최대값
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k]+(sum[j]-sum[j-k]));
								  //i개의 소형차가 j-1개의 소형차를 끄는 경우와
											  //i개의 소형차가 j개의 소형차를 끄는 경우 비교
				//j에서 j-k를 빼면 j-k칸부터 j칸까지의 합이 나온다 (k의 객차)
			}
		}
		
//		for(int[] d: dp) System.out.println(Arrays.toString(d));
		System.out.println(dp[3][n]);
	}
	//넘 어렵당 ㅠㅠ
}
