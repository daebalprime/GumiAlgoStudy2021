package a_14weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_2616_소형기관차 {

	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());//객차의 수
		StringTokenizer st=new StringTokenizer(in.readLine());
		int room[]=new int[n+1];
		int sum[]=new int[n+1];//1번 ~n번까지의 합
		for(int i=1;i<=n;i++) {
			room[i]=Integer.parseInt(st.nextToken());
			sum[i]=sum[i-1]+room[i];
		}
		int k=Integer.parseInt(in.readLine());//최대 운용칸
		int dp[][]=new int[3+1][n+1];
		
		for(int i=1;i<4;i++) {
			for(int j=i*k;j<=n;j++) {
				dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j-k]+(sum[j]-sum[j-k]));
			}
		}
		System.out.println(dp[3][n]);
		in.close();
	}

}
