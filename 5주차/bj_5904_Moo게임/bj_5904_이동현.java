package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_5904_Moo게임_구미_4_이동현 {
	static int N, len;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList<>();
		list.add(3);
		int i = 1;
		while(true) {
			int num = list.get(i-1) + (i+3) + list.get(i-1);
			list.add(num);
			if (num > N) break;
			i++;
		}
		// 3 10 25
		recur(i);
	}
	static void recur(int i) {
		if (i == 0) {
			if (N == 1) System.out.println("m");
			else System.out.println("o");
			return;
		}
		
		if (N <= list.get(i-1)) {
			recur(i-1);
		} else if(N <= list.get(i-1) + i + 3) {
			if (N == list.get(i-1) + 1) System.out.println("m");
			else System.out.println("o");
		} else {
			N -= list.get(i-1) + i + 3;
			recur(i-1);
		}
	}
}
