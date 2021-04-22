import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k, result;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	k = stoi(stk.nextToken());
    	
    	graph = new int[n + 1][n + 1];
    	
    	int from, to;
    	for(int i = 1; i <= m; i++) {
    		stk = new StringTokenizer(br.readLine());
    		from = stoi(stk.nextToken());
    		to = stoi(stk.nextToken());
    		graph[from][to] = i;
    		graph[to][from] = i;    		
    	}
    	
    	next : for(int i = 0; i < k; i++) {
    		// 삭제 할 간선을 찾는다.
    		int a = 0,b = 0;
    		int minVertex = Integer.MAX_VALUE;
    		
    		// -------- prim 알고리즘 -------------
    		int[] minNode = new int[n + 1];
    		boolean[] vis = new boolean[n+1];
    		Arrays.fill(minNode, Integer.MAX_VALUE);
    		result = 0;
    		int min, curN = 0;
    		minNode[1] = 0;
    		for(int j = 0; j < n; j++) {
    			min = Integer.MAX_VALUE;
    			for(int l = 1; l <= n; l++) {
    				if(!vis[l] && min > minNode[l]) {
    					curN = l;
    					min = minNode[l];
    				}
    			}
    			// 다음 노드를 찾을 수 없으면, MST를 만들 수 없다
    			if(min == Integer.MAX_VALUE) {
    				System.out.print(0 + " ");
    				continue next;
    			}
    			
    			vis[curN] = true;
    			result += min;
    			
    			for(int l = 1; l <= n; l++) {
    				if(!vis[l] && minNode[l] > graph[curN][l] && graph[curN][l] != 0) {
    					minNode[l] = graph[curN][l];
    					// 현재 MST에서 제일 작은 간선의 정보를 얻는다.
    					if(minVertex > graph[curN][l]) {
    						minVertex = graph[curN][l];
    						a = curN;
    						b = l;
    	    			}
    				}
    			}
    		}
    		// 제일 비용이 적은 간선 삭제
    		graph[a][b] = 0;
    		graph[b][a] = 0;
    		System.out.print(result + " ");
    	}
    	
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}