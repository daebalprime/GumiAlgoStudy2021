package a_9weeks;

import java.util.*;
import java.io.*;

public class Main_bj_1520_내리막길 {
	static int[]dx= {0,-1,1,0};
	static int[]dy= {1,0,0,-1};
	static int [][]map,dp;
	static int n,m;
	
	//기본 bfs로는 시간초과 각.->500x 500이라서
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		dp=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		int ans=dfs(0,0);
		//for(int d[]:dp)System.out.println(Arrays.toString(d));
		System.out.println(ans);

		in.close();
	}
	static int dfs(int x,int y) {
		if(x==n-1&&y==m-1) //오른쪽 끝에 위치하면
			return 1;
		if(dp[x][y]!=-1) {//이미 방문했던 좌표라면
			return dp[x][y];
		}
		
		dp[x][y]=0; //방문 체크
		for(int d[]:dp)System.out.println(Arrays.toString(d));
		System.out.println();
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(0<=nx&&0<=ny&&nx<n&&ny<m) {
				if(map[nx][ny]<map[x][y]) {
					dp[x][y]+=dfs(nx,ny);
				}
			}
		}

		return dp[x][y];
	}
}
