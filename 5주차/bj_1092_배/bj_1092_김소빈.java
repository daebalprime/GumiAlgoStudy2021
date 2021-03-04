package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_1092_배 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] na = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			na[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		List<Integer> ma = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			ma.add(Integer.parseInt(st.nextToken()));
		}
		//입력완료
		Arrays.sort(na);
		Collections.sort(ma, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		if(na[n-1] < ma.get(0)) {
			System.out.println("-1");
		}
		else {
			int cnt = 0;
			while(!ma.isEmpty()) {
				int cur = 0, idx = n-1;
				while(idx >= 0) {
					if(cur == ma.size()) break;
					if(ma.get(cur) <= na[idx]) {
						ma.remove(cur);
						idx--;
					}
					else {
						cur++;
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
