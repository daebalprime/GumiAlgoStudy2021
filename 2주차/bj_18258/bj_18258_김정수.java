package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_18258 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Deque<Integer> queue = new LinkedList<>();
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");

		for(int i=0;i<N;i++) {
			String[] command = new String[2];
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<2;j++) {
				if(!st.hasMoreTokens()) break;
				command[j] = st.nextToken();
			}
			switch(command[0]) {
			
			case "push":
				queue.add(Integer.parseInt(command[1]));
				break;
			case "pop":
				if(queue.size() == 0) {
					sb.append("-1");
					sb.append("\n");

				}else {
					sb.append(queue.poll());
					sb.append("\n");


				}
				break;
			case "size":
				sb.append(queue.size());
				sb.append("\n");

				break;
			case "empty":
				sb.append(queue.size()==0?"1":"0");
				sb.append("\n");

				break;
			case "front":
				sb.append(queue.size()==0?"-1":queue.getFirst());
				sb.append("\n");

				break;
			case "back":
				sb.append(queue.size()==0?"-1":queue.getLast());
				sb.append("\n");

				break;
			}
		}
		System.out.print(sb);
		sb.setLength(0);
	}

}
