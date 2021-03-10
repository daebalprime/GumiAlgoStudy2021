package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//[실버 4] 퇴사
//https://www.acmicpc.net/problem/14501
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_14501_퇴사_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_14501"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =  Integer.parseInt(br.readLine());
		
		//끝나는 날을 기준으로 최대 이윤 선택하자.
		
		//입력
		//[0] 끝나는 날, [1] 금액, [2] 시작하는 날
		int arr[][] = new int[n][3];
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = i + Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = i + 1;
		}
	
		//끝나는 날 기준으로 정렬하되, 같으면 돈 비싼 것부터 정렬
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = Integer.compare(o1[0], o2[0]);
				if(diff != 0) return diff;
				return -Integer.compare(o1[1], o2[1]);
			}
		});
		
		//n일에 끝났을 떄 최대값 기록
		int dp[] = new int[n+1];
		//ArrayIndexOutOfBoundsException
		if(arr[0][0] < n+1) dp[arr[0][0]] = arr[0][1];
		
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			//dp에 기록된 i일에 끝났을 때의 최대 값 vs i번째 끝나는 일 + dp[i번째 끝나는 일의 시작일]
			if(arr[i][0] > n) continue;
			
			//1~5 50이면 50 + dp[0]
			if (dp[arr[i][0]] < arr[i][1] + dp[arr[i][2]-1]) {
				dp[arr[i][0]] = arr[i][1] + dp[arr[i][2]-1];
			}
			//dp 업데이트. 자기보다 작은게 있으면 업데이트
			//조금 더 잘코딩하면 필요한 부분만 하기
			for (int j = 1; j < dp.length; j++) {
				if(dp[j] < dp[j-1]) dp[j] = dp[j-1];
			}
		}
		System.out.println(dp[n]);
		
		br.close();
	}
}

// activity-selection problem으로 접근했으나 가중치 때문에 greedy로 풀리지 않음.
