package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[실버 1] 케빈 베이컨의 6단계 법칙
//https://www.acmicpc.net/problem/1389
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1389_케빈베이컨의6단계법칙_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1389"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//유저의 수 N 2~100
		//관계의 수 M 1~5000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//친구 관계는 중복되어 들어올 수도 있으며
		
		//방법 1. 각 사람마다 BFS를 다 돌려서 합을 계산.
		int[][] adj = new int[n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		
		//최소 케빈 베이컨 수를 저장할 것임.
		int cavin = Integer.MAX_VALUE;
		int cavinPerson = 0;
		
		for (int i = 0; i < n; i++) {
			int visited[] = new int[n];
			cavinCount = 0;
			bfs(i, adj, visited);
			
			//케빈 베이컨의 수가 가장 작은 사람
			//여러명이면 번호가 가장 작은 사람
			if(cavinCount < cavin) {
				cavin = cavinCount;
				cavinPerson = i;
			}
			else if(cavinCount == cavin && i < cavinPerson) {
				cavinPerson = i;
			}
		}
		
		System.out.println(cavinPerson + 1); //1빼서 계산했음.
		br.close();
	}

	static int cavinCount;
	private static void bfs(int start, int[][] adj, int[] visited) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		q.offer(0);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int far = q.poll();
			if(visited[now] >= 1) continue;
			visited[now] = far;
			cavinCount += far;
			
			for (int i = 0; i < visited.length; i++) {
				if(adj[now][i] == 1) {
					q.offer(i);
					q.offer(far+1);
				}
			}
			//test
		}
		
	}
}
