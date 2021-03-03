package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[실버 3] 카드 합체 놀이
//https://www.acmicpc.net/problem/15903
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_15903_카드합체놀이_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_15903"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//카드 개수 N 2~1000, 카드 합체 m: 0~15*n
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//오버플로우를 대비한 long
		long [] card = new long[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st2.nextToken());
		}
		
		//정렬하고, 0, 1번째 원소 더한 값을 0, 1번째에 넣어주기. 반복.
		for (int i = 0; i < m; i++) {
			Arrays.sort(card);
			long temp = card[0] + card[1];
			card[0] = temp;
			card[1] = temp;
		}
		
		//오버플로우를 대비한 long
		long answer = 0;
		for (int i = 0; i < card.length; i++) {
			answer += card[i];
		}
		
		//출력
		System.out.println(answer);
		
		br.close();
	}
}
