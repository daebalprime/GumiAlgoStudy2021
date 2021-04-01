package bj_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1520_김소빈 {
	static int[][] arr, dp;
	static int[] dx = {1,-1, 0, 0};
	static int[] dy = {0, 0, 1,-1};
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		// 입력완료
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		if (x == n-1 && y == m-1) return 1;
		if (dp[x][y] != -1) return dp[x][y];
		
		dp[x][y] = 0;
		int nx = 0, ny = 0;
		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (0>nx||nx>=n || 0>ny||ny>=m) continue;
			if(arr[x][y] > arr[nx][ny]) dp[x][y] += dfs(nx, ny);
		}

		return dp[x][y];
	}
}
