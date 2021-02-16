package bj_silver;

import java.util.*;
import java.io.*;

public class bj_1010_김소빈 {
//	private static int n, m;
//	private static int ans;
//	private static void combination(int cnt, int start) {
//		if(cnt == n){
//			ans++;
//			return;
//		}
//		for(int i = start; i <= m; i++) {
//			combination(cnt+1, i+1);
//		}
//	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int ans = 1;
			
			for(int i = 1; i <= r; i++) { //완전 조합 문제는 공식을 이용해서 풀어야함...
				ans = ans*(n-i+1)/i;
			}
			System.out.println(ans);
		}
	}
}
/*
3
2 2
1 5
13 29
*/