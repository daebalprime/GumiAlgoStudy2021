package bj_silver;

import java.util.*;

public class bj_1966_프린터큐 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int idx = sc.nextInt();
			Deque<Integer> ad = new ArrayDeque<>(N);
			for(int i = 0; i < N; i++) {
				ad.add(sc.nextInt());
			}
//			System.out.println(ad);
			int cnt = 1;
			int tmp = ad.getFirst();
			int max = Collections.max(ad);
			while(true) {
				if(idx == 0) {
					if(max == tmp) {
						System.out.println(cnt);
						break;
					}
					else {
						int head = ad.poll();
						ad.add(head);
						idx = ad.size()-1;
					}
				}
				else {
					if(max > tmp) ad.offer(ad.pollFirst());
					else {
						cnt++;
						ad.pollFirst();
					}
					idx -= 1;
				}
				tmp = ad.getFirst();
				max = Collections.max(ad);
//				System.out.println(ad);
//				System.out.println(idx);
			}
		}
		sc.close();
	}
}

/*
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

*/