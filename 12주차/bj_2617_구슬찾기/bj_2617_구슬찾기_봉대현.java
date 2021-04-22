package a_12weeks;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_bj_2617_구슬찾기 {
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		ArrayList<Integer>heavylist[]=new ArrayList[n+1];
		ArrayList<Integer>lightlist[]=new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			heavylist[i]=new ArrayList<>();
			lightlist[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			lightlist[a].add(b);
			heavylist[b].add(a);
		}
		int mid=n/2;
		int ans=0;
		for(int i=1;i<=n;i++) {
			//자기보다 가벼운 것의 개수를 판단
			visited=new boolean[n+1];
			int light=dfs(i,lightlist);
			//자기보다 무거운 것들의 개수를 판단
			visited=new boolean[n+1];
			int heavy=dfs(i,heavylist);
			
			//무거운것 가벼운것이 중간보다 개수가 많다면 x 
			if(light>mid || heavy>mid)
				ans++;
		}
		System.out.println(ans);
	}
	static int dfs(int start,ArrayList<Integer>list[]) {
		int sum=0;
		visited[start]=true;
		
		for(int node:list[start]) {
			if(!visited[node]) {
				sum+=dfs(node,list)+1;
			}
		}
		return sum;
	}
}
