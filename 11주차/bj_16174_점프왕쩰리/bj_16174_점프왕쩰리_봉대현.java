package a_11weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main_bj_16174_점프왕쩰리 {
	static int dx[]= {1,0};
	static int dy[]= {0,1};
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		int [][]map=new int[n][n];
		
		StringTokenizer st=null;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ArrayDeque<int []>q=new ArrayDeque<>();
		boolean visited[][]=new boolean[n][n];
		visited[0][0]=true;
		q.add(new int[] {0,0});
		boolean flag=false;
		while(!q.isEmpty()) {
			int []cnt=q.poll();
			
			if(map[cnt[0]][cnt[1]]==-1) {
				flag=true;
				break;
			}
			int move=map[cnt[0]][cnt[1]];
			for(int k=0;k<2;k++) {
				int nx=cnt[0]+dx[k]*move;
				int ny=cnt[1]+dy[k]*move;
				
				if(0<=nx&&0<=ny&&nx<n&&ny<n&&!visited[nx][ny]) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
		}
		
		if(flag)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");
		in.close();
	}

}
