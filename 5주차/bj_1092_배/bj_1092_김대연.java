package bj_1092;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[][] crane = new Integer[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			crane[i][0] = Integer.parseInt(st.nextToken());
			crane[i][1] = 0;
		}
		Comparator<Integer[]> cpr = new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[1] != o2[1]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0],o2[0]);
			}
			
		};
		Arrays.sort(crane, cpr);
		
		int M = Integer.parseInt(br.readLine());
		Integer[] boxes = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
			if(boxes[i] > crane[N-1][0]) {
				System.out.println("-1");
				System.exit(0);
			}
		}
		Arrays.sort(boxes, (o1,o2)->(Integer.compare(o2, o1)));
		for(int i = 0; i < M; i++) {
			int curr = boxes[i];
			for(Integer[] ia : crane) {
				if(ia[0] >= curr) {
					ia[1]++;
					Arrays.sort(crane, cpr);
					for(Integer[] iaa : crane) {
						System.out.print(Arrays.toString(iaa));
					}
					System.out.println();
					break;
				}
			}
		}
		int answer = 0;
		for(Integer[] ia : crane) {
			System.out.println(Arrays.toString(ia));
			answer = Math.max(answer, ia[1]);
		}
		System.out.println(answer);
//		System.out.println(Arrays.toString(crane));
//		System.out.println(Arrays.toString(counting));
		br.close();
	}
}
