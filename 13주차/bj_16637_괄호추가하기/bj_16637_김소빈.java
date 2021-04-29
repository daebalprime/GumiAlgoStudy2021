package bj_gold;

import java.io.*;
import java.util.*;
public class Main_16637_괄호추가하기 {
	private static int size, answer = Integer.MIN_VALUE;
	private static int[] num;
	private static char[] oper;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		size = len/2;
		
		num = new int[size+1];
		oper = new char[size];
		String tmp = br.readLine();
		for(int i = 0; i < len; i++) {
			if(i%2 == 1) oper[i/2] = tmp.charAt(i);
			else num[i/2] = tmp.charAt(i) -'0';
		}
		//입력완료
		visit = new boolean[size];
		dfs(0); //괄호 붙일 연산자
		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		if(cnt >= size) {
			int result = calculator();
//			System.out.println(result);
			answer = Math.max(answer, result);
			System.out.println(Arrays.toString(visit));
			return;
		}
		dfs(cnt+1);
		visit[cnt] = true;
		dfs(cnt+2);
		visit[cnt] = false;
	}

	private static int calculator() {
		int [] copy = new int[size+1];
		for(int i = 0; i < size+1; i++) copy[i] = num[i];
		
		//괄호 선계산
		for(int i = 0; i < size; i++) {
			if(visit[i]) {
				int tmp = calc(num[i], num[i+1], oper[i]);
				copy[i] = copy[i+1] = tmp;
			}
		}
		//남은 수 계산
		int result = copy[0];
		for(int i = 0; i < size; i++) {
			if(!visit[i]) {
				result = calc(result, copy[i+1], oper[i]);
				copy[i] = copy[i+1] = result;
			}
		}
//		System.out.println(Arrays.toString(copy));
//		System.out.println(result);
		return result;
	}
	
	private static int calc(int a, int b, char o) {
		if(o == '+') return a+b;
		if(o == '-') return a-b;
		if(o == '*') return a*b;
		return 0;
	}
}
