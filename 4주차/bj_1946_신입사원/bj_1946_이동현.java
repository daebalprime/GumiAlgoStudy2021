package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_1946_신입사원_구미_4_이동현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] grades = new int[N+1];
			for (int i = 0; i < N; i++) grades[sc.nextInt()] = sc.nextInt();

			int min = grades[1];
			int count = 1;
			for (int i = 2; i <= N; i++) {
				if (grades[i] < min) {
					count++;
					min = grades[i];
				}
			}
			System.out.println(count);
		}
	}
}
