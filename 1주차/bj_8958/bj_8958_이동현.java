package com.ssafy.bj;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_bj_8958_OX퀴즈_구미4반_이동현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_8958.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			char[] ox = sc.next().toCharArray();
			int count = 1;
			int sum = 0;
			for (char c : ox) {
				if (c == 'O') sum += count++;
				else count = 1;
			}
			System.out.println(sum);
		}
	}
}
