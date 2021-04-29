package a_13weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1043_거짓말 {
	
	static boolean know[],adjmatix[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		adjmatix=new boolean[n+1][n+1];
		know=new boolean[n+1];
		st=new StringTokenizer(in.readLine());
		int p=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<p;i++) {
			int k=Integer.parseInt(st.nextToken());
			know[k]=true;//진실을 아는자
		}
		
		int [][]party=new int[m][];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(in.readLine());
			int pn=Integer.parseInt(st.nextToken());
			party[i]=new int[pn];
			//1명인 경우
			party[i][0]=Integer.parseInt(st.nextToken());
			for(int j=1;j<pn;j++) {
				party[i][j]=Integer.parseInt(st.nextToken());
				adjmatix[party[i][j-1]][party[i][j]]=adjmatix[party[i][j]][party[i][j-1]]=true;
			}
			
		}
		int result=m;
		for(int i=1;i<=n;i++) {
			if(know[i])
				dfs(i,n);
		}
		for(int i=0;i<m;i++) {
			if(know[party[i][0]])
				result--;
		}
		System.out.println(result);
	}
	static void dfs(int start,int n) {
		for(int i=1;i<=n;i++) {
			if(adjmatix[start][i]&&!know[i]) {
				know[i]=true;
				dfs(i,n);
			}
		}
	}
}
