package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_bj_16236_아기상어 {
	static int n;
	static int [][]map;
	static int[]dx= {0,1,0,-1};
	static int[]dy= {1,0,-1,0};
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(in.readLine());
		map=new int[n][n];
		int []sx=new int[2];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9)
				{
					map[i][j]=2;//아기상어 크기
					sx[0]=i;
					sx[1]=j;
				}
			}
		}
		int time=0;
		int exp=0;
		while(true) {
			int tmp[]=bfs(sx[0],sx[1]);
			if(tmp[0]==-1)//아기상어 혼자힘x
				break;
			map[tmp[0]][tmp[1]]=map[sx[0]][sx[1]];
			map[sx[0]][sx[1]]=0;
			exp+=1;
			sx[0]=tmp[0];
			sx[1]=tmp[1];
			if( exp==map[tmp[0]][tmp[1]]) {
				exp=0;
				map[sx[0]][sx[1]]+=1;
			}
			time+=tmp[2];//이동한 거리만큼 시간 증가
		}
		System.out.println(time);
		in.close();
	}
	static int[] bfs(int x,int y) {
		boolean [][]visited=new boolean[n][n];
		int [][]distance=new int[n][n];
		ArrayDeque<int []>q=new ArrayDeque<>();
		visited[x][y]=true;
		ArrayList<int[]>eat=new ArrayList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int cnt[]=q.pollFirst();
			for(int i=0;i<4;i++) {
				int nx=cnt[0]+dx[i];
				int ny=cnt[1]+dy[i];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visited[nx][ny]) {
					//이동
					if(map[nx][ny]<=map[x][y] ||map[nx][ny]==0) {
						q.add(new int[] {nx,ny});
						distance[nx][ny]=distance[cnt[0]][cnt[1]]+1;
						visited[nx][ny]=true;
					}
					//먹을 수 있는 물고기
					if(map[nx][ny]<map[x][y]&&map[nx][ny]!=0)
					{
						eat.add(new int[] {nx,ny,distance[nx][ny]});
					}				
				}
			}
		}
		if(eat.size()==0) {
			return new int[] {-1};
		}
		//먹을 수 있는 것중  거리가 가깝고 가장 위,가장 왼쪽
		Collections.sort(eat,new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int a=o1[2]-o2[2];
				if(a==0) {
					return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
				}else
					return a;
			}
		});
		return eat.get(0);
	}
}
