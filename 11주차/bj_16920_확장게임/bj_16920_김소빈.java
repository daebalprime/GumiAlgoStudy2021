package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_16920_확장게임 {
	static int[] dx = {1,-1,0, 0};
	static int[] dy = {0, 0,1,-1};
	static Deque<int[]> q[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int player = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		int[] p = new int[player+1];
		q = new ArrayDeque[player+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= player; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			if(p[i] > 1000000) p[i] = 1000000;
			q[i] = new ArrayDeque<>();
		}
		
		int ans[] = new int[player+1];
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m; j++) {
				if(tmp.charAt(j) == '.') {
					map[i][j] = 0;
				}else if(tmp.charAt(j) == '#'){
					map[i][j] = -1;
				}
				else {
					map[i][j] = tmp.charAt(j)-'0';
					q[map[i][j]].offer(new int[] {i, j});
					ans[map[i][j]]++;
				}
			}
		}
		//입력완료
		
		
		while(true) {
			for(int i = 1; i <= player; i++) { 
				//각 플레이어들 진행
				int turn = 0;//q가 비었거나 turn은 p[i]일때까지 탐색 진행
				while(!q[i].isEmpty()) { //q[i] 진행
					int size = q[i].size();
					while(size-- > 0) { // q[i] 진행을 1~p[i]번해야하므로 while문 
						int [] cur = q[i].poll();
						int x = cur[0], y = cur[1];

						for(int d = 0; d < 4; d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							if(0>nx||nx>=n || 0>ny||ny>=m || map[nx][ny] != 0) continue;
							map[nx][ny] = i;
							q[i].offer(new int[] {nx, ny});
							ans[i]++;
						}
					}
					if(++turn == p[i]) break; //turn: 전진 횟수
					//직관적으로 셀 수 있는 방법을 먼저 찾자...
				}
			}
			if(isEmpty()) break; //모든 플레이어가 갈 곳이 없을 때 종료
		}
		
		
		for(int i = 1; i <= player; i++) {
			System.out.print(ans[i]+" ");
		}
	}
	
	
	private static boolean isEmpty() { //플레이어가 더이상 확장할 수 없다
		for(int i = 1; i < q.length; i++) {
			if(!q[i].isEmpty()) return false;
		}
		return true;
	}
}
