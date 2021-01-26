package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[브론즈2] 문자열 반복
//https://www.acmicpc.net/problem/2675
//제출 전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2675_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		//System.setIn(new FileInputStream("res/baekjoon/bj_2675_input"));
		Scanner scan = new Scanner(System.in);
		
		int T = Integer.parseInt(scan.nextLine());
		String[] str = new String[2];
		
		for (int i = 0; i < T; i++) {
			String answer = "";
			str = scan.nextLine().split(" ");
			//System.out.println(Arrays.toString(str));
			for (int k = 0; k < str[1].length(); k++) {
				for (int j = 0; j < Integer.parseInt(str[0]); j++) {
					answer = answer.concat(Character.toString(str[1].charAt(k)));
					//System.out.println("chk:" + str[1].charAt(k));
				}
			}
			System.out.println(answer);
		}
		
		scan.close();
		
	}
}
