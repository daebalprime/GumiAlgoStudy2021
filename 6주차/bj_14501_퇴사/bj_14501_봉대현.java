package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14501_퇴사 {
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());// 최대 15

		int time[] = new int[n];
		int money[] = new int[n];

		for (int i = 0; i < n; i++) {// 1일부터
			StringTokenizer st = new StringTokenizer(in.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0,time,money,n);
		System.out.println(ans);
		in.close();
	}

	static void dfs(int cnt, int value, int[] time, int[] money, int n) {
		if (cnt >= n) {//n일이 넘으면 끝
			ans=Math.max(ans, value);
			return;
		}
		
		if(cnt+time[cnt]<=n) {
			dfs(cnt+time[cnt],value+money[cnt],time,money,n);
		}else {//날짜를 초과
			dfs(cnt+time[cnt],value,time,money,n);
		}
		dfs(cnt+1,value,time,money,n);
	}
}
