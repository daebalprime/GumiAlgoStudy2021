package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20923_숫자할리갈리게임_구미_4_이동현 {
	static int N,M,count;
	static Deque<Integer> dodq = new ArrayDeque<>();
	static Deque<Integer> sudq = new ArrayDeque<>();
	static Deque<Integer> dogr = new ArrayDeque<>();
	static Deque<Integer> sugr = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dodq.offerLast(stoi(st.nextToken()));
			sudq.offerLast(stoi(st.nextToken()));
		}
		while(true) {
			dogr.offerLast(dodq.pollLast());
			count++;
			if(dodq.isEmpty()) break;
			if (dogr.peekLast() == 5) {
				doBell();
			} else if(!sugr.isEmpty() && dogr.peekLast() + sugr.peekLast() == 5) {
				suBell();
			}
			if(count == M) break;
			
			sugr.offerLast(sudq.pollLast());
			count++;
			if (sudq.isEmpty()) break;
			if (sugr.peekLast() == 5) {
				doBell();
			}else if(!dogr.isEmpty() && dogr.peekLast() + sugr.peekLast() == 5) {
				suBell();
			}
			if(count==M) break;
		}
		if (dodq.size() > sudq.size()) System.out.println("do");
		else if (dodq.size() < sudq.size()) System.out.println("su");
		else System.out.println("dosu");
	}
	static void doBell() {
		while(!sugr.isEmpty()) {
			dodq.offerFirst(sugr.pollFirst());
		}
		while(!dogr.isEmpty()) {
			dodq.offerFirst(dogr.pollFirst());
		}
	}
	static void suBell() {
		while(!dogr.isEmpty()) {
			sudq.offerFirst(dogr.pollFirst());
		}
		while(!sugr.isEmpty()) {
			sudq.offerFirst(sugr.pollFirst());
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
