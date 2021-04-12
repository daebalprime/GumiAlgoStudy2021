import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		Star[] stars = new Star[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x,y);
			for(int j = 0; j < i; j++) {
				Star prev = stars[j];
				Star curr = stars[i];
				pq.offer(new Edge(prev.distance(curr),j,i));
			}
		}
		int count = 0;
		double answer = 0.0d;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(union(curr.from, curr.to)) {
				answer += curr.length;
				count++;
			}
		}
		bw.write(Double.toString(answer));
		bw.flush();
		br.close();
		bw.close();
	}
	static class Edge implements Comparable<Edge>{
		final double length;
		final int from;
		final int to;
		public Edge(double length, int from, int to) {
			super();
			this.length = length;
			this.to = to;
			this.from = from;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(length, o.length);
		}
	}
	
	static class Star{
		final double x;
		final double y;
		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public double distance(Star b) {
			return Math.sqrt(Math.pow(this.x- b.x,2) + Math.pow(this.y - b.y,2));
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]); 
	}
	
	static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa==pb) return false;
		parents[pb] = pa;
		return true;
	}
}