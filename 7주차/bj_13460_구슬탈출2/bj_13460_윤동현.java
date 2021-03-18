import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_g2_13460_구슬탈출2 {

	static class Node {
		int x; int y;
		Node(int x, int y) {this.x = x; this.y = y;}
	}

	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int blueRow=0, blueCol=0, redRow=0, redCol=0;//
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j].charAt(0);
				if (map[i][j] == 'B') {
					blueRow = i;
					blueCol = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'R') {
					redRow = i;
					redCol = j;
					map[i][j] = '.';
				}
			}
		}

		res = Integer.MAX_VALUE;
		dfs(1, new Node(redRow,redCol), new Node(blueRow,blueCol));

		System.out.println((res==Integer.MAX_VALUE)?-1:res);

		br.close();
	}

	private static void dfs(int cnt, Node red, Node blue) {
		if(cnt > 10 || cnt > res) return;

		for(int dir=0; dir<4; dir++) {
			Node nextRed = move(red, dir);
			Node nextBlue = move(blue, dir);

			if(nextRed.x == -1 && nextRed.y == -1 && nextBlue.x != -1 && nextBlue.y != -1) {
				//빨간공만 탈출
				res = Math.min(res, cnt);
				return;
			}else if(nextRed.x == -1 && nextRed.y == -1 && nextBlue.x == -1 && nextBlue.y == -1) {
				//둘다 탈출 -> 무시
				continue;
			}else if(nextBlue.x == -1 && nextBlue.y == -1) continue; // 파란공만 탈출 -> 무시

			//겹쳤을때 처리
			if(nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
				int redMove = Math.abs(red.x - nextRed.x) + Math.abs(red.y - nextRed.y);
				int blueMove = Math.abs(blue.x - nextBlue.x) + Math.abs(blue.y - nextBlue.y);
				if(redMove < blueMove) {
					nextBlue.x = nextBlue.x + dx[dir]*-1;
					nextBlue.y = nextBlue.y + dy[dir]*-1;
				} else {
					nextRed.x = nextRed.x + dx[dir]*-1;
					nextRed.y = nextRed.y + dy[dir]*-1;
				}
			}

			dfs(cnt+1, nextRed, nextBlue);
		}

	}

	static Node move(Node n, int dir) {
		Node m = new Node(n.x, n.y);

		while(true) {
			if(map[m.x+dx[dir]][m.y+dy[dir]] == 'O') {
				return new Node(-1,-1);
			}
			if(map[m.x+dx[dir]][m.y+dy[dir]] != '.') break;
			m.x = m.x + dx[dir];
			m.y = m.y + dy[dir];
		}

		return m;
	}

}