package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_9466_텀프로젝트 {
	static int n, cnt;
	static int[] nums;
	static boolean[] visit, team;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken())-1;
			}
			cnt = 0;
			visit= new boolean[n];
			team=  new boolean[n];
			for(int i = 0; i < n; i++) {
				if(!team[i]) {
					dfs(i);
				}
			}
			System.out.println(n-cnt);
		}
	}

	private static void dfs(int cur) {
		if(visit[cur]) {
			team[cur] = true;
			cnt++;
		}
		else visit[cur] = true;
		
		if(!team[nums[cur]]) dfs(nums[cur]);
		
		visit[cur] = false;
		team[cur] = true;
	}
}
