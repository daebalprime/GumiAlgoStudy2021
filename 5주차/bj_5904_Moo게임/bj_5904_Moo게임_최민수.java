package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//참고한 블로그: https://tunafish78.tistory.com/75

//[실버1] Moo 게임
//https://www.acmicpc.net/problem/5904
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_5904_Moo게임_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_5904"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		아이디어 1. s(k)를 3부분으로 나눠, n이 어디에 속하는지 확인하면서 점차 작은 s(k-1)을 찾을 것이다. s(k)는 s(k-1) + o가 k+2개 + s(K-1) 이와 같이 구성되어 있다.
//
//		아이디어 2. 아이디어 1을 시행하기 위해선 s(k)의 길이, s(k-1)의 길이가 필요하다. 따라서 s(0)부터 s(k)까지 길이를 어딘가에 저장해두어야 한다. 나는 stack을 사용했다.
//
//		아이디어 3. 사실 s(k)까지 찾을 필요 없다. s(x)의 길이가 n을 갓 초과했을때까지만 찾으면 된다. 왜냐하면 k가 9999999...9999999일 때나 갓 초과했을 때나 n 위치의 문자는 동일하기 때문이다. (그 이유는 s(k)의 정의를 보면 된다.)
		
		//n 1~10^9 10 0000 0000 = 10억, int 범위 안
		// -1로 0번쨰 index 찾기
		int n = Integer.parseInt(br.readLine()) - 1;

		int count = 0;
		int length = 3;
		
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack.offer(3);
		//아이디어 2, 3
		//n번째 원소 찾는데, -1을 해줘서 <=
		while(length <= n) {
			length += length + (++count + 3);
			stack.offer(length);
		}
		
		//아이디어 1: 원소 찾기
		// => 참고한 아이디어: s(k)를 3부분으로 나눠, n이 어디에 속하는지 확인하기
		//자세한 것은 맨 윗부분 주석의 블로그를 참고
		int current = 0, before = 0;
		while(!stack.isEmpty()) {
			//현재 s(k)의 길이
			current = stack.pollLast();

			if(!stack.isEmpty()) before = stack.peekLast();
			else before = 0;
			//마지막 부분
			if(n >= current - before ) {
				n -= (current - before);
			}else if(n >= 0 && n < before) {
			//앞 부분 = 0~현재length - 이전length - moooo... count
				
			}else {
			//중간부분: 앞부분~현재length - 
			if(n == before) System.out.println("m");
			else System.out.println("o");
			break;				
			}
		}
		
		
		//터진 아이디어. n번째 글자를 출력해라.
		
//		// => 원소를 무한개까지 저장해야할까?
//		// => 그냥 n번째까지만 저장하면 안되나
//		// => 원소 만들마다 n초과하면 즉시 출력 및 종료
//		StringBuilder sb = new StringBuilder();
//		sb.append("moo");
//		int count = 0;
//		while(sb.length() < n) {
//			String temp = sb.toString();
//			count++;
//			sb.append("m");
//			if(sb.length() >= n) break;
//			//count+2 만큼 o 추가
//			for (int i = 0; i < count+2; i++) {
//				sb.append("o");
//				if(sb.length() >= n) break;
//			}
//			sb.append(temp);
//		}
//		//N이 1이면 0번째 출력해야함, 2면 1번쨰 출력해야함.
//		System.out.println(sb.toString().charAt(n-1));
		
		br.close();
	}
}
//StringBuilder에 10억개를 넣으니까 터진다. OutOfMemoryError
//터진것의 핵심 아이디어: n개의 문자열 길이만 있어도 충분하다.
