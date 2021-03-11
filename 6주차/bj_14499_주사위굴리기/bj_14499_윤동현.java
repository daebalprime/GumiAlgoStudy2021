import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_14499_주사위굴리기 {

	static class Dice {
		static int up;
		static int north;
		static int east;
		static int west;
		static int south;
		static int down;

		public Dice() {
			this.up = 0;
			this.north = 0;
			this.east = 0;
			this.west = 0;
			this.south = 0;
			this.down = 0;
		}

		static void DiceMove(int cmd) {
			int nx = X + dx[cmd];
			int ny = Y + dy[cmd];

			if(nx<0 || nx>=N || ny<0 || ny>=M) return;

			int temp = up;
			switch(cmd) {
				case 1: {
					up = west;
					west = down;
					down = east;
					east = temp;
					break;
				}
				case 2: {
					up = east;
					east = down;
					down = west;
					west = temp;
					break;
				}
				case 3: {
					up = south;
					south = down;
					down = north;
					north = temp;
					break;
				}
				case 4: {
					up = north;
					north = down;
					down = south;
					south = temp;
					break;
				}
			}

			if(map[nx][ny] == 0) map[nx][ny] = down;
			else {
				down = map[nx][ny];
				map[nx][ny] = 0;
			}

			X = nx;
			Y = ny;
			sb.append(up).append("\n");
		}
	}

	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int N,M,X,Y,K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		X = stoi(st.nextToken());
		Y = stoi(st.nextToken());
		K = stoi(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		Dice dice = new Dice();

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			dice.DiceMove(stoi(st.nextToken()));
		}

		System.out.print(sb);

		br.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}//end class

/* 배열 버전
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int[] dice = new int[6];
	static int N,M,X,Y,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = X + dx[dir];
			int ny = Y + dy[dir];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			diceMove(dir);
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[5];
			}else {
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}
			X = nx; Y = ny;
			sb.append(dice[0]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	//0:윗면 1:동쪽 2:서쪽 3:북쪽 4:남쪽 5:밑면
	static void diceMove(int dir) {
		int tmp = dice[0];
		switch (dir) {
			case 1:
				dice[0] = dice[2]; //윗면이 서쪽으로
				dice[2] = dice[5]; // 밑면이 서쪽으로
				dice[5] = dice[1]; // 동쪽이 밑면으로
				dice[1] = tmp; // 윗면이 동쪽으로
				break;
			case 2:
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[2];
				dice[2] = tmp;
				break;
			case 3:
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
				break;
			case 4:
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[4];
				dice[4] = tmp;
				break;
			default:
				break;
		}
	}

}//end class
*/