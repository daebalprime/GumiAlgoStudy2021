package level3;

import java.util.*;

public class Solution_67259_경주로건설_bfs {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		int[][] board = new int[][]{
			{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
			{0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
			{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
		};
		int n = board.length;
		int min = Integer.MAX_VALUE;
		int[][] visit = new int[n][n];
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0,-1});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int price = cur[2];
			if(cur[0] == n-1 && cur[1] == n-1) {
				min = Integer.min(min, price);
				continue;
			}
			for(int d = 0; d < 4; d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				if(nx == 0 && ny == 0) continue;
				if(0>nx||nx>=n || 0>ny||ny>=n) continue;
				if(board[nx][ny] == 0) {
					int np = 0;
					if(cur[3] == -1 || d == cur[3]) {
						np = price+100;
					}
					else {
						np = price+600;
					}
					
					if(visit[nx][ny] == 0 || visit[nx][ny] >= np) {
						visit[nx][ny] = np;
						q.offer(new int[] {nx, ny, np, d});
					}
				}
			}
		}
		for(int[] v: visit) System.out.println(Arrays.toString(v));
		System.out.println(min);
	}
}
