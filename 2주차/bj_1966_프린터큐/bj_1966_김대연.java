package wk2.bj1966;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			Queue<Integer[]> q = new LinkedList<>();
			int answer = 0;
			int count = sc.nextInt();
			ArrayList<Integer> p = new ArrayList<>();
			int target = sc.nextInt();
			for(int i = 0; i < count; i++) {
				int pt = sc.nextInt();
				q.add(new Integer[] {i,pt});
				p.add(pt);
			}
			Collections.sort(p, (Integer a, Integer b)->Integer.compare(b,a));
			while(true) {
				Integer[] curr = q.poll();
				if(curr[1] ==
						p.get(0)){
					answer++;
					p.remove(0);
					if(curr[0] == target) {
						System.out.println(answer);
						break;
					}
				}
				else {
					q.add(curr);
				}
			}
			
		}
		sc.close();
		
		
	}

}
