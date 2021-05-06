package a_14weeks;
import java.util.*;
import java.io.*;

public class Main_bj_9466_텀프로젝트 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		for(int ts=0;ts<t;ts++) {
			int n=Integer.parseInt(in.readLine());
			StringTokenizer st=new StringTokenizer(in.readLine());
			ArrayList<Integer>p[]=new ArrayList[n+1];
			for(int i=1;i<n+1;i++) {
				p[i]=new ArrayList<>();
			}
			//팀원 입력
			for(int i=1;i<=n;i++) {
				int pick=Integer.parseInt(st.nextToken());
				p[i].add(pick);
				p[pick].add(i);
			}
			System.out.println();
			for(int i=1;i<n+1;i++) {
				for(int j=0;j<p[i].size();j++)
					System.out.print(p[i].get(j)+" ");
				System.out.println();
			}
//			//dfs로 자기자신으로 돌아오는 경우 체크
//			for(int i=1;i<=n;i++) {
//				
//			}
		}
		
		
		in.close();
	}
	static void dfs() {
		
	}
}
