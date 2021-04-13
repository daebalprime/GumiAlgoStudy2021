package bj.gold;

import java.util.*;
import java.io.*;

public class bj_16174_점프왕쩰리 {
	static int N;
	static int[][] map;
	static int[] di = { 0, 1 };
	static int[] dj = { 1, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (bfs()) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
		br.close();
	}
	
	static boolean bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int w = map[cur.x][cur.y];
			
			if (cur.x == N - 1 && cur.y == N - 1) {
				return true;
			}
			
			for (int d = 0; d < 2; d++) {
				int nx = cur.x + (di[d] * w);
				int ny = cur.y + (dj[d] * w);
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					q.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return false;
	}
}

class Pos {
	int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// N*N 정사각형 내부에서만 움직임. 나가면 게임 오버
// 출발점은 0,0
// 이동은 우,하 방향만
// N-1,N-1 도착시 승리
// 한 번에 이동 가능한 칸 수는 현재 밟고 있는 칸에 쓰여 있는 수 만큼. 딱 그만큼 무조건 뛰어야됨.
// 뛰는건 직선으로만 뛸 수 있는듯?