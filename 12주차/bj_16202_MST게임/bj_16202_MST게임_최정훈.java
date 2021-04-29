package main.bj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_16202_MST게임 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	static int parent[];
	static int rank[];
	static int n,m,k;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_bj_16202.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); //그래프 정점 개수
		m = Integer.parseInt(st.nextToken()); //간선 개수
		k = Integer.parseInt(st.nextToken()); //턴 수
		
		edgeList = new Edge[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken()); //출발 정점
			int to = Integer.parseInt(st.nextToken()); //도착 정점
			int weight = i+1; //가중치
			//간선리스트
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList); //가중치 순으로 오름차순 정렬.
		
		getMST(0);
		
	}	
	
	private static void getMST(int cnt) {
		if(cnt == k) {
			return;
		}
		parent = new int[n+1];
		rank = new int[n+1];
		make();
		
		int result = 0; //가중치 합
		int count = 0; //선택한 간선 수
		boolean flag = false;
		for(Edge edge : edgeList) {
			if(edge.weight== 0) continue;
			//최상위 랭크(부모)가 서로 다르면 = 서로연결 되어있지 않으면  union 한다.
			int px = find(edge.from);
			int py = find(edge.to);
			int pw = edge.weight;
			if(px != py) {
				count++;
				result +=pw;
				union(px,py);
			}
			//n-1 간선 수 멈춤 : mst
			if(count == n-1) {
				flag = true;
				break;
			}
		}
		if(!flag) { //mst가 아니라면 0
			for (int i = cnt; i < k; i++) {
				System.out.print(0+ " ");
			}
			return;
			
		}else { //mst 이면 가중치 출력하고, 가중치가 가장 작은 간선 제외하고 턴수만큼 돌림.
			edgeList[cnt].weight = 0; //가중치 초기화
			System.out.print(result+ " ");
			getMST(cnt+1);
		}
		
		
		
	}

	public static void make() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a]  = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		if (rank[a] > rank[b])
			parent[b] = a;
		else {
			parent[a] = b;
			if (rank[a] == rank[b])
				rank[b]++;
		}
	}
}
