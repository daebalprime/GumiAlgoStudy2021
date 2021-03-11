package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14501_퇴사_구미_4_이동현 {
	static int N, result;
	static boolean[] visit;
	static int[][] task;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		task = new int[N+1][2];
		visit = new boolean[N+1];
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			task[n][0] = stoi(st.nextToken());		
			task[n][1] = stoi(st.nextToken());		
		}
		subset(1);
		System.out.println(result);
	}
	static void subset(int cnt) {
		if (cnt == N+1) {
			int curDay=0;
			int money = 0;
/*			for (int i = 0; i < visit.length; i++) if(visit[i]) System.out.print(i + " ");
			System.out.println();*/
			
			for (int i = 1; i < visit.length; i++) {
				if(visit[i]) {
					if (curDay > i) return;
					curDay = i + task[i][0];
					money += task[i][1];
					if (curDay > N+1) return;
				}
			}
			result = Math.max(money, result);
			return;
		}
		visit[cnt] = true;
		subset(cnt+1);
		
		visit[cnt] = false;
		subset(cnt+1);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
