package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15903_카드합체놀이_구미_4_이동현 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = stoi(st.nextToken());
		long M = stoi(st.nextToken());
		long result = 0;
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			pq.add(stoi(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			long sum = pq.poll() + pq.poll();
			pq.add(sum);
			pq.add(sum);

		}
		while(pq.size()!=0) {
			result += pq.poll();
		}
		System.out.println(result);
	}
	static Long stoi(String s) {
		return Long.parseLong(s);
	}

}
