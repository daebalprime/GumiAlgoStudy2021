// 1:30
// 시간초과때문에 고생한 문제. 4440ms로 턱걸이 통과!
// bfs를 플레이어 수만큼 돌렸는데, 큐는 순서 지켜지니까 그냥 플레이어 마크를 int 배열에 추가해서 어떤 플레이어인지 저장시키는 게 더 빠를듯. 
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b16920 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int P= Integer.parseInt(st.nextToken());
		
		int[] players = new int[P];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<P;i++) {
			players[i] = Integer.parseInt(st.nextToken());
		}
		
		int [][]board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s = in.readLine();
			for(int j=0;j<M;j++) {
				if(s.charAt(j) == '.') {
					board[i][j] = 0;
				}
				else if(s.charAt(j) == '#') {
					board[i][j] = -1;
				}
				else {
					board[i][j] = Integer.parseInt(s.charAt(j)+"");
				}
			}
		}
		
		while(true) {
			boolean isExpanded = false;
			
			// 플레이어 수만큼 bfs반복
			for(int p=0;p<P;p++) {
				int player = p+1;
				
				Deque<int[]> queue = new ArrayDeque<>();
				boolean[][]visit = new boolean[N][M];
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(board[i][j] == player) {
							boolean isSide = false;
							for(int d=0;d<4;d++) {
								int newR = i + dir[d][0];
								int newC = j + dir[d][1];
								
								if(0<=newR&&newR<N&&0<=newC&&newC<M) {
									if(board[newR][newC] == 0) {
										isSide = true;
									}
								}
							}
							
							if(isSide) {
								queue.offer(new int[] {i, j, players[p]});
								visit[i][j] = true;
							}
							
						}
					}
				}
				
				while(!queue.isEmpty()) {
					int[] q = queue.poll();
										
					
					if(q[2] == 0) {
						continue;
					}
					
					
					// 인접 칸 비엇을 경우 이동
					for(int d=0;d<4;d++) {
						int newR = q[0] + dir[d][0];
						int newC = q[1] + dir[d][1];
						
						if(0<=newR&&newR<N&&0<=newC&&newC<M) {
							if(!visit[newR][newC] && board[newR][newC] == 0) {
								board[newR][newC] = player;
								queue.offer(new int[] {newR, newC, q[2]-1});
								visit[newR][newC] = true;
								isExpanded = true; // 확장한거 마킹
							}
						}
						
					}
					
					
				}
				
			}
			
			if(!isExpanded) {
				break; // 더이상 확장 못할 경우
			}
			
		}
		
		int[] count = new int[P];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] <= 0) continue;
				count[board[i][j]-1]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<P;i++) {
			sb.append(count[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
