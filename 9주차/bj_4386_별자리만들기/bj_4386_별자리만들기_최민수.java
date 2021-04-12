package baekjoon_04001_05000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[골드 4] 별자리 만들기
//https://www.acmicpc.net/problem/4386
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_4386_별자리만들기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_4386"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//MST 문제라고 생각한다.
		
		//별의 수 n 1~100
		int n = Integer.parseInt(br.readLine());
		
		//별의 x, y좌표. 실수임. 0~1000
		double[][] stars = new double[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			stars[i][0] = Double.parseDouble(st.nextToken()); 
			stars[i][1] = Double.parseDouble(st.nextToken()); 
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				double x = stars[i][0] - stars[j][0];
				double y = stars[i][1] - stars[j][1];
				//소수 3째짜리까지 표현
				pq.offer(new Edge(i, j, Math.round(Math.sqrt(x * x + y * y)*1000.0)/1000.0));
			}
		}
//		for(double[] dd : adjMatrix)System.out.println(Arrays.toString(dd));
		
		//Kruskal 쓸꺼임.
		//1.make
		int[] parents = new int[n+1]; //1번부터 n번까지
		for (int i = 0; i < n+1; i++) {
			parents[i] = i;
		}
		
		
		double answer = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(union(now.from, now.to, parents)) {
				answer += now.distance;
				if(++count == n-1) break;
			}
		}
		System.out.println(Math.round(answer * 100.0)/100.0);

		br.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double distance;
		
		public Edge(int from, int to, double distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
	}
	
	static int findSet(int a, int[] parents) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a], parents);
	}
	
	static boolean union(int a, int b, int[] parents) {
		int rootA = findSet(a, parents);
		int rootB = findSet(b, parents);
		if(rootA == rootB) return false;
		
		parents[rootB] = rootA;		
		return true;
	}
}
