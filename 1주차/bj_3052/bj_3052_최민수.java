package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[브론즈2] 나머지
//https://www.acmicpc.net/problem/3052
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_3052_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		//System.setIn(new FileInputStream("res/baekjoon/bj_3052_input"));
		Scanner scan = new Scanner(System.in);
		int[] var = new int[10];
		
		for (int i = 0; i < 10; i++) {
			var[i] = scan.nextInt()%42;
		}
		Arrays.sort(var);
		//System.out.println(Arrays.toString(var));
		int count = 1;
		for (int i = 1; i < 10; i++) {
			if(var[i] != var[i-1]) count++;
		}
		System.out.println(count);
		scan.close();
		
	}
}
