package a_7weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_13460_구슬탈출2 {
	static char board[][];
	static int n, m;
	static int Red[], Blue[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = in.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'R') {
					Red = new int[] { i, j };
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					Blue = new int[] { i, j };
					board[i][j] = '.';
				}
			}
		}
		//showboard();
		bfs();
		in.close();
	}
	static void showboard() {
		for(char []m:board)System.out.println(Arrays.toString(m));
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	// 우 하 상 좌
	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean visited[][][][] = new boolean[n][m][n][m];
		q.add(new int[] { Red[0], Red[1], Blue[0], Blue[1], 0 });
		visited[Red[0]][Red[1]][Blue[0]][Blue[1]] = true;

		while (!q.isEmpty()) {
			int cnt[] = q.pollFirst();
			
			// 10번이상이면 -1
			if (cnt[4] >= 10) {
				System.out.println(-1);
				return;
			}
			// 4방향으로 이동
			for (int i = 0; i < 4; i++) {
				int rx = cnt[0], ry = cnt[1], bx = cnt[2], by = cnt[3];	
				// 빨간공
				while (true) {
					// 벽
					if (board[rx][ry] == '#') {
						rx -= dx[i];
						ry -= dy[i];
						break;
					}
					if (board[rx][ry] == 'O')
						break;
					rx += dx[i];
					ry += dy[i];
				}
				// 파란공
				while (true) {
					if (board[bx][by] == '#') {
						bx -= dx[i];
						by -= dy[i];
						break;
					}
					if (board[bx][by] == 'O')
						break;
					bx += dx[i];
					by += dy[i];
				}

				// 파란공이 먼저 들어간경우 continue
				if (board[bx][by] == 'O')
					continue;
				// 빨간 공이 들어간 경우
				if (board[rx][ry] == 'O') {
					System.out.println(cnt[4] + 1);
					return;
				}

				// 빨간공과 파란공이 같은위치에 있는 경우
				// 빨간공 위치로 판단하여 조정
				if (rx == bx && ry == by) {
					if (i == 0) {// 우
						//B R
						if(cnt[1]>cnt[3]) {
							by-=1;
						}else {
							//R B
							ry-=1;
						}
					} else if (i == 1) {// 하
						// 빨간공이 밑
						//B
						//R
						if (cnt[0] > cnt[2]) {
							bx-=1;
						}else {
							//R
							//B
							rx-=1;
						}
					} else if (i == 2) {// 상
						//B
						//R
						if (cnt[0] > cnt[2]) {
							rx+=1;
						}else {
							//R
							//B
							bx+=1;
						}
					} else if (i == 3) {// 좌
						//B R
						if(cnt[1]>cnt[3]) {
							ry+=1;
						}else {
							//R B
							by+=1;
						}
					}
				}//if end
				//System.out.println(rx+" "+ry+" "+bx+" "+by);
				if(!visited[rx][ry][bx][by]) {
					q.add(new int[] {rx,ry,bx,by,cnt[4]+1});
					visited[rx][ry][bx][by]=true;
				}
			}
		}//while end
		System.out.println(-1);
	}

}
