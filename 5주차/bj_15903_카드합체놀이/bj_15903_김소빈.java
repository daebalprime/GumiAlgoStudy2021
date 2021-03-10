package bj_silver;

import java.util.*;
import java.io.*;
public class Main_bj_15903_카드합체놀이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long [] arr = new long [N];
//		Queue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
//			pq.add(Long.parseLong(st.nextToken()));
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int cnt = 0;
		long sum = 0;
		while(cnt < M) {
			sum = arr[0]+arr[1];
//			sum = pq.poll()+pq.poll();
//			pq.add(sum);
//			pq.add(sum);
			arr[0] = sum;
			arr[1] = sum;
			Arrays.sort(arr);
			cnt++;
		}
		long ans = 0;
//		while(!pq.isEmpty()) {
//			ans += pq.poll();
//		}
		for(long a: arr) {
			ans += a;
		}
		System.out.println(ans);
		br.close();
	}
}
/*
2 30
1000000 1000000
2147483648000000

*/