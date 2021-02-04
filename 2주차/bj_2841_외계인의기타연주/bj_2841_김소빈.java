package bj_silver;

import java.io.*;
import java.util.*;

public class bj_2841_외계인의기타연주 {
	static Stack<Integer>[] a = new Stack[7];
	static int n, m, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= 6; i++) {
			a[i] = new Stack<>();
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(a[x].size() == 0) {
				ans++;
				a[x].push(y);
				continue;
			}
			while(a[x].peek() > y) {
				ans++;
				a[x].pop();
				if(a[x].size() == 0) break;
			}
			if(a[x].size()!=0 && a[x].peek()==y) continue;
			
			ans++;
			a[x].push(y);
		}
		System.out.println(ans);
		br.close();
	}
}
