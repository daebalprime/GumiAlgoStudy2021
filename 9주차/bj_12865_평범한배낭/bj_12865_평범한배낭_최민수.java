package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 5] 평범한 배낭
//https://www.acmicpc.net/problem/12865
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_12865_평범한배낭_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_12865"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N개의 물건, 무게 W, 가치 V
		//V가 최대가 되도록
		//무게는 최대 K까지 가능
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//n 1~100
		int n = Integer.parseInt(st.nextToken());
		//k 1~10만
		int k = Integer.parseInt(st.nextToken());
		
		int[][] item = new int[n+1][2]; //1번부터 담을 것임
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//무게 w 1~10만
			item[i][0] = Integer.parseInt(st.nextToken());
			//가치 v 0~1000
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//[i][j] 무게가 j이고, 물건을 i개 담았을 때 최대 가치
		int[][] dp = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) { //1번 물건부터
			//물건을 하나 선택하고
			//그 물건이 들어가서 이득인지 안들어가야 이득인지 갱신한다.
			
			for (int j = 1; j < k+1; j++) {
				if(item[i][0] <= j) { //이번 물건이 가방 최대 무게보다 작으면 1. 넣거나, 2. 안넣거나 선택할 수 있다.
					//item[i][1] : 이번 물건의 가치
					//dp[i-1][j-item[i][0]] : 이번 물건의 무게를 빼고, 물건 -1개 였을 때 최고 가치
					//dp[i-1][j] : 이번 물건을 포함하지 않았을 때 최고 가치
					dp[i][j] = Math.max(item[i][1] + dp[i-1][j-item[i][0]], dp[i-1][j]);
					
				}else { //이번 물건이 가방 최대 무게보다 크기 때문에, 이전 dp값을 땡겨온다.
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
//		for(int[] ii: dp)System.out.println(Arrays.toString(ii));
		System.out.println(dp[n][k]);
		
	
		br.close();
	}
}
