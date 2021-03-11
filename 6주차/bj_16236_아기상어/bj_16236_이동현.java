package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16236_아기상어_구미_4_이동현 {
	static int N, count, sharkSize, sharkx,sharky, eatFish;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 9) {
					sharkx = i;
					sharky = j;
					map[i][j] = 0;
				}
			}
		}
		sharkSize = 2;
		bfs();
		System.out.println(count);
	}
	static void bfs() {
		while (true) {
			int x = sharkx;
			int y = sharky;
			visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			List<int[]> remove = new ArrayList<>();
			q.add(new int[] {sharkx,sharky,0});
			while (!q.isEmpty()) {
				int nx, ny;
				int[] temp = q.poll();
				x = temp[0];
				y = temp[1];
				for (int i = 0; i < 4; i++) {
					nx = x + dx[i];
					ny = y + dy[i];
					if (0<= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
						if (!(map[nx][ny] > sharkSize)) {
							q.add(new int[] {nx,ny,temp[2] + 1});
							visited[nx][ny] = true;
							if (map[nx][ny] < sharkSize && map[nx][ny] != 0) {
								remove.add(new int[] {nx, ny, temp[2] + 1});
							}
						}
					}
				}
			}
			
			if (remove.size() == 0) return;
			if (remove.size() > 0) {
				Collections.sort(remove, (o1, o2) -> {
					int diff2 = 0;
					int diff = Integer.compare(o1[2], o2[2]);
					diff2 = diff==0 ? Integer.compare(o1[0], o2[0]) : diff;
					return diff2 == 0 ? Integer.compare(o1[1],o2[1]) : diff2;
				});
				eatFish++;
				if (eatFish == sharkSize) {
					sharkSize++;
					eatFish = 0;
				}
				int tx = remove.get(0)[0];
				int ty = remove.get(0)[1];
				map[tx][ty] = 0;
				sharkx = tx; sharky = ty;
				count += (remove.get(0)[2]);
			}
		
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
