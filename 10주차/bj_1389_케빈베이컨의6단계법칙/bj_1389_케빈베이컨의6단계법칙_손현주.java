import java.io.*;
import java.util.*;
public class bj_1389_S1 {
	static final int INF = 9999999;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adjMatrix = new int[N][N]; 					// 인접행렬
		int[][] dist = new int[N][N];
		for(int i=0;i<M;++i) {								// 인접행렬 만들기
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		for(int i=0;i<N;++i) {								// fw배열 만들기
			Arrays.fill(dist[i], INF);
			for(int j=0; j<N;++j) {
				if(i==j) dist[i][j] = 0;
				if(adjMatrix[i][j] == 1) dist[i][j] = 1;
			}
		}
		for (int k = 0; k < N; k++) {						// fw알고리즘
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][k] == INF || dist[k][j] == INF) continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		int minDist = INF;
		int idx = INF;
		for (int i = 0; i < N; i++) {
			int d = 0;
			for (int j = 0; j < N; j++) {
				if (dist[i][j] == INF) {
					d = INF;
					break;
				}
				d += dist[i][j];
			}
			if(minDist > d) {								// 최소거리면
				minDist = d;								// 갱신
				idx = i;									// 인덱스 값
			}else if(minDist == d)							// 같으면
				idx = Math.min(idx, i);						// 더 작은 인덱스로 갱신
		}
		System.out.println(idx+1);							// 출력
	}

}
