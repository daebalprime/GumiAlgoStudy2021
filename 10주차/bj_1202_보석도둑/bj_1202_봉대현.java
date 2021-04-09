package a_10weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_1202_보석도둑 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		gem []g=new gem[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			g[i]= new gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int bag[]=new int[k];
		for (int i = 0; i < k; i++) {
			bag[i]=Integer.parseInt(in.readLine());
		}
		//무게순으로 오름 차순 정렬 
		Arrays.sort(g);
		Arrays.sort(bag);
		
		long result = 0;//보석의 가치가 21억을 넘어가기 때문에 long
		int idx=0;
		
		for(int i=0;i<k;i++) {//가방의 개수만큼 
			
			while(idx<n&&g[idx].m<=bag[i]) {
				//보석의 가치를 내림차순으로 넣기위해 -
				pq.add(-g[idx].v);
				idx++;
			}
			
			if(!pq.isEmpty()) {//제일 보석의 가치가 높은 것부터  가방에 넣기
				result+=Math.abs(pq.poll());
			}
		}
		
		System.out.println(result);
		in.close();
	}

	static class gem implements Comparable<gem> {
		int m;
		int v;

		public gem(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(gem o) {
			return Integer.compare(this.m, o.m);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("gem [m=").append(m).append(", v=").append(v).append("]");
			return builder.toString();
		}

	}
}
