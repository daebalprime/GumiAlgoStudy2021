// 0:10
// bfs
package CodingTest.baekjoon;

import java.util.*;
import java.io.*;

public class b16174 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// bfs
		Deque <int[]> queue = new ArrayDeque<>();
		boolean [][]visit = new boolean[N][N];
		
		queue.offer(new int[] {0, 0});
		visit[0][0] = true;
		int [][]dir = {{0, 1}, {1, 0}};
		
		boolean result = false;
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			
			if(q[0] == N-1 && q[1] == N-1) {
				result = true;
				break;
			}
			
			for(int d=0;d<2;d++) {
				int newR = q[0] + (dir[d][0] * board[q[0]][q[1]]);
				int newC = q[1] + (dir[d][1] * board[q[0]][q[1]]);
				
				if((0<=newR && newR<N) && (0<=newC && newC<N) ) {
					if(!visit[newR][newC]) {
						queue.offer(new int[] {newR, newC});
						visit[newR][newC] = true;
					}
				}
			}
		}
		
		if(result) {
			System.out.println("HaruHaru");
		}
		else {
			System.out.println("Hing");
		}
		
	}

}
