package com.ssafy.bj;
import java.util.*;
import java.io.*;

public class Main_bj_1966_프린터큐_구미_4_이동현 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			List<int[]> deq = new ArrayList<>();
			
			int N = st.nextToken().charAt(0) - '0';
			int M = Integer.parseInt(st.nextToken());
			int index = 0;
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				deq.add(new int[] {Integer.parseInt(st.nextToken()), index++});
			}
			int count = 1;

			while (deq.size()!=0) {
				boolean check = true;
				for (int i = 1; i < deq.size(); i++) {
					if (deq.get(i)[0] > deq.get(0)[0]) {
						check = false;
						deq.add(deq.remove(0));
						break;
					}
				}
				if (check) {
					if (deq.get(0)[1] != M) {
						count+=1;
						deq.remove(0); 
					}
					else if (deq.get(0)[1] == M) {
						sb.append(count).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
