package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_13458_시험감독_구미_4_이동현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		int N = sc.nextInt();
		int[] room = new int[N];
		for (int n = 0; n < N; n++) {
			room[n] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = room[i];
			if (num <= B ) {
				sum += 1;
				continue;
			} else {
				sum += 1;
				num -= B;
			}
			if (num % C > 0) {
				sum += (num / C) + 1;
			} else {
				sum += (num / C);
			}
		}
		System.out.println(sum);
	}
}
