package a_13weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_15684_사다리조작 {
	static int n,m,h,ans=4;
	static boolean flag=false;
	static int connect[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		
		//세로선 개수
		n=Integer.parseInt(st.nextToken());
		//가로선 개수
		m=Integer.parseInt(st.nextToken());
		//세로선마다 가로선을 놓을수 있는 위치
		h=Integer.parseInt(st.nextToken());
		connect=new int[h+1][n+1];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(in.readLine());
			//행
			int a=Integer.parseInt(st.nextToken());
			//열
			int b=Integer.parseInt(st.nextToken());
			connect[a][b]=1;//오른쪽으로 이동
			connect[a][b+1]=2;//왼쪽으로 이동
		}
		/*
		1028ms
		//횟수, 가로 시작지점
		solution(0, 1);
		*/
		//사다리의 개수
		for(int i=0;i<=3;i++)
		{
			ans=i;
			solution(0,1);
			if(flag)break;
		}
		if(flag)
			System.out.println(ans);
		else
			System.out.println(-1);
		/*
		if(ans!=4)
			System.out.println(ans);
		else
			System.out.println(-1);
		*/
	}
	static void solution(int cnt,int x) {
		
		if(flag)return;
		if(ans==cnt) {
			if(check())
				flag=true;
			return;
		}
		/*
		if(ans<=cnt)
			return;
		else {
			if(check()) {
				ans=cnt;
				return;
			}
		}
		*/
		for(int i=x;i<h+1;i++) {
			for(int j=1;j<n;j++) {
				if(connect[i][j]==0&&connect[i][j+1]==0) {
					connect[i][j]=1;
					connect[i][j+1]=2;
					solution(cnt+1, i);
					connect[i][j]=connect[i][j+1]=0;
				}
			}
		}
		
	}
	//i번 세로선의 결과가 i번이 나오면 끝
	static boolean check() {
		
		for(int i=1;i<=n;i++) {
			//가로, 세로
			int x=1,y=i;
			for(int j=0;j<h;j++) {
				if(connect[x][y]==1)y++;
				else if(connect[x][y]==2)y--;
				x++;
			}
			if(y!=i)return false;
		}
		
		return true;
	}
}
