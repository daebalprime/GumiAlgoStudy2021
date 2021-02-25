package hwalgo14_구미_4_김소빈;

import java.util.*;
import java.io.*;

public class Main_bj_13458_시험감독_구미_4_김소빈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long cnt = 0;
		int left;
		for (int i = 0; i < N; i++) {
			left = A[i] - B;
			cnt += 1;
			if(left>0) {
				cnt += left/C;
				if(left%C > 0) cnt += 1;
			}
			
		}
		System.out.println(cnt);
	}
}
