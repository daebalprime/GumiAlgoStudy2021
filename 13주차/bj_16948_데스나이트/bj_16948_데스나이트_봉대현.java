package a_13weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_16948_데스나이트 {
	
	static int dx[]= {-2,-2,0,0,2,2};
	static int dy[]= {-1,1,-2,2,-1,1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		int map[][]=new int[n][n];
		
		StringTokenizer st=new StringTokenizer(in.readLine());
		int sx=Integer.parseInt(st.nextToken());
		int sy=Integer.parseInt(st.nextToken());
		int ex=Integer.parseInt(st.nextToken());
		int ey=Integer.parseInt(st.nextToken());
		
		ArrayDeque<int []>q=new ArrayDeque<>();
		boolean visited[][]=new boolean[n][n];
		q.add(new int[] {sx,sy,0});
		visited[sx][sy]=true;
		int result=-1;
		while(!q.isEmpty()) {
			int cnt[]=q.poll();
			
			if(cnt[0]==ex&&cnt[1]==ey) {
				result=cnt[2];
				break;
			}
			for(int d=0;d<6;d++) {
				int nx=cnt[0]+dx[d];
				int ny=cnt[1]+dy[d];
				if(0<=nx&&0<=ny&&nx<n&&ny<n&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					q.add(new int[] {nx,ny,cnt[2]+1});
					
				}
			}
		}
		System.out.println(result);
		in.close();
	}

}
