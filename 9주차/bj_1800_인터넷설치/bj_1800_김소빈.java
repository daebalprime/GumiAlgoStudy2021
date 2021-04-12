package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_1800_인터넷설치 {
	static List<int[]> li[];
	static int n, k, ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		li = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			li[i] = new ArrayList<>();
		}
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			li[from].add(new int[] {to, weight});
			li[to].add(new int[] {from, weight});
		}
		
		ans = -1;
		int right = 0;
		int left = 1000000;
		while(right <= left) {
			int mid = (right+left)/2;
			if(dfs(mid)) {
				ans = mid;
				left = mid-1;
			}else {
				right = mid+1;
			}
		}
		
		System.out.println(ans);
	}
	private static boolean dfs(int mid) {
		Stack<int[]> s = new Stack<>();
		boolean[][] visit = new boolean[n+1][k+1];
		
		s.push(new int[] {1, k});
		while(!s.isEmpty()) {
			int[] cur = s.pop();
			if(cur[0] == n) return true; //현재 위치가 n인 경우
			
			if(visit[cur[0]][cur[1]]) continue;
			visit[cur[0]][cur[1]] = true;
			
			for(int[] a: li[cur[0]]) {
				if(a[1] <= mid) s.push(new int[] {a[0], cur[1]}); //mid원 이하로 설치 가능 경우
				else if(cur[1] > 0) s.push(new int[] {a[0], cur[1]-1}); //할인 횟수 k번 남은 경우
			}
		}
		
		return false;
	}
}
