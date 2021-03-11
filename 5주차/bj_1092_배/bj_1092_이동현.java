package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1092_배_구미_4_이동현 {
	static int N, M, result;
	static Integer[] crains;
	static List<Integer> boxes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		crains = new Integer[N];
		for (int n = 0; n < N; n++) {
			crains[n] = sc.nextInt();
		}
		Arrays.sort(crains, Collections.reverseOrder());
		
		M = sc.nextInt();
		boxes = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			boxes.add(sc.nextInt());
		}
		Collections.sort(boxes);
		
		if (crains[0] < boxes.get(boxes.size()-1)) {
			System.out.println(-1);
			return;
		}
		while(boxes.size() != 0) { 
			int j = boxes.size()-1;
			loop:for (int i = 0; i < crains.length; i++) {
				while(j!=-1) {
					if (crains[i]>=boxes.get(j)) {
						boxes.remove(j--);
						continue loop;
					} else {
						j--;
					}
				}
			}
			result++;
		}
		System.out.println(result);
	}
}
