package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_1780_종이의개수 {
	static int[] ans = new int[3];
	static int[][] a;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == -1)
					a[i][j] = 2;
			}
		}

		divide(N, 0, 0);

		System.out.println(ans[2]);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	private static void divide(int len, int x, int y) {
		if (len == 1 || check(len, x, y)) {
			ans[a[x][y]] += 1;
			return;
		}

		int nl = len/3;
	
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				divide(nl, x+(nl*i), y+(nl*j));
			}
		}
	}

	private static boolean check(int len, int x, int y) {
		int cmp = a[x][y];
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if(0<=i&&i<N && 0<=j&&j<N) {
					if (cmp != a[i][j]) return false;
				}
			}
		}
		return true;
	}
}
