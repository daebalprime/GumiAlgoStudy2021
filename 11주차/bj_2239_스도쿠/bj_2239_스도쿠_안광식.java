package bj.gold;

import java.util.*;
import java.io.*;

public class bj_2239_스도쿠 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map = new int[9][9];
	static boolean[][] row, col;
	static boolean[][][] box;
	static ArrayList<Pos> zero = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		row = new boolean[10][10];
		col = new boolean[10][10];
		box = new boolean[4][4][10];
		for (int i = 1; i <= 9; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= 9; j++) {
				int num = tmp.charAt(j - 1) - '0';
				map[i - 1][j - 1] = num;
				
				if (num == 0) {
					zero.add(new Pos(i, j));
					continue;
				}
				row[i][num] = true;
				col[j][num] = true;
				box[(i - 1) / 3 + 1][(j - 1) / 3 + 1][num] = true;
			}
		}
		
		dfs(0);
	}

	static void dfs(int cnt) {
		if (cnt == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		
		Pos cur = zero.get(cnt);
		
		for (int n = 1; n <= 9; n++) {
			if (check(cur.x, cur.y, n)) {
				row[cur.x][n] = true;
				col[cur.y][n] = true;
				box[(cur.x - 1) / 3 + 1][(cur.y - 1) / 3 + 1][n] = true;
				map[cur.x - 1][cur.y - 1] = n;
				
				dfs(cnt + 1);
				
				row[cur.x][n] = false;
				col[cur.y][n] = false;
				box[(cur.x - 1) / 3 + 1][(cur.y - 1) / 3 + 1][n] = false;
				map[cur.x - 1][cur.y - 1] = 0;
			}
		}
	}
	
	static boolean check(int x, int y, int n) {
		// 행, 열, 박스 검사
		if (!row[x][n] && !col[y][n] && !box[(x - 1) / 3 + 1][(y - 1) / 3 + 1][n])
			return true;
		
		return false;
	}
}
