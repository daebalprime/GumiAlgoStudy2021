package a_12weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_bj_16202_MST게임 {
	static int n,m,k;
	static int[] parent;
	static ArrayList<Node> edgelist;
	static void make() {
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
	}
	
	static int findset(int a) {
		if(parent[a]==a)return a;
		return parent[a]=findset(parent[a]);
	}
	
	static boolean union(int a,int b) {
		int pa=findset(a);
		int pb=findset(b);
		if(pa==pb)
			return false;
		parent[pa]=pb;
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		//정점의 개수
		n=Integer.parseInt(st.nextToken());
		//간선 수
		m=Integer.parseInt(st.nextToken());
		//턴 수
		k=Integer.parseInt(st.nextToken());
		
		parent=new int[n+1];
		edgelist=new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(in.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=i+1;
			edgelist.add(new Node(from,to,w));
		}
		//오름차순 정렬
		Collections.sort(edgelist);
		
		boolean mstcheck=false;
		StringBuilder sb=new StringBuilder();
		//mst 게임 시작
		for(int t=1;t<=k;t++) {
			int result=0;
			int count=0;
			boolean check=false;
			if(mstcheck) {
				sb.append(0+" ");
				continue;
			}
			
			make();
			
			Node temp=edgelist.get(0);
			for(Node next:edgelist) {
				if(union(next.from,next.to)) {
					result+=next.w;
					if(temp.w>next.w) {
						temp=next;
					}
					if(++count==n-1) {
						check=true;
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(parent));
			
			if(check) {
				edgelist.remove(edgelist.indexOf(temp));
				sb.append(result+" ");
			}else {
				mstcheck=true;
				sb.append(0+" ");
			}
		}
		System.out.println(sb.toString());
		in.close();

	}
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int w;
		public Node(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [from=").append(from).append(", to=").append(to).append(", w=").append(w).append("]");
			return builder.toString();
		}
		
	}
}
