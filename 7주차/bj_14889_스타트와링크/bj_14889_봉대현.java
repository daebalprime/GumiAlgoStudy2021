package a_7weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_14889_스타트와링크 {
	static int [][]board;
	static int n,ans;
	static boolean pick[];
	public static void main(String[] args)throws Exception {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			n=Integer.parseInt(in.readLine());
			board=new int[n][n];
			pick=new boolean[n];
			ans=Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				for(int j=0;j<n;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			pick[0]=true;
			dfs(1,1);//중복을 제외하기 위함
			
			System.out.println(ans);
			in.close();
	}
	static void dfs(int cnt,int start) {
		if(cnt==n/2) {
			System.out.println(Arrays.toString(pick));
			ArrayList<Integer>a=new ArrayList<>();
			ArrayList<Integer>b=new ArrayList<>();
			//스타트팀과 링크팀 나누기
			for(int i=0;i<n;i++) {
				if(pick[i]) {
					a.add(i);
				}else
					b.add(i);
			}
			
			// 능력치 계산
			int startsum=0;
			int linksum=0;
			for(int i=0;i<n/2;i++) {
				for(int j=i+1;j<n/2;j++) {
					//System.out.println(i+" "+j);
					startsum+=board[a.get(i)][a.get(j)]+board[a.get(j)][a.get(i)];
					linksum+=board[b.get(i)][b.get(j)]+board[b.get(j)][b.get(i)];
				}
			}

			System.out.println(startsum+","+linksum);
			ans=Math.min(ans,Math.abs(startsum-linksum));
			return;
		}
		for(int i=start;i<n;i++) {
			pick[i]=true;
			dfs(cnt+1,i+1);
			pick[i]=false;
		}
	}
}
