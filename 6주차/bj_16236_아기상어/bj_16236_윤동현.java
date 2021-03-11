import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class BOJ_16236_아기상어 {
	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int N, size, X, Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { X=i; Y=j;}
			}
		}

		size = 2;
		int t=0;
		int cnt=0;
		ArrayDeque<Node> qDeque = new ArrayDeque<>();
		int[][] visited;

		while(callMom()) {
			visited = new int[N][N];
			qDeque.offer(new Node(X,Y));
			visited[X][Y] = 1;

			int minDist = Integer.MAX_VALUE;
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			while(!qDeque.isEmpty()) {
				Node node = qDeque.poll();
				for(int dir=0; dir<4; dir++) {
					int nx = node.x + dx[dir];
					int ny = node.y + dy[dir];

					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					if(map[nx][ny] > size || visited[nx][ny] != 0) continue;
					if(map[nx][ny] != 0 && map[nx][ny] < size) {
						if(visited[node.x][node.y] < minDist) {
							minDist = visited[node.x][node.y];
							minX = nx;
							minY = ny;
						} else if(minDist == visited[node.x][node.y]) {
							if(minX == nx) {
								if(minY > ny) {
									minX = nx;
									minY = ny;
								}
							}else if(minX > nx) {
								minX = nx;
								minY = ny;
							}
						}
					}
					visited[nx][ny] = visited[node.x][node.y] + 1;
					qDeque.offer(new Node(nx, ny));
				}
			}

			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				t += minDist;
				cnt++;
				if(cnt != 0 && cnt % size == 0) {
					size++; cnt=0;
				}
				map[X][Y] = 0;
				map[minX][minY] = 9;
				X = minX; Y = minY;
			} else break; // 이 조건없으면 시간초과!
/*
6
1 2 0 3 1 6
1 0 5 0 0 0
1 0 2 0 2 0
0 1 4 0 2 5
6 6 3 0 3 3
4 9 6 0 2 2
https://www.acmicpc.net/board/view/61245
상어가 물고기에 둘러쌓여 움직이지 못해 먹잇감이 있지만 먹지못하는경우
도착지를 찾지 못한다면 종료하는 조건을 넣어줘야함
bfs로 찾을수 있는게 없는경우를 종료조건이 아닌 맵을 순회하며 먹을께 있는지 확인했기떄문에 발생!!
*/
			qDeque.clear();
		}
		System.out.println(t);
		br.close();
	}

	static boolean callMom() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] < 9 && map[i][j] > 0 && map[i][j] < size) return true;
			}
		}
		return false;
	}
}//end class

/* if(visited[cur.r][cur.c] > minDist) continue;를 통해 백트래킹?했음 시간 70ms 줄었음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] map;
	static int[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int N, sharkRow, sharkCol, sharkSize=2, sharkCnt=0 ,t=0, minDist, minRow, minCol;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkRow = i; sharkCol = j; map[i][j] = 0;
				}
			}
		}

		while(true) {
			init();
			bfs();
			if(minRow == Integer.MAX_VALUE && minCol == Integer.MAX_VALUE) break;
			else {
				t += minDist;
				sharkCnt++;
				if(sharkCnt == sharkSize) {
					sharkCnt = 0;
					sharkSize++;
				}
				map[minRow][minCol] = 0;
				sharkRow = minRow; sharkCol = minCol;
			}
		}
		System.out.println(t);
		br.close();
	}

	static void init() {
		visited = new int[N][N];
		minDist = minRow = minCol = Integer.MAX_VALUE;
	}

	static void bfs() {
		ArrayDeque<Node> qDeque = new ArrayDeque<>();
		qDeque.offer(new Node(sharkRow,sharkCol));
		visited[sharkRow][sharkCol] = 1;

		while(!qDeque.isEmpty()) {
			Node cur = qDeque.poll();
			if(visited[cur.r][cur.c] > minDist) continue;

			for(int dir=0; dir<4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(map[nr][nc] > sharkSize || visited[nr][nc] != 0) continue;
				if(map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
					minDist = visited[cur.r][cur.c];
					if(nr < minRow) {
						minRow = nr;
						minCol = nc;
					} else if(nr == minRow) {
						if(nc < minCol) {
							minCol = nc;
						}
					}
				}
				visited[nr][nc] = visited[cur.r][cur.c]+1;
				qDeque.offer(new Node(nr,nc));
			}
		}
	}
} 
*/