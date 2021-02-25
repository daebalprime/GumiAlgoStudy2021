package bj_1256;

import java.io.*;
import java.util.*;
public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N; // a
	static int M; // z
	static int K; // target
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static String s;

	static void find(int n, int k, long prevComb, long target, int bound) {
		long currComb = 0; 
		if(k == 0) {
			prevComb = 0;
			currComb = 1;
		}
		else {
			currComb = (prevComb/k)*(n);
		}
		int i = 0;
		for(i = n; i <= bound; i++, k++) {			
			if(prevComb <= target && currComb > target) {
				if(prevComb == 0) {
					for(int j = i-1; j >= 0; j--) {
						pq.offer(j);
					}
					break;
				}
				find(i-k-1, 0, 0, -prevComb+target, i-1);
				pq.offer(i-1);
				break;
			}
			prevComb = currComb;
			currComb = (prevComb*(i+1)/(k+1)); 
		}
		if(i == M+N+1) {
			System.out.println("-1");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		char[] chars = new char[N+M];
		Arrays.fill(chars, 'a');
		if(K == 1) {
			for(int x = 0; x < M; x++) {
				chars[N+M-1-x] = 'z';
			}
		}
		else {				
			find(M+1, 1, 1, K-1, N+M);
		}
		while(!pq.isEmpty()) {
			chars[N+M-1-pq.poll()] = 'z';
		}
		s = new String(chars);
		bw.write(s);
		bw.flush();
		bw.close();
		
		pq.clear();
	}
}
