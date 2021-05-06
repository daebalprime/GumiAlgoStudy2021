package bj_7579;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N개 앱
		int M = Integer.parseInt(st.nextToken()); // M바이트
		int[] memUsage = new int[N];
		int[] initCost = new int[N];
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int totalMem = 0;
		int totalCost = 0;
		for(int i = 0; i < N; i++) {
			totalMem += memUsage[i] = Integer.parseInt(st.nextToken());
			totalCost += initCost[i] = Integer.parseInt(st2.nextToken());
		}
		int[] dpA = new int[totalMem+1-M];
		int[] dpB = new int[totalMem+1-M];
		for(int j = 1; j <= N; j++) {
			int[] dp1= null;
			int[] dp2= null;
			if(j%2==0) {
				dp1 = dpA;
				dp2 = dpB;
			}else {
				dp2 = dpA;
				dp1 = dpB;
			}
			int currMem = memUsage[j-1];
			int currCost = initCost[j-1];
			for(int i = 0; i <= totalMem-M; i++) {
				if(i >= currMem) {
					dp2[i] = Math.max(dp1[i], dp1[i-currMem]+currCost);
				}else {
					dp2[i] = dp1[i];
				}
			}
		}
		System.out.println(totalCost - Math.max(dpA[totalMem-M],dpB[totalMem-M]));
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
