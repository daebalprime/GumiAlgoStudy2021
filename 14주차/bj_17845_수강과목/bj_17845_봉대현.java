package a_14weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_17845_수강과목 {

	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		//최대 공부시간 
		int n=Integer.parseInt(st.nextToken());
		//과목 수
		int k=Integer.parseInt(st.nextToken());
		int dp[][]=new int[k+1][n+1];//과목수와 최대 공부시간
		//과목 중요도 시간 입력
		int score[]=new int[k+1];
		int time[]=new int[k+1];
		for(int i=1;i<=k;i++) {
			st=new StringTokenizer(in.readLine());
			score[i]=Integer.parseInt(st.nextToken());
			time[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=k;i++) {//과목 
			for(int j=1;j<=n;j++) {//공부시간
				if(time[i]<=j) {//수강할 수 있다.
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-time[i]]+score[i]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[k][n]);
		in.close();
	}

}
