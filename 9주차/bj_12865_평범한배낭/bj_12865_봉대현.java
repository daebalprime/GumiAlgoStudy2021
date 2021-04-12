package a_9weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_12865_평번한배낭 {
	static int n,k;
	static int dp[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());// 물품 수
		k=Integer.parseInt(st.nextToken());// 무게 제한
		ArrayList<bag>blists=new ArrayList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(in.readLine());
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			blists.add(new bag(w,v));
		}
		dp=new int[n+1][k+1];
		
		for(int i=0;i<=n;i++) {//물품수
			for(int j=0;j<=k;j++) {//무게
				if(i==0 ||j==0)
					dp[i][j]=0;
				else if(blists.get(i-1).w<=j) {
					dp[i][j]=Math.max(blists.get(i-1).v+dp[i-1][j-blists.get(i-1).w], dp[i-1][j]);//i번째 물품을 포함 or 포함x
				}
				else {
					dp[i][j]=dp[i-1][j];//넣을 수 없다면 이전 값 
				}
			}
		}
		
		System.out.println(dp[n][k]);
		in.close();
	}
	static class bag{
		int w;
		int v;
		
		bag(int w,int v){
			this.w=w;
			this.v=v;
		}
		
	}
}
