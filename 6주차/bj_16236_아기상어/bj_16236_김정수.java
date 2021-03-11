// 1:15
// 조건이 여러개면 bfs queue를 priorityqueue로 만들자!
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b16236 {

	static int[][] board;
	static int N;
	static int[] sharkPos;
	static int sharkSize; // 상어 크기
	static int fishEaten; // 레벨업하고 먹은 물고기 수
	static int time;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		
		sharkPos = new int[2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==9) {
					sharkPos[0] = i;
					sharkPos[1] = j;
					sharkSize = 2;
					fishEaten = 0;
					time = 0;
					board[i][j] = 0;
				}
			}
		}
		
		do {
			if(sharkSize == fishEaten) {
				sharkSize++;
				fishEaten = 0;
				//System.out.println("level up!! to "+sharkSize);
			}
		}while(bfs());
		
		System.out.println(time);
		
	}
	
	static boolean bfs() {
		boolean [][]visit = new boolean[N][N]; //방문 위치 저장
		PriorityQueue <int[]> queue= new PriorityQueue<>((o1, o2)->{
			// 시간부터 우선
			if(o1[2] != o2[2]) return o1[2]-o2[2];
			//그 다음이 위아래
			if(o1[0] != o2[0]) return o1[0]-o2[0];
			//그 다음이 왼오
			return o1[1]-o2[1];
		});
		queue.offer(new int[] {sharkPos[0], sharkPos[1], 0}); // 위치, 시간(이동거리)
		visit[sharkPos[0]][sharkPos[1]] = true;
		
		int[][] dir = {{-1, 0},{0,-1},{0,1},{1,0}};
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			if(board[q[0]][q[1]] < sharkSize && board[q[0]][q[1]] != 0) {
				// 냠냠
				board[q[0]][q[1]] = 0;
				fishEaten++;
				time += q[2];
				sharkPos[0] = q[0];
				sharkPos[1] = q[1];
				//System.out.println("eat "+q[0]+" "+q[1]+" time: "+q[2]);
				//for(int i=0;i<N;i++)System.out.println(Arrays.toString(board[i]));
				return true;
			}
			
			
			for(int d=0;d<4;d++) {
				int newR = q[0]+dir[d][0];
				int newC = q[1]+dir[d][1];
				
				if(0<=newR && newR<N && 0<=newC && newC<N) {
					if(board[newR][newC] <= sharkSize && !visit[newR][newC]) {
						visit[newR][newC] = true;
						queue.offer(new int[] {newR, newC, q[2]+1});
					}
				}
			}
			
			
		}
		
		return false;
	}
	
	

}
