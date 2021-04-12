package a_9weeks;

import java.util.*;
import java.io.*;
//참고 https://guy-who-writes-sourcecode.tistory.com/43, https://m.blog.naver.com/tjdwns0920/221135677693
//소설 챕터이므로 인접한 것들끼리 묶어야됨.
public class Main_bj_11066_파일합치기 {
	static int []cost;
	static int k;
	static int [][]dp;
	static int []sum;
	static final int max_value=Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		StringTokenizer st=null;
		for(int t=0;t<T;t++) {
			k=Integer.parseInt(in.readLine());
			st=new StringTokenizer(in.readLine());
			cost=new int[k+1];
			sum=new int[k+1];
			dp=new int[k+1][k+1];
			for(int i=1;i<=k;i++) {
				cost[i]=Integer.parseInt(st.nextToken());//비용 입력
				sum[i]=sum[i-1]+cost[i];//누적합을 구하기
			}
			
			//인접한 파일들의 합
			for(int i=0;i<k-1;i++) {
				dp[i][i+1]=cost[i]+cost[i+1];
			}
			
			for(int n=1;n<=k;n++) {//1장부터 n장까지 묶기 (몇장을 묶을 것인가)
				for(int from=1;from+n<=k;from++) {//어디부터 묶기 시작할것인가?
					int to=from+n;
					dp[from][to]=Integer.MAX_VALUE;
					for(int divide=from;divide<to;divide++) {//범위가 주어졌을때 특정 범위를 나눠서 최대값구하기
						dp[from][to]=Math.min(dp[from][to],dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
					}
				}
			}
			System.out.println(dp[1][k]);
		}
		
		in.close();
	}
	
}
