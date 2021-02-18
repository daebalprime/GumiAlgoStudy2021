package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1256 {
	static long[] arr;
	static int N, M;
	static long K;
	static long cnt;
	static boolean escape;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[M+1]; // z 사이에 a 집어넣기
		
		solution_dp();
		
		// brute force는 시간초과뜸..
//		solution(0, 0);		
//		if(cnt < K) {
//			System.out.println("-1");
//		}
		
	}
	
	static void solution_dp() {
		// 이항 계수 구하기
		// n+m 길이의 배열에서 z를 어디에 넣을건지 경우의 수
		long dp[][] = new long[N+M+1][M+1];
		StringBuilder sb = new StringBuilder();
		
		dp[0][0] = 1;
		
		for(int i=1;i<=N+M;i++) {
			dp[i][0] = 1;
			for(int j=1;j<=M && j <i;j++) {
				// 이항계수 점화식 : nCm + nC(m+1) = (n+1)C(m+1) 
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);
				if(dp[i][j] > 1000000000) dp[i][j] = 1000000000;
			}
			if(i <= M) { // 이항 계수 한줄의 맨 끝은 1이어야 함.
				dp[i][i] = 1;
			}
		}
		
		// K가 가능한 경우의 수보다 크면 -1 출력
		if(K > dp[N+M][M]) {
			System.out.println("-1");
			return;
		}
		
		int m = M;
		long k = K;
		k--;
		// a와 z 배치
		// 처음에는 N+M 길이의 공간에서 시작해 문자를 붙일수록 공간 크기를 1씩 줄인다.
		for(int i=N+M-1;i>=0;i--) {
			// i번째 공간에 넣을 문자 결정하기
			// i개 공간에 m개를 넣는 경우의 수가 k보다 작으면 'a'넣기
			// 제한조건: i개 공간에 m개를 넣어야 하니까 i는 m보다 같거나 커야 한다.
			if(k < dp[i][m] && i >= m) {
				sb.append("a");
			}
			// i개 공간에 m개를 넣는 경우의 수가 k보다 크면 'z'넣기
			// i번째 공간에 z를 넣었을때 i부터 끝까지 만들 수 있는 문자의 경우의 수는 
			// i개 공간에 m개의 'z'를 넣는 경우의 수이다.
			// 그러면 순서는 dp[i][m]만큼 밀린다. (지금 순서 앞에 dp[i][m]개 만큼의 경우가 있다는 의미)
			else {
				sb.append("z");
				// k는 앞으로 밀려야할 순서다. dp[i][m]만큼 밀렸으니 k-dp[i][m]만큼만 더 밀리면 된다.
				k -= dp[i][m];
				// i번째 공간에 하나를 넣었으니 앞으로 넣을 z의 개수를 감소시킨다.
				m--;
			}
		}
		
		if(sb.length() < M+N) {
			System.out.println("-1");
		}else {
			System.out.println(sb);
		}
	}
	
	
	
	// brute force
	static void solution(int index,int total) {
		if(escape) return;
		if(total == N) {
			cnt++;
			//System.out.println(Arrays.toString(arr));

			if(cnt == K) {
				
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<=M;i++) {
					for(int j=0;j<arr[i];j++) {
						sb.append("a");
					}
					if(i!= M)
						sb.append("z");
				}
				System.out.println(sb);
				escape = true;
			}
			return;
		}
		
		// 현재 자리 선택
		arr[index] ++;
		solution(index,total+1);
		arr[index]--;
		// 다음 자리로 넘어가기
		if(index<M) {
			solution(index+1, total);
		}
	}

}
