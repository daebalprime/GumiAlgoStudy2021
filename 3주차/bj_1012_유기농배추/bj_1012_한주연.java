import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k, y, x, result;
	static int[][] farm;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	int tc = stoi(br.readLine());
    	while(tc-- != 0) {
    		stk = new StringTokenizer(br.readLine());
    		n = stoi(stk.nextToken());
    		m = stoi(stk.nextToken());
    		k = stoi(stk.nextToken());
    		
	    	farm = new int[n][m];
	    	visited = new boolean[n][m];
	    	result = 0;	    	
	    	
	    	for(int i = 0; i < k; i++) {
	    		stk = new StringTokenizer(br.readLine());
	    		y = stoi(stk.nextToken());
	    		x = stoi(stk.nextToken());
	    		farm[y][x] = 1;
	    	}
	    	
	    	for(int i = 0; i < n; i++) {
	    		for(int j = 0; j < m; j++) {
					// 0,0 부터 시작하여 N-1,N-1까지 배추가 심어져 있고, 이전 BFS을 통해 방문한 배추가 아니면
	    			if(farm[i][j] == 1 && !visited[i][j]) {
	    				BFS(i,j);
	    			}
	    		}
	    	}
	    	System.out.println(result);
    	}
    	br.close();
	}
	// 상 하 좌 우
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void BFS(int yy, int xx) {
		result++;
		Queue<Pair> q = new LinkedList<>();
		int y, x, ny, nx;
		Pair p;
		q.offer(new Pair(yy,xx));		// 처음 찾은 배추를 넣는다.
		visited[yy][xx] = true;			// 배추를 방문했다고 표현
		while(!q.isEmpty()) {			// 더 이상 방문할 배추가 없을 때까지 
			 p = q.poll();				// 방문 예정인 배추를 하나 가져온다.
			 y = p.y;
			 x = p.x;
			 for(int i = 0; i < 4; i++) {	// 현재 배추의 상하좌우를 탐색한다.
				 ny = y + dy[i];
				 nx = x + dx[i];
				 // 범위를 벗어나지 않고, 처음 방문하였으며 배추가 존재하면
				 if(0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && farm[ny][nx] == 1) {
					 visited[ny][nx] = true;	// 그 배추를 방문 처리한다.
					 q.offer(new Pair(ny,nx));	// 새로운 배추를 넣는다.
				 }
			 }
		}
	}
	
	static class Pair {
		int y, x;
		Pair(int i, int j){
			y = i;
			x = j;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(y).append(", ").append(x);
			return builder.toString();
		}
		
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}