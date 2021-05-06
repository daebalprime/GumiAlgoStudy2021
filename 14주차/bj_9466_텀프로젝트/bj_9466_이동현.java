package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_9466_텀프로젝트_구미_4_이동현 {
	static int cnt;
	static int[] arr;
	static boolean[] visited, finish;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		
		for (int t= 0 ; t < T; t++) {
			int N = stoi(br.readLine());
			visited = new boolean[N+1];
			finish = new boolean[N+1];
			arr = new int[N+1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				arr[i] = stoi(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if (!finish[i]) {
					dfs(i);
				}
			}
			
			System.out.println(N-cnt);
		}
	}
	static void dfs(int n) {
		if(visited[n]) {
			return;
		}
		
		visited[n] = true;
		
		if (!visited[arr[n]]) {
			dfs(arr[n]);
		} else {
			if (!finish[arr[n]]) {
				cnt++;
				for (int i = arr[n]; i != n; i = arr[i]) {
					cnt++;
				}
			}
		}
		
		finish[n] = true;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
