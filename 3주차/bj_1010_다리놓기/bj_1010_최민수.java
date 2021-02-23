package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//[실버 5] 다리 놓기
//https://www.acmicpc.net/problem/1010
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1010_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1010"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//아이디어
		//오른쪽다리C왼쪽다리. 조합문제
		
		//테케 T
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			//다리 개수 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			BigInteger result = BigInteger.ONE;
			//3C2 = 3*2  / 2*1
			
			for (int j = M; j >= M-N+1; j--) {
				result = result.multiply(BigInteger.valueOf(j));
			}
//			System.out.println(result);
			for (int j = 1; j <= N; j++) {
				result = result.divide(BigInteger.valueOf(j));
//				System.out.println("result" + result);
			}
			
			
			//출력
			System.out.println(result);
		}
		
		
		br.close();
	}
}
