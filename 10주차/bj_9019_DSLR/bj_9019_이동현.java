package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_9019_DSLR_구미_4_이동현 {
	static int T, A,B, cur;
	static boolean[] visited;
	static String[] command;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = stoi(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = stoi(st.nextToken()); B = stoi(st.nextToken());
			visited = new boolean[10001];
			command = new String[10001];
			Arrays.fill(command, "");
			bfs(A);
			sb.append(command[B]).append("\n");
		}
		System.out.println(sb);
		
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			int D = cur*2 % 10000;
			int S = cur == 0 ? 9999 : cur-1;
			int L = (cur % 1000) * 10 + (cur/1000);
			int R = (cur%10)*1000 + (cur/10);
			
			if (!visited[D]) {
				visited[D] = true;
				q.add(D);
				command[D] = command[cur] + "D";
			}
			if (!visited[S]) {
				visited[S] = true;
				q.add(S);
				command[S] = command[cur] + "S";
			}
			if (!visited[L]) {
				visited[L] = true;
				q.add(L);
				command[L] = command[cur] + "L";
			}
			if (!visited[R]) {
				visited[R] = true;
				q.add(R);
				command[R] = command[cur] + "R";
			}
			
		}
		if(visited[B]) return;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static String itos(int n) {
		return Integer.toString(n);
	}
}
