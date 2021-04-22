package a_12weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_bj_10775_공항 {
	static int findset(int a) {
		if(parent[a]==a)return a;
		return parent[a]=findset(parent[a]);
	}
	static boolean union(int a,int b) {
		int pa=parent[a];
		int pb=parent[b];
		
		if(pa==pb)
			return false;
		parent[pa]=pb;
		return true;
	}
	static int parent[];
	public static void main(String[] args)throws Exception {
		BufferedReader in=new  BufferedReader(new InputStreamReader(System.in));
		//게이트 수
		int g=Integer.parseInt(in.readLine());
		//비행기 수
		int p=Integer.parseInt(in.readLine());
		int ans=0;
	
		parent=new int[g+1];
		for(int i=1;i<=g;i++)
			parent[i]=i;
		
		for(int i=0;i<p;i++) {
			int k=Integer.parseInt(in.readLine());
			int pk=findset(k);
			if(pk==0) {
				break;
			}
			ans++;
			union(pk,pk-1);
			//System.out.println(Arrays.toString(parent));
		}
		System.out.println(ans);
	}

}
