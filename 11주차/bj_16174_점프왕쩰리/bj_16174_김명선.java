import java.io.*;
import java.util.*;

public class Main_bj_16174_점프왕쩰리Large_bfs {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx= {1,0};//아래쪽,오른쪽
	static int[] dy= {0,1};
	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16174.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		bfs();
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[0][0]=true;
		
		q.offer(new Node(0,0));
		while(!q.isEmpty()) {
			Node tmp=q.poll();
			if(map[tmp.x][tmp.y]==-1) {//승리지점 도달
				System.out.print("HaruHaru");
				return;
			}
			
			for(int d=0;d<2;d++) {
				int nx=tmp.x+dx[d]*map[tmp.x][tmp.y];
				int ny=tmp.y+dy[d]*map[tmp.x][tmp.y];
				
				if(nx<N && ny<N && !visited[nx][ny]) {
					visited[nx][ny]=true;
					q.offer(new Node(nx,ny));
				}
			}
		}
		System.out.print("Hing");
	}
}
