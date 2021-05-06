package bj_9466;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
//			Map<Integer, Integer> graph = new HashMap<Integer, Integer>();
			int[] graph = new int[N];
			for(int i = 0; i < N; i++) {
//				graph.put(i, Integer.parseInt(st.nextToken())-1);
				graph[i] = Integer.parseInt(st.nextToken())-1;
			}
			int answer = N;
			for(int i = 0; i < N; i++) {
				if(graph[i] == -1) continue;
				int cycle = dfs(i,i,visited,graph);
				if(cycle == -1) continue;
				int curr = cycle;
				int tmp = 0;
				while(true) {
					if(graph[curr] == -1) {
						break;
					}
					int nxt = graph[curr];
					graph[curr] = -1;
					curr = nxt;
					tmp++;
				}
				if(curr == cycle) {
					answer -= tmp;
				}
			}
			System.out.println(answer);
		}
		br.close();
	}
	static int dfs(int start, int curr, boolean[] visited, int[] graph) {
		if(graph[curr] == -1) {
			return -1;
		}
		int nxt = graph[curr];
		if(nxt == start || visited[nxt]) {
			visited[nxt] = true;
			return nxt;
		}
		visited[nxt] = true;
		return dfs(start, nxt,visited, graph);
	}
}
