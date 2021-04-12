package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_2887_행성터널 {
	static int[] parents;
	static class node implements Comparable<node>{
		int from, to, weight;
		
		public node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		List<int[]> li = new ArrayList<>();
		parents = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			li.add(new int[] {i, x, y, z});
			
			parents[i] = i;
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		Collections.sort(li, (o1, o2) -> Integer.compare(o1[1], o2[1]));
		for(int i = 1; i < n; i++) {
			pq.offer(new node(li.get(i-1)[0], li.get(i)[0], Math.abs(li.get(i)[1]-li.get(i-1)[1])));
		}
		
		Collections.sort(li, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		for(int i = 1; i < n; i++) {
			pq.offer(new node(li.get(i-1)[0], li.get(i)[0], Math.abs(li.get(i)[2]-li.get(i-1)[2])));
		}
		
		Collections.sort(li, (o1, o2) -> Integer.compare(o1[3], o2[3]));
		for(int i = 1; i < n; i++) {
			pq.offer(new node(li.get(i-1)[0], li.get(i)[0], Math.abs(li.get(i)[3]-li.get(i-1)[3])));
		}
		int cnt = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			if(union(cur.from, cur.to)) {
				ans += cur.weight;
				cnt++;
			}
			if(cnt == n-1) break;
		}
		System.out.println(ans);
	}
	
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		parents[b] = a;
		return true;
	}
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
}
