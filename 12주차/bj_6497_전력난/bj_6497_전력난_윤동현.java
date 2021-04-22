import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_g4_6497_전력난 {
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Main.Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	//도시상의 모든 길의 거리 합은 2^31미터보다 작다. -> int로 해결 가능
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int M,N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 집의 수
			N = Integer.parseInt(st.nextToken()); // 길의 수
			if(N == 0 && M == 0) break;
	
			pq = new PriorityQueue<>();
			parents = new int[M];
			for(int i=0; i<M; i++) parents[i] = i;
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
	
				pq.offer(new Edge(x, y, z));
				sum += z;
			}

			sb.append(sum-Kruskal()).append("\n");
		}

		System.out.print(sb);
        br.close();
	}

	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x == y) return true;

		parents[y] = x;
		return false;
	}

	static int Kruskal() {
		int cost = 0;
		int cnt = 0;

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();

			if(cnt == N-1) break;

			if(!union(edge.from, edge.to)) {
				cost += edge.cost;
				cnt++;
			}
		}
		return cost;
	}
}