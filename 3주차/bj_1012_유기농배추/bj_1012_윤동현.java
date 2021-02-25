import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class bj_1012_윤동현 {

	static int[][] map;
	static boolean[][] isCheck;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,M,K,cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			isCheck = new boolean[N][M];
			cnt = 0;

			int x,y;
			while(K-->0){
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(isCheck[i][j] || map[i][j] == 0) continue;
					dfs(i, j);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int x, int y) {
		isCheck[x][y] = true;
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx<0 || nx>= N || ny<0 || ny>=M || isCheck[nx][ny] || map[nx][ny] == 0) continue;
			dfs(nx, ny);
		}
	}
}