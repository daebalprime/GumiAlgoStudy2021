package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_1043_거짓말 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer>[] adj = new HashSet[n+1];
		for(int i = 0; i <= n; i++) {
			adj[i] = new HashSet<>();
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int trueNum = Integer.parseInt(st.nextToken());
		int truth[] = new int[trueNum];
		for(int i = 0; i < trueNum; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}
		
		List<int[]> party = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int[] pp = new int[num];
			for(int j = 0; j < num; j++) {
				pp[j] = Integer.parseInt(st.nextToken());
			}
			party.add(pp);
			for(int j = 0; j < num; j++) {
				for(int k = 0; k < num; k++) {
					if(j == k) continue;
					adj[pp[j]].add(pp[k]);
				}
			}
		}
		if(trueNum == 0) {
			System.out.println(m);
			return;
		}
//		for(int i = 0; i < n; i++) {
//			for(int cur: adj[i]) System.out.print(cur+" ");
//			System.out.println();
//		}
		
		boolean [] visit = new boolean[n+1];
		for(int i = 0; i < trueNum; i++) {
			Deque<Integer> q = new ArrayDeque<>();
			q.offer(truth[i]);
			visit[truth[i]] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int p : adj[cur]) {
					if(visit[p]) continue;
					visit[p] = true;
					q.offer(p);
				}
			}
		}
//		System.out.println(Arrays.toString(visit));
		
		int cnt = m;
		for(int i = 0; i < m; i++) {
			boolean flag = false;
			for(int p: party.get(i)) {
				if(visit[p]) {
					flag = true;
					break;
				}
			}
			if(flag) cnt--;
		}
		
		System.out.println(cnt);
	}
}
