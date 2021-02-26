package BJ;

import java.io.*;
import java.util.*;

public class bj_16967 {

	public static void main(String[] args) throws Exception {
		// 입력 준비 작업
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		// 필요한 변수, 배열
		int n = Int(st.nextToken()), m = Int(st.nextToken());
		int x = Int(st.nextToken()), y = Int(st.nextToken());
		int[][] B = new int[n+x][m+y];
		boolean isOverlap = n <= x || m <= y ? false : true;
		// 배열 값 입력
		for (int i = 0; i < n+x; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m+y; ++j) {
				B[i][j] = Int(st.nextToken());
			}
		}
		// 겹치는 범위가 있을 경우에만
		if (isOverlap) {
			for (int i = 0; i < n - 1; ++i) 
				for (int j = 0; j < m - 1; ++j) 
					B[i + x][j + y] -= B[i][j];
		}
		// 출력하기
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				sb.append(B[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
