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
//			PriorityQueue<int[]> pq = new PriorityQueue<>(
//					(o1,o2)->Integer.compare(o1[0],o2[0]));
			int N = Integer.parseInt(br.readLine());
			int[] applicants = new int[N];
			int interview = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				applicants[s1-1] = s2;
				if(s1 == 1) interview = s2;
			}
			int answer = 1;
			int max = interview;
			for(int i = 0; i < N; i++){
				int tmp = applicants[i];
				if(tmp < interview) {
					answer++;
					interview = tmp;
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
