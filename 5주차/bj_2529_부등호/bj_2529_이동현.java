package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2529_부등호_구미_4_이동현 {
	static int K, max, min;
	static char[] com;
	static int[] nums;
	static boolean[] check;
	static List<String> res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		res = new ArrayList<>();
		com = new char[K];
		nums = new int[K+1];
		check = new boolean[10];
		for (int k = 0; k < K; k++) com[k] = sc.next().charAt(0);
		permu(0);
		System.out.println(res.get(res.size()-1));
		System.out.println(res.get(0));
	}
	static void permu(int cnt) {
		if (cnt == K+1) {
			for (int i = 0; i < K; i++) {
				if (com[i] == '>' && nums[i] > nums[i+1]) {
					continue;
				} 
				if (com[i] == '<' && nums[i] < nums[i+1]) {
					continue;
				}
				return;
			}
			
			res.add(Arrays.toString(nums).replaceAll("[^0-9]", ""));
			return;
		}
		for (int i = 0; i <=9; i++) {
			if(check[i]) continue;
			check[i] = true;
			nums[cnt] = i;
			permu(cnt+1);
			check[i] = false;
		}
	}
}
