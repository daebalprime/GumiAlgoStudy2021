package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_18258_손현주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int last =0;
		// 명령의 수
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				q.add(last);
				break;
			case "pop":
				if (q.isEmpty())
					sb.append("-1").append('\n');
				else
					sb.append(q.poll()).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty()) sb.append("1").append('\n');
				else sb.append("0").append('\n');
				break;
			case "front":
				if(q.isEmpty()) sb.append("-1").append('\n');
				else sb.append(q.peek()).append('\n');
				break;
			case "back":
				if(q.isEmpty()) sb.append("-1").append('\n');
				else sb.append(last).append('\n');
				break;
			}
		}
			System.out.println(sb);
	}

}
