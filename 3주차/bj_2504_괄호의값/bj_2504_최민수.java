package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/*
정말 끔찍한 하드 코딩입니다.
if-else로 모든 경우를 다 걸러냈어요.
그런 끔찍한 코드를 혹시나 해석하고 싶으신 분을 위한 간단 설명
입력을 받는 순간 0을 확정 지을 수 있으면 0만들고 break
그렇지 않으면 일반 괄호 처리
숫자로 변하는 경우 곱셈 다하고,
자기 앞이 숫자면(while) 계속 +했습니다.
 */

//[실버 2] 괄호의 값
//https://www.acmicpc.net/problem/2504
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2504_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2504"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayDeque<String> stack = new ArrayDeque<String>();
		
		String[] temp = br.readLine().split("");
		
		int answer = 0;
	
		for (int i = 0; i < temp.length; i++) {
//			System.out.print(i);
//			System.out.println(stack.toString());
			
			if(temp[i].equals("(") || temp[i].equals("[")) {
				stack.offer(temp[i]);
			}else if(stack.size() == 0){ //( [ 도 아니고 비어있으면
				// 0을 출력하고 검사 끝.
				answer = 0;
				break;
			} else if(temp[i].equals(")")) {
				//맨 마지막에 들어간게 (인지 확인
				//들어가있을 수 있는 것: 숫자, [, (
				if(stack.peekLast().equals("(")) {
					stack.pollLast();
					int tmp = 2;
					if(stack.size()==0) {
						stack.offer(Integer.toString(tmp));
						continue;
					}
					while(!(stack.peekLast().equals("(")) && !(stack.peekLast().equals("["))){
						tmp += Integer.parseInt(stack.pollLast());
						if(stack.size()==0) break;
					}
					stack.offer(Integer.toString(tmp));
				}else if(stack.peekLast().equals("[")) {
					answer = 0;
					break;
				}else { // 숫자가 있다.
//					stack.offer(temp[i]);
					//숫자 * 괄호연산
					int tmp = Integer.parseInt(stack.pollLast());
					if(stack.size()==0) {
						answer = 0;
						break;
					}
					if(stack.peekLast().equals("(")) {
						stack.pollLast();
						//넣기전에 앞이 숫자인지 확인
						tmp *= 2;
						//내 앞에 숫자인지 확인하고 숫자면 더하기
						if(stack.size()==0) {
							stack.offer(Integer.toString(tmp));
							continue;
						}
						while(!(stack.peekLast().equals("(")) && !(stack.peekLast().equals("["))){
							tmp += Integer.parseInt(stack.pollLast());
							if(stack.size()==0) break;
						}
						stack.offer(Integer.toString(tmp));
					}
					
				}
			}else if(temp[i].equals("]")) {
				if(stack.peekLast().equals("[")) {
					stack.pollLast();
					int tmp = 3;
					if(stack.size()==0) {
						stack.offer(Integer.toString(tmp));
						continue;
					}
					while(!(stack.peekLast().equals("(")) && !(stack.peekLast().equals("["))){
						tmp += Integer.parseInt(stack.pollLast());
						if(stack.size()==0) break;
					}
					stack.offer(Integer.toString(tmp));
				}else if(stack.peekLast().equals("(")) {
					answer = 0;
					break;
				}else { // 숫자가 있다.
//					stack.offer(temp[i]);
					//숫자 * 괄호연산
					int tmp = Integer.parseInt(stack.pollLast());
					if(stack.size()==0) {
						answer = 0;
						break;
					}
					if(stack.peekLast().equals("[")) {
						stack.pollLast();
						//넣기전에 앞이 숫자인지 확인
						tmp *= 3;
						//내 앞에 숫자인지 확인하고 숫자면 더하기
						if(stack.size()==0) {
							stack.offer(Integer.toString(tmp));
							continue;
						}
						while(!(stack.peekLast().equals("(")) && !(stack.peekLast().equals("["))){
							tmp += Integer.parseInt(stack.pollLast());
							if(stack.size()==0) break;
						}
						stack.offer(Integer.toString(tmp));
					}
					
				}
			}
			//계산 다헀는데 스택에 ( [ 남아있으면 0
		}
//		System.out.println(stack.toString());
		
		if(stack.size() == 1) {
			if(stack.peekFirst().equals("(") || stack.peekFirst().equals("[")) answer = 0;
			else answer = Integer.parseInt(stack.pollLast());
		}else answer = 0;
		System.out.println(answer);
		
		//만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. 
		
		br.close();
	}
}
