package a_9weeks;

import java.util.*;
import java.io.*;

//음수 + 모든행성을 터널 연결 
public class Main_bj_2887_행성터널 {
	static int find_set(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find_set(parent[a]);
	}

	static void make_set() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	static boolean union(int a, int b) {
		int aroot = find_set(a);
		int broot = find_set(b);
		if(aroot==broot) return false;
		parent[broot]=aroot;
//		if(rank[aroot]>rank[broot])
//			parent[broot]=aroot;
//		else
//			parent[aroot]=broot;
//		
//		if(rank[aroot]==rank[broot])
//			rank[aroot]++;
		return true;
	}

	static int[] parent;
	static int[] rank;
	static int n;
	static ArrayList<planet> plist[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 행성의 개수
		n = Integer.parseInt(in.readLine());

		// kruskal
		parent = new int[n ];
		rank = new int[n ];
		make_set();
		
		
		// 인접 리스트 생성
		plist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			plist[i] = new ArrayList<>();

		int[][] list = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<planet>edgelist=new ArrayList<>();
		// x좌표
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < n - 1; i++) {
			int w = Math.abs(list[i][0] - list[i + 1][0]);
			edgelist.add(new planet(i,i+1, w));
//			plist[i].add(new planet(i + 1, w));
//			plist[i + 1].add(new planet(i, w));
			
		}
		// y좌표
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int i = 0; i < n - 1; i++) {
			int w = Math.abs(list[i][1] - list[i + 1][1]);
			edgelist.add(new planet(i,i+1, w));
//			plist[i].add(new planet(i + 1, w));
//			plist[i + 1].add(new planet(i, w));
		}

		// z좌표
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < n - 1; i++) {
			int w = Math.abs(list[i][2] - list[i + 1][2]);
			edgelist.add(new planet(i,i+1, w));
//			plist[i].add(new planet(i + 1, w));
//			plist[i + 1].add(new planet(i, w));
		}
		Collections.sort(edgelist);
		int result=0;
		
		for(int i=0;i<edgelist.size();i++) {
			planet edge=edgelist.get(i);
			if(union(edge.from, edge.to)){
				result+=edge.cost;
			}
		}
		// for(int []m:list)System.out.println(Arrays.toString(m));
		/*
		 * // 행성 좌표 입력 및 인접 리스트 생성 //이부분에서 메모리 초과.. for (int i = 0; i < n; i++) {
		 * StringTokenizer st = new StringTokenizer(in.readLine()); list[i][0] =
		 * Integer.parseInt(st.nextToken()); list[i][1] =
		 * Integer.parseInt(st.nextToken()); list[i][2] =
		 * Integer.parseInt(st.nextToken()); for(int j=0;j<i;j++) { int c =
		 * getcost(list[i][0], list[i][1], list[i][2], list[j][0], list[j][1],
		 * list[j][2]); plist[i].add(new planet(j, c)); plist[j].add(new planet(i, c));
		 * } }
		 */
		System.out.println(result);
		in.close();
	}

	static int prim() {
		// 최소 비용 계산 prim+priorityqueue
		boolean visited[] = new boolean[n];
		PriorityQueue<planet> pq = new PriorityQueue<>(new Comparator<planet>() {
			@Override
			public int compare(planet o1, planet o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		pq.add(new planet(0, 0,0));
		int cnt = 0;
		int result = 0;

		while (!pq.isEmpty()) {
			planet p = pq.poll();
			if (visited[p.to])
				continue;
			visited[p.to] = true;
			result += p.cost;

			for (planet temp : plist[p.to]) {
				if (!visited[temp.to])
					pq.add(temp);
			}
			if (++cnt == n)
				break;
		}
		System.out.println(result);
		return result;
	}

	static int getcost(int x, int y, int z, int x1, int y1, int z1) {
		int num = Math.min(Math.abs(x - x1), Math.abs(y - y1));
		return Math.min(num, Math.abs(z - z1));
	}

	static class planet implements Comparable<planet>{
		int from;
		int to;
		int cost;

		public planet(int from,int to, int cost) {
			super();
			this.from=from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(planet o) {
			return this.cost-o.cost;
		}
	}
}
