import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16948_데스나이트_서권우 {
	static int N;
	static int r1,c1,r2,c2;
	static boolean[][] visited;
	static Point start;
	static Point end;
	// (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동
	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static class Point {
		int r,c,cnt;
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		start = new Point(r1, c1, 0);
		end = new Point(r2, c2, 0);
		
		int res = moveDeathknight(start);
		
		System.out.println(res);
		br.close();
	}
	private static int moveDeathknight(Point st) {
		visited[st.r][st.c] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(st);
		int cnt = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			cnt = p.cnt;
			if(r == end.r && c == end.c) {
				return cnt;
			}
			for (int i = 0; i < 6; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, cnt+1));
				}
			}
		}
		return -1;
	}

}
