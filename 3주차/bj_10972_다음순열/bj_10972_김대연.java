package bj_10972;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		br.close();
		int[] ia = new int[N];
		for(int i = 0; i < N; i++) {
			ia[i] = Integer.parseInt(st.nextToken());
		}
		
		// 뒤에서 읽어가면서 오름차순인거 찾기
		// 오름차순에 위배되는 숫자까지 대상 순열로 잡기
		int next = -1;
		int index = -1;
		pq.offer(ia[N-1]);
		for(int i = N-2; i >= 0; i--) {
			if(ia[i] < ia[i+1]) {
				next = ia[i];
				index = i;
				break;
			}
			pq.offer(ia[i]);
		}
		// 만약 그 위배되는 수가 N이랑 같다면 -1 출력하기
		if(next == -1) {
			bw.write("-1");
			bw.flush();
			return;
		}
//		System.out.println(index+ " " +next);
		// 순열 내에서 오름차순에 위배되는 수의 다음 숫자를 를 찾기
		int nn = Integer.MAX_VALUE;
		while(true) {			
			for(int i = index+1; i < N; i++) {
				if(next < ia[i]) {
					nn = Math.min(nn, ia[i]);
				}
			}
			if(nn == Integer.MAX_VALUE) {				
				pq.offer(next);
				next = ia[--index];
			}
			else break;
		}
		pq.offer(next);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < index; i ++) {
			sb.append(ia[i] + " ");
		}
		sb.append(nn);
		int i = 1;
		while(!pq.isEmpty()) {
			if(pq.peek() == nn) {
				pq.poll();
//				System.out.println("----------"+nn);
				continue;
			}
			sb.append(" " + pq.poll());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		// 다음 숫자를 순열의 가장 왼쪽에 놓은 뒤에 정렬하여 숫자 놓기
		// 출력하기
		
	}

}
