package bj.dp;

import java.io.*;
import java.util.*;

public class bj_1389_송진범 {

	static int N, M, a, b;
	static int min = Integer.MAX_VALUE;
	static int[][] distance;
	static final int INF = 9999999;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			distance[a][b] = 1;
			distance[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distance[i][j] != 1 && i != j)
					distance[i][j] = INF;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || k == j)
						continue;
					if (distance[i][k] != INF && distance[k][j] != INF
							&& distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		for(int i=1; i<=N; ++i) {
			int tempSum = 0;
			for(int j=1; j<=N; ++j) {
				tempSum+=distance[i][j];
			}
			if(min > tempSum) {
				min = tempSum;
				a = i;
			}
		}
		System.out.println(a);
		
		in.close();
	}
}
