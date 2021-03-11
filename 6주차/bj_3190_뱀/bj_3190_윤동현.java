import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BOJ_3190_뱀 {

	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static LinkedList<Node> snake;
	static int[][] map;
	static char[] direction;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N,D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		direction = new char[10001];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			direction[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		D=0;
		snake = new LinkedList<>();
		snake.add(new Node(0,0));
		dfs(0,1,1);
		System.out.println(sb);
		br.close();
	}

	// 오른쪽방향(D=0) 열탐색에서 L,R일때 -> L:2 R:3
	// 왼쪽(D=1) 열탐색에서 L,R일때 -> L:3 R:2
	// 위쪽(D=2) 행탐색에서 L,R일때 -> L:1 R:0
	// 아래쪽(D=3) 행탐색에서 L,R일때 -> L:0 R:1
	static void dfs(int cnt, int x, int y) {
		if(direction[cnt] == 'L' || direction[cnt] == 'D') {
			if(D == 0) D = (direction[cnt]=='L')?2:3;
			else if(D == 1) D = (direction[cnt]=='L')?3:2;
			else if(D == 2) D = (direction[cnt]=='L')?1:0;
			else D = (direction[cnt]=='L')?0:1;
		}

		int nx = x + dx[D];
		int ny = y + dy[D];
		if(nx<=0 || nx>=N+1 || ny<=0 || ny>=N+1 || isCheck(nx, ny)) {
			sb.append(cnt+1).append("\n");
			return;
		}
		if(map[nx][ny] == 1) {
			map[nx][ny] = 0;
			snake.addFirst(new Node(nx,ny));
			dfs(cnt+1, nx, ny);
		} else {
			if(snake.size() == 1) {
				snake.set(0, new Node(nx,ny));
			} else {
				snake.addFirst(new Node(nx,ny));
				snake.removeLast();
			}
			dfs(cnt+1, nx, ny);
		}
	}

	static boolean isCheck(int x, int y) {
		for(int i=0; i<snake.size(); i++) {
			if(snake.get(i).x == x && snake.get(i).y == y) return true;
		}
		return false;
	}
}

/* ArrayDeque, HashMap -> 속도는 같음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayDeque<Node> snake;
	static HashMap<Integer, Character> hashMap;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N,K,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		hashMap = new HashMap<>();
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			char val = st.nextToken().charAt(0);
			hashMap.put(key, val);
		}

		snake = new ArrayDeque<>();
		snake.offer(new Node(1, 1));
		dfs(0, 1, 1, 0);
		br.close();
	}

	//오른쪽방향일때 L은 x-1, R은 x+1
	//왼쪽방향일때 L은 x+1, R은 x-1
	//위쪽방향일때 L은 y-1, R은 y+1
	//아래방향일때 L은 y+1, R은 y-1
	static void dfs(int cnt, int x, int y, int d) {
		if(hashMap.containsKey(cnt)) {
			char dir = hashMap.get(cnt);
			switch(d) {
				case 0:
					d = (dir=='L')?2:3;
					break;
				case 1:
					d = (dir=='L')?3:2;
					break;
				case 2:
					d = (dir=='L')?1:0;
					break;
				case 3:
					d = (dir=='L')?0:1;
					break;
			}
		}
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(nx<=0 || nx>N || ny<=0 || ny>N || isCheck(nx,ny)) {
			System.out.println(cnt+1);
			return;
		}
		if(map[nx][ny] == 1) {
			map[nx][ny] = 0;
			snake.offer(new Node(nx,ny));
			dfs(cnt+1, nx, ny, d);
		} else {
			snake.poll();
			snake.offer(new Node(nx, ny));
			dfs(cnt+1, nx, ny, d);
		}
	}

	static boolean isCheck(int x, int y) {
		for (Node n : snake) {
			if(n.x == x && n.y == y) return true;
		}
		return false;
	}
}
*/