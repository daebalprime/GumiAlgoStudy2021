package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1202_보석도둑_구미_4_이동현 {
	static int N, K;
	static long result;
	static int[][] dia;
	static int[] bag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); K = stoi(st.nextToken());
		bag = new int[K];
		dia = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			dia[n][0] = stoi(st.nextToken()); dia[n][1] = stoi(st.nextToken());
		}
		for (int k = 0; k < K; k++) {
			bag[k]=stoi(br.readLine());
		}
		Arrays.sort(dia, (new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = Integer.compare(o1[0], o2[0]);
				return diff == 0 ? -Integer.compare(o1[1], o2[1]) : diff;
			}
		}));
		Arrays.sort(bag);


		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && dia[j][0] <= bag[i]) {
				pq.add(dia[j][1]);
				j++;
			}
			
			if (pq.size()!=0) {
				result += pq.poll();
			}
		}
		System.out.println(result);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
