package wk2.bj17225;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int T = sc.nextInt();
		Queue<Integer> sm = new LinkedList<Integer>();
		Queue<Integer> js = new LinkedList<Integer>();
		Queue<Integer> smf = new LinkedList<Integer>();
		Queue<Integer> jsf = new LinkedList<Integer>();
		int smlt = Integer.MIN_VALUE;
		int jslt = Integer.MIN_VALUE;
		for(int tc = 0; tc < T; tc++) {
			int time = sc.nextInt(); // 손님
			int color = sc.next().charAt(0) == 'B' ? 1 : 0; //포장지
			int num = sc.nextInt(); // 주문 갯수
			if(color == 1 && tc != 0) {				
				time = Math.max(smlt+a,time);
			}
			else if(color == 0 && tc != 0) {
				time = Math.max(jslt+b,time);
			}
			
			while(num != 0) {					
				if(color == 1) {
					sm.add(time);
					smlt = time;
					time+=a;
				}
				else {
					js.add(time);
					jslt = time;
					time += b;
				}
				num--;
			}			
		}
//		for(Integer asdf : sm) {
//			System.out.print(asdf + " ");
//		}
//		System.out.println();
//		for(Integer asdf : js) {
//			System.out.print(asdf + " ");
//		}
//		System.out.println();
		int id = 1;
		while(!(sm.size() == 0 && js.size() == 0)) {
			int st = (sm.size() == 0 ? -1 : sm.peek());
			int jt = (js.size() == 0 ? -1 : js.peek());
			
			
			if(st == -1) {
				js.poll();
				jsf.add(id++);
				continue;
			}
			if(jt == -1) {
				sm.poll();
				smf.add(id++);
				continue;
			}
			
			if(jt >= st) {
				sm.poll();
				smf.add(id++);
				continue;
			}
			else if(jt < st) {
				js.poll();
				jsf.add(id++);
				continue;
			}
		}
		
		
		
		System.out.println(smf.size());
		for(Integer t : smf) {
			System.out.print(t+ " ");
		}
		System.out.println();
		System.out.println(jsf.size());
		for(Integer t : jsf) {
			System.out.print(t+ " ");
		}
		System.out.println();
	}
}
