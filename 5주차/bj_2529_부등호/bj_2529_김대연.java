package bj_2529;

import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited = new boolean[10];
	static int[] picks = new int[10];
	static boolean[] signs;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		signs = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			if (st.nextToken().equals("<")) signs[i] = true;
			else signs[i] = false;
		}
		br.close();
		permutation(0);
		if(Long.toString(max).length() != N+1) {
			System.out.println("0"+max);
		}else {
			System.out.println(max);
		}
		if(Long.toString(min).length() != N+1) {
			System.out.println("0"+min);
		}else {
			System.out.println(min);
		}
	}
	
	static void permutation(int cnt) {
		if(cnt==N+1) {
//			for(int i = 0; i < N; i++) {
//				System.out.print(picks[i]+" ");
//				System.out.print(signs[i] ? "< " : "> " );
//			}
//			System.out.println(picks[N]);
			long curr = 0;
			for(int i = 0; i < N+1; i++) {
				curr += ((long) Math.pow(10, N-i))*picks[i];
			}
			max = Math.max(max, curr);
			min = Math.min(min, curr);
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(!visited[i]) {
				if(cnt > 0) {
					if(signs[cnt-1]) {
						if(picks[cnt-1] > i) continue;
					}else {
						if(picks[cnt-1] < i) continue;
					}
				}
				visited[i] = true;
				picks[cnt] = i;
				permutation(cnt+1);
				visited[i] = false;
			}
		}
	}
}
