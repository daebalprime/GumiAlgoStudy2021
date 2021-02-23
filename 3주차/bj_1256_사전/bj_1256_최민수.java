package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//접근 방식은 맞았는데 코드가 너무 안짜져서 이 코드 참고함.
//https://real-012.tistory.com/99

//[골드3] 사전
//https://www.acmicpc.net/problem/1256
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1256_최민수 {
	
	static int[][] comb;
	
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1256"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		//a 갯수 1~100
		int N = Integer.parseInt(st.nextToken());
		//z 갯수 1~100
		int M = Integer.parseInt(st.nextToken());
		// k번쨰는? 1~10억
		int K = Integer.parseInt(st.nextToken());
		
		comb = new int[N+M+1][M+1];
		//DP를 위한 조합 값 저장
		comb[0][0] = 1;
		for (int i = 1; i <= N+M; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= M && j <= i; j++) {
				if (i == j) {
					comb[i][j] = 1;
					continue;
				}
				
				//조합의 정의.
				comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
				//10억을 넘는 경우를 생각해보자.
				//주어진 문자열이 10억 1번째 원소가 주어질 일은 없다.
				//그럼 계산 과정에서 10억이 넘는다는 건데
				//10억이 넘는건 주어지지 않을테니 계산할 필요도 없다.
				if(comb[i][j] >= 1000000000) comb[i][j] = 1000000000;
			}
		}

		//이걸 왜 뺐을까?
		//1, 1, 3로 생각해보자. (1, 1의 경우 2가지가 최대 경우의 수다)
		//그러면 K는 2가 되고 2 >= 2C1 = 2
		K--;
		//조합 최대값을 K가 넘으면 -1
		if(K >= comb[N+M][M]) sb.append("-1");
		else {
			for (int i = N+M-1; i >= 0; i--) {
				if(i >= M && comb[i][M] > K) sb.append("a");
				else {
					sb.append("z");
					K -= comb[i][M];
					M--;
				}
			}
		}
		//출력
		System.out.println(sb);

		br.close();
	}
}

// 1. 재귀함수로 구현한 조합(combination) method -> 시간초과