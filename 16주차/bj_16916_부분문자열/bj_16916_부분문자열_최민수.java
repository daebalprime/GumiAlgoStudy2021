package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//[골드 4] 부분문자열
//https://www.acmicpc.net/problem/16916
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16916_부분문자열_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16916"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. KMP나
		//2. Hash로 풀 수 있을것 같다 ->구현문제인지 시간초과뜸

		char[] main = br.readLine().toCharArray();
		char[] sub = br.readLine().toCharArray();
		
		int[] fail = new int[sub.length];
		for (int i = 1, j = 0; i < sub.length; i++) {
			while(j > 0 && sub[i] != sub[j]) {
				j = fail[j-1];
			}
			if(sub[i] == sub[j]) fail[i] = ++j;
		}
		
		boolean findAnswer = false;
		for (int i = 0, j=0; i < main.length; i++) {
			
			while(j > 0 && main[i] != sub[j]) j = fail[j-1];
			
			
			if(main[i] == sub[j]) {
				j++; //sub의 다음 문자열로
				if(j == sub.length) {
					findAnswer = true;
					break;
				}
			}
		}
		
		

		if(findAnswer) System.out.println(1);
		else System.out.println(0);
		
		br.close();
	}
}

// hash로 해봤는데 시간초과나옴 ㅠㅠ
