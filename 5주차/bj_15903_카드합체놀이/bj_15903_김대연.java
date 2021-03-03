package bj_15903;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken())); 
		}
		for(int i = 0; i < M; i++) {
			long sum = pq.poll() + pq.poll();
			pq.offer(sum);
			pq.offer(sum);
		}
		long answer = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
		br.close();
	}
}
