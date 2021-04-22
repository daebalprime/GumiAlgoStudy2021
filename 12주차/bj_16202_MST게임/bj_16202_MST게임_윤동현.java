import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_g4_16202_MST게임 {

	static int[][] adjMatrix;
	static int N,M,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 점의 개수
		M = Integer.parseInt(st.nextToken()); // 진행된 차례의 수
		K = Integer.parseInt(st.nextToken()); // 진행된 차례의 수

		adjMatrix = new int[N+1][N+1];
		int start = 0;
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = i;
			if(i == 1) start = from; // 가중치가 1..M이므로 첫시작을 첫번째에 받는 숫자로 prim 알고리즘을 사용
									// 크루스칼은 상관이 없다 ->  각 간선을 모두 검사해서 최소값을 찾으므로
		}

		for(int k=0; k<K; k++) {
			sb.append(prim(start)).append(" ");
		}

		System.out.println(sb);
        br.close();
	}

	static int prim(int start) {
		int[] minVertex = new int[N+1];
		boolean[] visited = new boolean[N+1];

		Arrays.fill(minVertex, Integer.MAX_VALUE);
		minVertex[start] = 0;

		int cnt = 0;
		int res = 0;
		int minWeight = Integer.MAX_VALUE;
		int from = 0, to = 0;
		while(true) {

			int min = Integer.MAX_VALUE;
			int index = 0;
			for(int j=1; j<=N; j++) {
				if(!visited[j] && minVertex[j] < min) {
					min = minVertex[j];
					index = j;
				}
			}

			visited[index] = true;
			res += min;
			if(++cnt == N) break;

			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjMatrix[index][j] > 0 && minVertex[j] > adjMatrix[index][j]) {
					minVertex[j] = adjMatrix[index][j];

					if(minWeight > minVertex[j]) {
						minWeight = minVertex[j];
						from = index;
						to = j;
					}
				}
			}
		}

		for(int i=1; i<=N; i++) {
			if(minVertex[i] == Integer.MAX_VALUE) return 0;
		}

		adjMatrix[from][to] = adjMatrix[to][from] = 0;

		return res;
	}
}