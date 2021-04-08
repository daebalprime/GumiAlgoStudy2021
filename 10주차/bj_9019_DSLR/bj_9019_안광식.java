package bj.gold;

import java.util.*;
import java.io.*;

public class bj_9019_DSLR {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(A, B)).append('\n');
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static String bfs(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		String[] dslr = new String[10000];
		Arrays.fill(dslr, "");
		
		visited[A] = true;
		q.add(A);
		while(!q.isEmpty() && !visited[B]) {
			int cur = q.poll();
			int D = (2 * cur) % 10000;
			int S = cur == 0 ? 9999 : cur - 1;
			int L = ((cur % 1000) * 10) + (cur / 1000);
			int R = (cur / 10) + ((cur % 10) * 1000);
			
			if (!visited[D]) {
				q.offer(D);
				visited[D] = true;
				dslr[D] = dslr[cur] + "D";
			}
			
			if (!visited[S]) {
				q.offer(S);
				visited[S] = true;
				dslr[S] = dslr[cur] + "S";
			}
			
			if (!visited[L]) {
				q.offer(L);
				visited[L] = true;
				dslr[L] = dslr[cur] + "L";
			}
			
			if (!visited[R]) {
				q.offer(R);
				visited[R] = true;
				dslr[R] = dslr[cur] + "R";
			}
		}
		
		return dslr[B];
	}
}

// D : n 두 배, 9999보다 커지면 10000으로 나눈 나머지 (2n mod 10000)
// S : N - 1, n이 0이라면 9999
// L : 좌측으로 시프트
// R : 우측으로 시프트
// 1000 L -> 0001 = 1
// 1000 R -> 0100 = 100
