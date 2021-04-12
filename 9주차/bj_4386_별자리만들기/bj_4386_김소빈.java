package bj_gold;
import java.io.*;
import java.util.*;
public class Main_bj_4386_별자리만들기 {
	static int[] parents;
	static class node implements Comparable<node>{
		int from, to;
		double w;
		public node(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			return Double.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		
		double[][] arr = new double[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Double.parseDouble(st.nextToken());
			arr[i][1] = Double.parseDouble(st.nextToken());
		}
		//입력완료
		
		//인접리스트 만들기
		parents = new int[n];
		ArrayList<node> adjList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			double [] cur = arr[i];
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				
				double weight = Math.sqrt(Math.pow(Math.abs(arr[j][0]-cur[0]), 2) + Math.pow(Math.abs(arr[j][1]-cur[1]), 2));
				adjList.add(new node(i, j, weight));
			}
			parents[i] = i;
		}
		
		Collections.sort(adjList);
		//MST 만들기 kruskal
		double cost = 0;
		for(node cur: adjList) {
			if(union(cur.from, cur.to)) {
				cost += cur.w;
			}
		}
		System.out.format("%.2f", cost);
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
