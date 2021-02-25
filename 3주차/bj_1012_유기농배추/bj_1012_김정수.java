package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1012 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 상 하 우 좌
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] area = new int[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(in.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				area[Y][X] = 1;
			}
			
			// bfs로 탐색
			int totalCount = 0;
			ArrayDeque <int[]> queue = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][M];

			// 초기값 넣기
			loop: for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(area[i][j] == 1) {
						queue.offer(new int[] {i, j});
						visited[i][j] = true;
						totalCount ++;
						break loop;
					}
				}
			}
			
			
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				
				for(int i=0;i<4;i++) {
					int newR = q[0] + dir[i][0];
					int newC = q[1] + dir[i][1];
					
					if(0<=newR && newR <N && 0<=newC && newC <M) {
						if(!visited[newR][newC] && area[newR][newC] == 1) {
							queue.offer(new int[] {newR, newC});
							visited[newR][newC] = true;
						}
					}
				}
				
				if(queue.isEmpty()) {
					loop: for(int i=0;i<N;i++) {
						for(int j=0;j<M;j++) {
							if(area[i][j] == 1 && !visited[i][j]) {
								queue.offer(new int[] {i, j});
								visited[i][j] = true;
								totalCount ++;
								break loop;
							}
						}
					}
				}
			}
			
			System.out.println(totalCount);
			
		}
		
		
		
	}

}
