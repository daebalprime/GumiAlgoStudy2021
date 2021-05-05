package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 5] 수강 과목
//https://www.acmicpc.net/problem/17845
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_17845_수강과목_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_17845"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//최대 공부시간 N 1~1만, 과목수 K 1~1000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		//중요도가 최대가 되도록 과목을 선택했을 때, 최대가 되는 중요도를 출력
		int[][] dp = new int[n+1][k+1]; //[현재 공부시간][k번째 과목을 고려함] = 현재까지 k개를 고려했을 때 최대 중요도
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int value = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n+1; j++) {
				//시간 초과
				if(j-time < 0) {
					dp[j][i] = dp[j][i-1];
					continue;				
				}
				
				//현재 j 시간일 때, k번째 과목이 새로 생겼다.
				//j-time시간이면서 k-1번째 과목+이번 과목까지 고려한 최적값
				//vs
				//j 시간이면서 k-1번쨰 과목까지 고려한 최적값.
				if(dp[j-time][i-1] + value > dp[j][i-1]) {
					
					dp[j][i] = dp[j-time][i-1] + value;
				}else {
					dp[j][i] = dp[j][i-1];
				}
			}
			
			for (int j = 1; j < n+1; j++) {
				if(dp[j-1][i] > dp[j][i]) dp[j][i] = dp[j-1][i];
			}
		}
		System.out.println(dp[n][k]);
		
		br.close();
	}
}
