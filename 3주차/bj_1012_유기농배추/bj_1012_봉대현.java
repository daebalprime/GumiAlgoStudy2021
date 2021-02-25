

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_bj_1012_유기농배추 {
	static int []dx= {1,0,-1,0};
	static int []dy= {0,1,0,-1};
	static int [][] map;
	static boolean [][]visited;
	static int bfs(int x,int y,int m,int n) {
		ArrayDeque<int []>stack=new ArrayDeque<>();
		stack.push(new int[] {x,y});
		visited[x][y]=true;
		
		while(!stack.isEmpty()) {
			int []p=stack.pollFirst();
			for(int k=0;k<4;k++) {
				int nx=p[0]+dx[k];
				int ny=p[1]+dy[k];
				
				if(0<=nx&&nx<m&&0<=ny&&ny<n&&map[nx][ny]==1&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					stack.addLast(new int[] {nx,ny});
				}
			}
		}
		return 1;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			//입력
			String []s=in.readLine().split(" ");
			int m=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			int k=Integer.parseInt(s[2]);
			map=new int[m][n];
			visited=new boolean[m][n];
			
			for(int i=0;i<k;i++) {
				String []sn=in.readLine().split(" ");
				int sx=Integer.parseInt(sn[0]);
				int sy=Integer.parseInt(sn[1]);
				map[sx][sy]=1;
			}
			//탐색
			int sum=0;
			for(int x=0;x<m;x++) {
				for(int y=0;y<n;y++) {
					if(!visited[x][y]&&map[x][y]==1)
						sum+=bfs(x,y,m,n);
				}
			}
			
			
			System.out.println(sum);
		}
	
	
	
	
		in.close();
	}
}
