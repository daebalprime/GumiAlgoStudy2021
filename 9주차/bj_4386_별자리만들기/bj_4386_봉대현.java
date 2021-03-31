package a_9weeks;

import java.util.*;
import java.io.*;

//prim으로 ㄱㄱ
public class Main_bj_4386_별자리만들기 {
	static ArrayList<double[]> stars;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		stars = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			double[] temp = { Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()) };
			stars.add(temp);
		}
		ArrayList<double[]> dist[] = new ArrayList[n];
		for (int i = 0; i < n; i++)
			dist[i] = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			double x = stars.get(i)[0];
			double y = stars.get(i)[1];
			for (int j = i + 1; j < n; j++) {
				double x1 = stars.get(j)[0];
				double y1 = stars.get(j)[1];
				double num = getdistance(x, y, x1, y1);
				dist[i].add(new double[] { j, num });
				dist[j].add(new double[] { i, num });
			}
		}
		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[1], o2[1]);
			}
		});
		boolean visit[]=new boolean[n];
		pq.add(new double[] {0,0});
		int cnt=0;
		double result=0;
		while(!pq.isEmpty()) {
			double temp[]=pq.poll();
			if(visit[(int)temp[0]])continue;
			visit[(int)temp[0]]=true;
			result+=temp[1];
			
			for(double node[]:dist[(int)temp[0]]) {
				if(!visit[(int)node[0]])
					pq.add(node);
			}
			if(++cnt==n)break;
		}
		System.out.printf("%.2f",result);
		in.close();
	}

	static double getdistance(double x, double y, double x1, double y1) {
		double d = Math.pow(Math.abs(x - x1), 2) + Math.pow(Math.abs(y - y1), 2);
		return Math.sqrt(d);
	}
}
