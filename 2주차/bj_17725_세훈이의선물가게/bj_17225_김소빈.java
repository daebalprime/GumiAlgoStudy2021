package bj_silver;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_17225_세훈이의선물가게 {
	static class Pair implements Comparable<Pair>{
		int idx;
		char c;
		
		public Pair(int idx, char c) {
			this.idx = idx;
			this.c = c;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.idx == o.idx) {
				return this.c - o.c;
			}
			return this.idx - o.idx;
		}
		@Override
		public String toString() {
			return this.idx + " "+ this.c; 
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int t =0, m =0;
		char c;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int bmax = 0, rmax = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			c = st.nextToken().charAt(0);
			m = Integer.parseInt(st.nextToken());
			for(int j = 0; j < m; j++) {
				if(c == 'B') {
					if(bmax < t) {
						pq.add(new Pair(t, c));
						bmax = t+a;
					}
					else {
						pq.add(new Pair(bmax, c));
						bmax += a;
					}
				}
				else {
					if(rmax < t) {
						pq.add(new Pair(t, c));
						rmax = t+b;
					}
					else {
						pq.add(new Pair(rmax, c));
						rmax += b;
					}
				}
			}
		}
		int idx = 1; 
		ArrayList<Integer> R = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>(); 
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
//			System.out.println(cur.toString());
			if(cur.c == 'R') R.add(idx++);
			else B.add(idx++);
		}
		System.out.println(B.size());
		for(int tmp: B) System.out.print(tmp + " ");
		System.out.println();
		System.out.println(R.size());
		for(int tmp: R) System.out.print(tmp + " ");
	}
}
/*
 * 입력
0 0 3
1 B 3
4 R 2
7 R 2

2 3 4
1 B 3
4 R 2
6 B 2
12 R 1

출력
3
1 2 3
4
4 5 6 7

5
1 2 4 5 7
3
3 6 8
*/
