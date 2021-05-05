package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[골드 3] 앱
//https://www.acmicpc.net/problem/7579
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_7579_앱_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_7579"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//N개의 앱이 활성화
		//각각 m바이트만큼 메모리 사용
		//재활성화 비용 c
		//B앱을 실행하려는데 추가로 M바이트가 필요하다.
		//몇개를 비활성화해서 c 합이 최소화하여 M을 확보해야함.
		
		//활성화 앱 수 apps(N), 필요한 메모리 needMemory(M)바이트
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int apps = Integer.parseInt(st.nextToken());
		int needMemory = Integer.parseInt(st.nextToken());
		
		//현재 활성화된 앱이 사용중인 메모리, useMemory
		int[] useMemory = new int[apps+1];
		//재활성화 비용, reactivate
		int[] reactivate = new int[apps+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= apps; i++) {
			//만약에 reactivate값이 0이면 앞으로 연산에서 제외하는 대신 필요 메모리를 깎자.
			useMemory[i] = Integer.parseInt(st.nextToken());
			reactivate[i] = Integer.parseInt(st2.nextToken());
			if(reactivate[i] == 0) {
				needMemory -= useMemory[i];
				reactivate[i] = -1;
			}
		}
				
		//냅색느낌?
		//한 축은 app의 숫자, 한 축은 reactive 비용, 값은 확보한 메모리
		int[][] dp = new int[apps+1][10001]; //앱 100개, 각각 최대비용 100
		for (int i = 1; i <= apps; i++) {
			//이번에 고른 앱의 재활성 비용이 -1이면 스킵해야 한다.
			if(reactivate[i] == -1) {
				for (int j = 0; j <= 10000; j++) {
					dp[i][j] = dp[i-1][j];
				}
			}else {
				for (int j = 0; j <= 10000; j++) {
					//1) 현재 고른 앱의 재활성화 비용보다 j가 작을 때는 그대로 사용
					if(j < reactivate[i]) dp[i][j] = dp[i-1][j];
					//재활성화 비용(R)을 감당할 수 있으면
					// j - R위치의 메모리 + 현재 앱의 메모리 VS i-1번째 앱까지 고려한 j비용의 메모리를 비교한다.
					// 현재 앱을 사용한다면 갱신하고
					else if(dp[i-1][j-reactivate[i]] + useMemory[i] > dp[i-1][j]) dp[i][j] = dp[i-1][j-reactivate[i]] + useMemory[i];
					// 현재 앱을 사용 안한다면 i-1번쨰 값을 가져온다.
					else dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		for (int i = 0; i <= 10000; i++) {
			if(dp[apps][i] >= needMemory) {
				System.out.println(i);
				break;
			}
		}
		
		br.close();
	}
}

//N이 100개이다. 100의 부분집합의 개수는 2^100 = 1000^10 = 10^30
//메모리 순으로 정렬해도, 재활성화 비용으로 정렬해도 일관성이 없다.