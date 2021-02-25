package bj_1946;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(o1,o2)->Integer.compare(o1[0],o2[0]));
			int N = Integer.parseInt(br.readLine());
			int interview = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int[] tmp = new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
						};
				pq.offer(tmp);
				if(tmp[0] == 1) interview = tmp[1];
				
			}
			int answer = 1;
			int itr = 0;
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				if(tmp[1]< interview) {
					answer++;
					interview = tmp[1];
				}
			}
			sb.append(answer + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
