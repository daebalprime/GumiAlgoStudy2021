package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2887_행성터널_구미_4_이동현 {
	static class Edge implements Comparable<Edge>{
		int from, to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [from=").append(from).append(", to=").append(to).append(", weight=").append(weight)
					.append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static void make() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	static int find(int num) {
		if (parent[num] == num) return num;
		return parent[num] = find(parent[num]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
	static int N;
	static int result;
	static int[][] input;
	static List<Edge> edges;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][4];
		edges = new ArrayList<>();
		parent = new int[N + 1];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = stoi(st.nextToken());
			input[i][1] = stoi(st.nextToken());
			input[i][2] = stoi(st.nextToken());
			input[i][3] = i;
		}
		
		Arrays.sort(input, (o1,o2) -> Integer.compare(o1[0],o2[0]));
		
		for (int i = 0; i < N -1; i++) {
			edges.add(new Edge(input[i][3], input[i+1][3], Math.abs(input[i][0] - input[i+1][0])));
		}
		
		Arrays.sort(input, (o1,o2) -> Integer.compare(o1[1],o2[1]));
		for (int i = 0; i < N -1; i++) {
			edges.add(new Edge(input[i][3], input[i+1][3], Math.abs(input[i][1] - input[i+1][1])));
		}
		
		Arrays.sort(input, (o1,o2) -> Integer.compare(o1[2],o2[2]));
		for (int i = 0; i < N -1; i++) {
			edges.add(new Edge(input[i][3], input[i+1][3], Math.abs(input[i][2] - input[i+1][2])));
		}
		
		make();
		Collections.sort(edges);
		long result = 0;
		for (Edge edge : edges) {
			if (union(edge.from,edge.to)) {
				result += edge.weight;
			}
		}
		
		System.out.println(result);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
