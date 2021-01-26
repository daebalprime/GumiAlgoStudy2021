package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[브론즈2] OX퀴즈
//https://www.acmicpc.net/problem/8958
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_8958_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_8958_input"));
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		String[] arr = new String[T];
		
		for (int i = 0; i < T; i++) {
			arr[i] = scan.nextLine();
			int answer = 0;
			//1칸 전 원소 값(temp) 와 현재원소를 비교해서 값 출력
			int[] temp = new int[arr[i].length()];
			for (int j = 0; j < arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'X') {
					temp[j] = 0;
				} else {
					// temp[-1]에 접근할 수도 있으니
					// 0번째만 특수취급
					if (j == 0) {
						temp[j] = 1;
						answer++;
						continue;
					} else  {
						temp[j] = temp[j - 1] + 1;
						answer += temp[j];

					}
				}
			}
			System.out.println(answer);
		}
		scan.close();
		
	}
}
