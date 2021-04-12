package bj.silver;

import java.io.*;
import java.util.*;

public class bj_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // new StringTokenizer(br.readLine(), " ");
		// StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 유저 수
		int M = Integer.parseInt(st.nextToken()); // 관계 수

		int[][] dist = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			dist[A][B] = 1;
			dist[B][A] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && dist[i][j] == 0) {
					dist[i][j] = 9999999;
				}
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int minidx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += dist[i][j];
			}
			if (min > sum) {
				min = sum;
				minidx = i;
			}
		}
		
		System.out.println(minidx + 1);
		
		br.close();
	}
}

// 양방향
// 중복값 들어올 수 있음
// 친구가 한 명도 없는 사람은 없음