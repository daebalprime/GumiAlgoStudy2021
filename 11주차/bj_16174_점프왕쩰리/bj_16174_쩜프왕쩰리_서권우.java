import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16174_쩜프왕쩰리_서권우 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1};
	static int[] dy = {1,0}; // 우 하
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
		if(visited[N-1][N-1]) System.out.println("HaruHaru");
		else System.out.println("Hing");
		br.close();
	}
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int jump = map[p.x][p.y];
			for (int k = 0; k < 2; k++) {
				int nx = p.x + (dx[k]*jump);
				int ny = p.y + (dy[k]*jump);
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					q.offer(new Point(nx,ny));
					visited[nx][ny] = true;
					if(nx == N-1 && ny == N-1) {
						while(!q.isEmpty()) {
							q.poll();
						}
						break;
					}
				}
			}
		}
	}

}
