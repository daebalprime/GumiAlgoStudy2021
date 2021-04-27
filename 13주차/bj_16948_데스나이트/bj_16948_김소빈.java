package bj_silver;

import java.io.*;
import java.util.*;
public class Main_bj_16948_데스나이트 {
	static int[] dx = {-2,-2, 0, 0, 2, 2};
	static int[] dy = {-1, 1,-2, 2,-1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		boolean[][] visit = new boolean[n][n];
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r1, c1});
		visit[r1][c1] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for(int d = 0; d < 6; d++) {
					int nx = cur[0]+dx[d];
					int ny = cur[1]+dy[d];
					if(0>nx||nx>=n || 0>ny||ny>=n) continue;
					if(visit[nx][ny]) continue;
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
			if(visit[r][c]) break;
		}
		System.out.println(visit[r][c]?cnt:-1);
	}
}
