package com.ssafy.bj;
import java.util.*;
import java.io.*;

public class Main_bj_18258_큐2_구미_4_이동현 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<String> queue = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
			case "push":
				queue.offer(st.nextToken());
				break;
			case "pop":
				if (queue.size()>0) sb.append(queue.poll()).append("\n");
				else sb.append("-1").append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (queue.size()==0) sb.append(1).append("\n");
				else sb.append("0").append("\n");
				break;
			case "front":
				if (queue.size()>0) sb.append(queue.peek()).append("\n");
				else sb.append("-1").append("\n");
				break;
			case "back":
				if (queue.size()>0) sb.append(queue.getLast()).append("\n");
				else sb.append("-1").append("\n");
				break;
			}
			
		}
		System.out.println(sb);
	}

}
