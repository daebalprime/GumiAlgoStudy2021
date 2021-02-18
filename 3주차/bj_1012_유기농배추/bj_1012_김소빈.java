package bj_silver;

import java.util.*;
import java.io.*;

public class Main_bj_1012_유기농배추_구미_4_김소빈 {
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = { 0, 1, 0,-1};
	static int[][] a;
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int cnt = 0;
			a = new int[n][m];
			int x=-1, y=-1;
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x= Integer.parseInt(st.nextToken());
				y= Integer.parseInt(st.nextToken());
				a[y][x] = 1;
			}
//			입력완료
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(a[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	private static void bfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx&&nx<n && 0<=ny&&ny<m && a[nx][ny]==1) {
				a[nx][ny] = 2;
				bfs(nx, ny);
			}
		}
	}
}
