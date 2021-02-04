package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_1966 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque <int[]> queue = new LinkedList<>();
		
	
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=0;tc<T;tc++) {
			String input1 = in.readLine();
			StringTokenizer st = new StringTokenizer(input1);
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String input2 = in.readLine();
			st = new StringTokenizer(input2);
			for(int i=0;i<N;i++) {
				queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			// 프린트하기
			int count = 1;
			while(queue.size()>0) {
				int[] p = queue.poll();
				boolean flag = false;
				for(int[] item: queue) {
					if(p[1] < item[1]) {
						queue.add(p);
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					if(p[0] == M) {
						System.out.println(count);
					}
					count++;
				}
			}
		}
	}

}
