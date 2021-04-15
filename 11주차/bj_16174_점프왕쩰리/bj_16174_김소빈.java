package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_16174_점프왕쩰리 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n]; //방문 처리 잊지말기...
		visit[0][0] = true;
		q.offer(new int[] {0, 0});
		
		int[] cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = map[x][y];
			
			if(x+cost < n && !visit[x+cost][y]) {
				if(map[x+cost][y] == -1) {
					System.out.println("HaruHaru");
					return;
				}
				visit[x+cost][y] = true;
				q.offer(new int[] {x+cost, y});
			}
			if(y+cost < n && !visit[x][y+cost]) {
				if(map[x][y+cost] == -1) {
					System.out.println("HaruHaru");
					return;
				}
				visit[x][y+cost] = true;
				q.offer(new int[] {x, y+cost});
			}
			
		}
		
		System.out.println("Hing");
	}
}
