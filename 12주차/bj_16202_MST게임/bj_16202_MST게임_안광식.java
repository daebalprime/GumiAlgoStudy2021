package bj.gold;

import java.util.*;
import java.io.*;

public class bj_16202_MST게임 {
	static int N, M, K;
	static int[][] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향
			adj[a][b] = i;
			adj[b][a] = i;
		}

		boolean flag = false;
		for (int i = 0; i < K; i++) {
			if (!flag) {
				int ans = prim();
				if (ans == 0) flag = true;
				sb.append(ans).append(' ');
			} else {
				sb.append(0).append(' ');
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

	static int prim() {
		boolean[] visited = new boolean[N + 1];
		int[] minEdge = new int[N + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		int result = 0;
		minEdge[1] = 0;
		
		int minA = 0;
		int minB = 0;
		int minVal = Integer.MAX_VALUE;

		for (int c = 1; c <= N; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 1;

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[minVertex][i] != 0 && minEdge[i] > adj[minVertex][i]) {
					minEdge[i] = adj[minVertex][i];
					if (minVal > minEdge[i]) {
						minA = minVertex;
						minB = i;
						minVal = minEdge[i];
					}
				}
			}
		}
		
		// 선택 안된게 있으면 (MST 안되면) 0 리턴
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return 0;
			}
		}
		
		// MST 중 비용 가장 작은 간선 자르기
		adj[minA][minB] = 0;
		adj[minB][minA] = 0;
		
		// MST 완성 -> 비용 리턴
		return result;
	}
}

// N개 정점, M개 양방향 간선을 가지는 단순 그래프 G
// 단순 그래프 : 본인으로 간선 X, 두 정점 사이 최대 한 개의 간선 있음

// 정점 주어지는 순서대로 가중치는 1,2,3....M
// 첫 턴에는 주어진 그래프의 MST값 구하기
// 각 턴이 종료된 후에는 그 턴에서 구한 MST에서 가장 가중치가 작은 간선 하나를 제거 (이후에는 사용 불가능)
