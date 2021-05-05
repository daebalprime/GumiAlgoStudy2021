package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[골드 4] 소형기관차
//https://www.acmicpc.net/problem/2616
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2616_소형기관차_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2616"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//A~B구간에서의 DP 최적?
		//A~B+1이 추가되면? = 원래 해에서 B+1을 포함하는 경우의 수가 큰지 아닌지만 알면 된다.
		
		//객차의 수 n: ~5만
		int n = Integer.parseInt(br.readLine());
		
		int[] passenger = new int[n+1];
		int[][] dp = new int[n+1][4]; //n이 마지막 객차인 경우의 최적값 //[1]: 1개일때, [2] 2개일때, ...
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			passenger[i] = Integer.parseInt(st.nextToken());
		}
		
		//소형객차 길이 m
		int m = Integer.parseInt(br.readLine());
		
		//전 구간에 대한 소형 객차 1개일떄의 최적값
		int slidingVal = 0;
		for (int i = 1; i <= n; i++) {
			if(i <= m) {
				dp[m][1] += passenger[i];
				slidingVal = dp[m][1];
			}else {
				//새로 추가된 애랑, 자기랑 비교한다.
				//슬라이딩을 한다.
				// 1 2 3 4 
				slidingVal += (passenger[i] - passenger[i-m]);
				if(slidingVal > dp[i-1][1]) dp[i][1] = slidingVal;
				else dp[i][1] = dp[i-1][1];
			}
		}
		
		//전 구간에 대한 소형 객차 2개일떄의 최적값
		//m+1 ~ 2*m ->  1칸씩 땅김. 왜냐하면 밑에 for문에서 1개씩 옮길꺼야
		slidingVal = 0;
		for (int i = m; i < 2*m; i++) {
			slidingVal += passenger[i];
		}
		for (int i = 2*m; i <= n; i++) {
			slidingVal += (passenger[i] - passenger[i-m]);
			if(slidingVal + dp[i-m][1] > dp[i-1][2]) dp[i][2] = slidingVal + dp[i-m][1];
			else dp[i][2] = dp[i-1][2];
		}
		
		//전 구간에 대한 소형 객차 3개일떄의 최적값
		slidingVal = 0;
		//2m+1 ~ 3m
		for (int i = 2*m; i < 3*m; i++) {
			slidingVal += passenger[i];
		}
		for (int i = 3*m; i <= n; i++) {
			slidingVal += (passenger[i] - passenger[i-m]);
			if(slidingVal + dp[i-m][2] > dp[i-1][3]) dp[i][3] = slidingVal + dp[i-m][2];
			else dp[i][3] = dp[i-1][3];
		}
		
		
		//소형 기관차 3대를 이용하여 최대로 운송할 수 있는 손님 수
		System.out.println(dp[n][3]);
		
		br.close();
	}
}
//접근 방식은 소형을 각각 선택하기 또는 빈칸을 각각 선택하기인데
//빈칸의 경우엔 잘못선택하면 소형 기관차 3대를 온전히 못선택할수도 있으니 제외

//그리디는 안됨. 예제부터 바로 반례