package bj_17471;

import java.io.*;
import java.util.*;

public class Main {
	static int N, answer, max;
	static int[][] edges;
	static int[] population;
	static boolean[] visited;
	static Stack<Integer> r = new Stack<>();
	static Stack<Integer> b = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		visited = new boolean[N];
		edges = new int[N][];
		answer = Integer.MAX_VALUE;
		max = (int)Math.pow(2, N);
//		boolean[] initCheck = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sz = Integer.parseInt(st.nextToken());
			edges[i] = new int[sz];
			for(int k = 0; k < sz; k++) {
				edges[i][k] = Integer.parseInt(st.nextToken())-1;
//				initCheck[edges[i][k]] = true;
			}
		}
//		int isolation = 0;
//		for(int i = 0; i < N; i++) {
//			if(initCheck[i]) isolation++;
//		}
//		if(isolation != N) {
//			sb.append(-1);
//		}
		// 틀린 이유 : 만약 2개의 지역구가 서로 연결되지 않은 상태로 있다면?
		subset();		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	static int calDiff(int check) {
//		r.clear();
//		b.clear();
		int rsum = population[N-1];
		int bsum = 0;
		int visited = 1<<(N-1);
		r.push(N-1);
		
		for(int i = 0; i < N; i++) {
			if((check & 1 << i) > 0) {
				b.push(i);
				visited |= 1 << i;
				bsum += population[i];
				break;
			}
		}
		while(!r.isEmpty()){
			int curr = r.pop();
			for(int i : edges[curr]) {
				if((visited & 1 << i) == 0 && 
						(check & 1<< i) == 0) {
					r.push(i);
					visited |= 1 << i;
					rsum += population[i];
				}
			}
		}
		while(!b.isEmpty()){
			int curr = b.pop();
			for(int i : edges[curr]) {
				if((visited & 1 << i) == 0 &&
						(check & 1 << i) > 0) {
					visited |= 1 << i;
					b.push(i);
					bsum += population[i];
				}
			}
		}
		if(visited != max -1) {
			return Integer.MAX_VALUE;
		}
		return Math.abs(rsum-bsum);
	}
	
	static void subset() {
		for(int i = 1; i <= max/2 - 1; i++) {
			answer = Math.min(answer, calDiff(i));
			if(answer == 0) break;
		}
	}
}

//최적화가 가능해 보이는 부분
// 1. stack 대신 integer array 사용
// 2. 중간계산값을 가지고 가지치기하기


/*
6
2 2 2 2 2 2
1 3 
1 4 
1 1 
1 2 
1 6
1 5

//정답 -1

10
1 2 3 4 5 6 7 8 9 10
2 2 10 
2 3 1
2 4 2
2 5 3
2 6 4
2 7 5
2 8 6
2 9 7
2 10 8
2 1 9

//정답 1
 
2
3 4
0
0

//정답 1
 
 * */
