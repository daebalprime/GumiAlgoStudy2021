package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_9019_DSLR {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] ans = new String[10000];
		boolean[] visit = new boolean[10000];
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			Arrays.fill(ans, "");
			Arrays.fill(visit, false);
			
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Deque<Integer> q = new ArrayDeque<>();
			q.offer(a);
			visit[a] = true;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(visit[b]) break;
				int D = cur*2%10000;
				int S = cur==0?9999:cur-1;
				int L = ((cur%1000)*10+cur/1000);
				int R = (cur/10)+cur%10*1000;
				
				if(!visit[D]) {
					q.offer(D);
					visit[D] = true;
					ans[D] = ans[cur]+'D';
				}
				if(!visit[S]) {
					q.offer(S);
					visit[S] = true;
					ans[S] = ans[cur]+'S';
				}
				if(!visit[L]) {
					q.offer(L);
					visit[L] = true;
					ans[L] = ans[cur]+'L';
				}
				if(!visit[R]) {
					q.offer(R);
					visit[R] = true;
					ans[R] = ans[cur]+'R';
				}
			}
			System.out.println(ans[b]);
		}
	}
}
