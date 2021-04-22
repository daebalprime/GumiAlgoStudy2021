package a_12weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_20040_사이클게임 {

	static int findset(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findset(parent[a]);
	}

	static boolean union(int a, int b) {
		int pa = findset(a);
		int pb = findset(b);
		if (pa == pb)
			return false;
		parent[pa] = pb;
		return true;
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		
		for (int i = 0; i < n; i++)
			parent[i] = i;
		
		int ans=0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			
			if(!union(from, to)) {
				ans=i+1;
				break;
			}
		}
		System.out.println(ans);
		
		in.close();

	}
}
