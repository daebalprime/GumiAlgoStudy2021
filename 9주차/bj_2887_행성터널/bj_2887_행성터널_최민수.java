package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//[골드 1] 행성 터널
//https://www.acmicpc.net/problem/2887
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2887_행성터널_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2887"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//MST
		//행성의 개수 1~10만
		int n = Integer.parseInt(br.readLine());
		
		int[][] planet = new int[n][4];
		//좌표 -10억~10억
		int planetNum = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			planet[i][0] = Integer.parseInt(st.nextToken());
			planet[i][1] = Integer.parseInt(st.nextToken());
			planet[i][2] = Integer.parseInt(st.nextToken());
			planet[i][3] = ++planetNum; //행성 번호
			
		}
		
		//EdgeList 저장
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		//메모리 초과 코드
//		for (int i = 0; i < n; i++) {
//			for (int j = i+1; j < n; j++) {
//				// 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)
//				int temp = Math.min(Math.abs(planet[i][0] - planet[j][0]), Math.abs(planet[i][1] - planet[j][1]));
//				temp = Math.min(Math.abs(planet[i][2] - planet[j][2]), temp);
//				pq.offer(new Edge(i, j, temp));
//			}
//		}
		
		//저장되는 간선의 수를 줄이기 위해 x, y, z축으로 각각 정렬한 다음
		//해당하는 간선만 저장할 것이다.
		//이게 왜 되는지는 그림도 그려봤는데 정확히는 모르겠다.
		//참고:https://dev-jk.tistory.com/29
		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int i = 1; i < n; i++) {
			pq.offer(new Edge(planet[i-1][3], planet[i][3], (Math.abs(planet[i-1][0] - planet[i][0]))));
		}
		
		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int i = 1; i < n; i++) {
			pq.offer(new Edge(planet[i-1][3], planet[i][3], (Math.abs(planet[i-1][1] - planet[i][1]))));
		}
		
		Arrays.sort(planet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 1; i < n; i++) {
			pq.offer(new Edge(planet[i-1][3], planet[i][3], (Math.abs(planet[i-1][2] - planet[i][2]))));
		}
		
		
		//Kruskal
		int[] parents = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parents[i] = i;
		}
		
		int count = 0;
		long answer = 0;
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(union(now.from, now.to, parents)) {
				answer += now.distance;
				if(++count == n-1) break;
			}
		}
		System.out.println(answer);
	
		br.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, distance;
		
		public Edge(int from, int to, int distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.distance, o.distance);
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

//1. 메모리 초과