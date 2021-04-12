package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_1202_보석도둑 {
	static class germ implements Comparable<germ>{
		int m, v;
		public germ(int m, int v) {
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(germ o) {
			return Integer.compare(this.m, o.m);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		germ [] g = new germ[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			g[i] = new germ(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(g);
		
		int[] bag = new int[k];
		for(int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		long ans = 0;
		int j = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			while(j < n && g[j].m <= bag[i]) {
				pq.offer(g[j].v*-1);
				j++;
			}
			if(!pq.isEmpty()) {
				ans += Math.abs(pq.poll());
			}
		}
		
		System.out.println(ans);
	}
}
