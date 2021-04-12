package a_10weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_17070_파이프옮기기1 {
	static int dx[] = { 0, 1, 1 };// 우 대각선 하
	static int dy[] = { 1, 1, 0 };
	static int[][] map;
	static int n, ans;

	// 파이프가 무거워서 파이프를 밀면서 이동 -> 벽을 긁으면 안된다.
	//원래는 dp문제인데 그냥 반복문으로 dfs로 했는데 잘된다?..ㅎㅎ.
	//dp ->https://buddev.tistory.com/36
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s[] = in.readLine().split(" ");
			for (int j = 0; j < s.length; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
		int[] arr = { 0, 0, 0, 1 }; // 출발좌표 머리0,1 꼬리0,0
		dfs(arr, 0); // 가로 0 대각선 1 하 2
		System.out.println(ans);
		in.close();
	}

	static void dfs(int[] arr, int d) {
		if (arr[2] == n - 1 && arr[3] == n - 1) {
			ans += 1;
			return;
		}
		if (d == 0) {// 가로
			for (int i = 0; i < 2; i++) {
				int nx = arr[2] + dx[i];
				int ny = arr[3] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (i == 1) {
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					} else {
						if (map[nx][ny] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					}
				}
			}
		} else if (d == 1) {// 대각선
			for (int i = 0; i < 3; i++) {
				int nx = arr[2] + dx[i];
				int ny = arr[3] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (i == 1) {
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					} else {
						if (map[nx][ny] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					}

				}
			}
		} else {// 아래
			for (int i = 1; i < 3; i++) {
				int nx = arr[2] + dx[i];
				int ny = arr[3] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (i == 1) {
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					} else {
						if (map[nx][ny] == 0) {
							int[] tmp = { arr[2], arr[3], nx, ny };
							dfs(tmp, i);
						}
					}
				}
			}
		}
	}
}
