package a_7weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//80퍼 시간초과 참고 https://www.acmicpc.net/board/view/55942
//bfs보다 dfs가 시간이 짧게나온다.?
/*
 bfs가 효과적인 조건 
 1. 최소비용문제
 2. 간선의 가중치 1
 3. 정점과 간선의 개수가 적다.
 */
public class Main_bj_16234_인구이동 {
	static int[][] map;
	static int n, ans, L, R;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = stoi(st.nextToken());
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = stoi(st.nextToken());
		}
		while (true) {
			v = new boolean[n][n];
			if (!check())
				break;
			for(int []m:map)System.out.println(Arrays.toString(m));
			System.out.println();
			ans++;
		}

		System.out.println(ans);
		in.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean check() {
		ArrayList<int[]> list;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 방문 x
				if (!v[i][j]) {
					// bfs함수 콜백문제
					boolean need_bfs = false;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (0 > nx || nx == n || ny < 0 || ny == n)
							continue;
						else if (!v[nx][ny] && L <= Math.abs(map[i][j] - map[nx][ny])
								&& Math.abs(map[i][j] - map[nx][ny]) <= R) {
							need_bfs = true;
							break;
						}
					}
					if (need_bfs) {
						list = new ArrayList<>();
						list.add(new int[] { i, j });
						if (bfs(i, j, list)) {
							flag = true;
						}
					}else
						v[i][j]=true;
				}
			}
		}
		return flag;
	}

	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	static boolean bfs(int x, int y, ArrayList<int[]> group) {
		int copy[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				copy[i][j] = map[i][j];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		v[x][y] = true;
		int sum = copy[x][y];
		while (!q.isEmpty()) {
			int cnt[] = q.pollFirst();

			for (int k = 0; k < 4; k++) {
				int nx = cnt[0] + dx[k];
				int ny = cnt[1] + dy[k];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					int people = Math.abs(copy[cnt[0]][cnt[1]] - copy[nx][ny]);
					if (!v[nx][ny] && L <= people && people <= R) {// 연합
						q.add(new int[] { nx, ny });
						group.add(new int[] { nx, ny });
						sum += copy[nx][ny];
						v[nx][ny] = true;
					}
				}
			}
		}
		if (group.size() == 1)
			return false;

		for (int i = 0; i < group.size(); i++) {
			copy[group.get(i)[0]][group.get(i)[1]] = sum / group.size();
		}
		//System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[i][j];
//				System.out.print(map[i][j]+" ");
			}
			//System.out.println();
		}
		return true;
	}
}
