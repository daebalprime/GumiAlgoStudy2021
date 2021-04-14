import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_bj_g2_16920_확장게임 {

	static Queue<int[]>[] queue;
	static int[][] map;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[] playerAbility, playerCnt;
	static int N,M,P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		playerAbility = new int[P+1];
		playerCnt = new int[P+1];
		queue = new ArrayDeque[P+1];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=P; i++) {
			playerAbility[i] = Integer.parseInt(st.nextToken());
			queue[i] = new ArrayDeque<>();
		}
		
		for(int i=0; i<N; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(ch[j] == '.') map[i][j] = 0;
				else if(ch[j] == '#') map[i][j] = -1;
				else {
					map[i][j] = ch[j] - '0';
					playerCnt[map[i][j]]++;
					queue[map[i][j]].offer(new int[] {i,j});
				}
			}
		}

		boolean isCheck = false;
		while(!isCheck) {

			for(int i=1; i<=P; i++) {
				if(!queue[i].isEmpty()) {
					isCheck = false;
					break;
				}
				isCheck = true;
			}

			for(int p=1; p<=P; p++) {
				//플레이어 선택
				for(int s=0; s<playerAbility[p]; s++) {
					//플레이어가 가진 s만큼 돌기위해서
					//큐에 들어있는 수만큼 돌림 -> 해당 depth만큼 돌린다.
					int size = queue[p].size();
					if(size == 0) break;

					while(size-->0) {
						int[] cur = queue[p].poll();
						for(int dir=0; dir<4; dir++) {
							int nx = cur[0] + d[dir][0];
							int ny = cur[1] + d[dir][1];
	
							if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;
							
							map[nx][ny] = p;
							playerCnt[p]++;
							queue[p].offer(new int[] {nx,ny});
						}
					}

				}
			}
		}

		for(int i=1; i<=P; i++) {
			System.out.print(playerCnt[i]+" ");
		}

        br.close();
	}
}