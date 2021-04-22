package a_12weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//50퍼 틀림
public class Main_bj_6497_전력난 {
	static int m, n;
	static boolean visited[];
	static ArrayList<Node> adjlist[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			// 정점의 개수
			m = Integer.parseInt(st.nextToken());
			// 간선의 개수
			n = Integer.parseInt(st.nextToken());
			if(m==0)
				break;
			visited = new boolean[m];
			adjlist = new ArrayList[m];
			for (int i = 0; i < m; i++) {
				adjlist[i] = new ArrayList<>();
			}
			int total = 0;
			// 인접리스트 생성
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				total += w;
				adjlist[from].add(new Node(to, w));
				adjlist[to].add(new Node(from, w));
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			// 정점 0부터 시작
			pq.add(new Node(0, 0));
			int result = 0;

			while (!pq.isEmpty()) {
				Node cnt = pq.poll();
				if (visited[cnt.from])
					continue;
				visited[cnt.from] = true;

				result += cnt.w;

				for (Node next : adjlist[cnt.from]) {
					if (!visited[next.from]) {
						pq.add(next);
					}
				}
			}
			System.out.println(total - result);
		}
		in.close();

	}

	static class Node implements Comparable<Node> {
		int from;
		int w;

		public Node(int from, int w) {
			super();
			this.from = from;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [from=").append(from).append(", w=").append(w).append("]");
			return builder.toString();
		}

	}
}
