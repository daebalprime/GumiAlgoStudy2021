import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_g5_16174_점프왕쩰리 {

//	static class Pair {
//		int x;
//		int y;
//		Pair(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(0,0));
		br.close();
	}
	
	static String bfs(int x, int y) {
		Queue<int[]>queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int location = map[cur[0]][cur[1]];
			
			if(location == -1) {
				return "HaruHaru";
			}
			
			for(int d=0; d<2; d++) {
				int nx = cur[0] + dx[d] * location;
				int ny = cur[1] + dy[d] * location;
				
				if(nx >= N || ny >= N || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
			}
		}
		
		return "Hing";
	}

//	static String bfs(int x, int y) {
//		Queue<Pair>queue = new LinkedList<>();
//		visited[x][y] = true;
//		queue.offer(new Pair(x, y));
//		
//		while(!queue.isEmpty()) {
//			Pair cur = queue.poll();
//			
//			int location = map[cur.x][cur.y];
//			
//			if(location == -1) {
//				return "HaruHaru";
//			}
//			
//			for(int d=0; d<2; d++) {
//				int nx = cur.x + dx[d] * location;
//				int ny = cur.y + dy[d] * location;
//				
//				if(nx >= N || ny >= N || visited[nx][ny]) continue;
//				
//				visited[nx][ny] = true;
//				queue.offer(new Pair(nx,ny));
//			}
//		}
//		
//		return "Hing";
//	}
}
