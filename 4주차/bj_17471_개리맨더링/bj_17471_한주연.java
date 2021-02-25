/*
17471번 - 게리맨더링
https://www.acmicpc.net/problem/17471
*/

import java.util.*;
import java.io.*;

public class Main {
	static int MAX_NUM = 987654321;
	static int n, result = MAX_NUM;
	static int[] value, nodes;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	value = new int[n + 1];
    	nodes = new int[n + 1];
    	graph = new int[n + 1][n + 1];
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		value[i] = stoi(stk.nextToken());
    	}
    	for(int i = 1; i <= n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		int size = stoi(stk.nextToken());
    		for(int j = 0; j < size; j++) {
        		graph[i][stoi(stk.nextToken())] = 1;
        	}
    	}

    	DFS(0,n,0);
    	if(result == MAX_NUM)
    		System.out.println(-1);
    	else
    		System.out.println(result);
    	
    	br.close();
	}
	static int[] chkNode_1, chkNode_2;
	static void DFS(int lv, int size, int sum) {
		if(lv == n) {
			chkNode_1 = nodes.clone();
			boolean isDupli = false;
			for(int i = 1; i <= n; i++) {
				if(chkNode_1[i] == 0) {
					// 다시 또 들어 왔을 때
					if(isDupli) {
						return;
					}
					chkConnect(i, chkNode_1, 0);
					isDupli = true;
				}
			}
			
			chkNode_2 = nodes.clone();
			boolean isDupli2 = false;
			for(int i = 1; i <= n; i++) {
				if(chkNode_2[i] == 1) {
					// 다시 또 들어 왔을 때
					if(isDupli2) {
						return;
					}
					chkConnect(i, chkNode_2, 1);
					isDupli2 = true;
				}
			}
			
			int oSum = 0;
			for(int i = 1; i <= n; i++) {
				if(nodes[i] == 0) {
					oSum += value[i];
				}
			}
			result = Math.min(result, Math.abs(oSum - sum));
			//System.out.println(sum + " ok");
			return;
		}
		
		nodes[lv] = 1;
		DFS(lv + 1, size, sum + value[lv]);
		nodes[lv] = 0;
		DFS(lv + 1, size, sum);
		
	}
	
	static void chkConnect(int s, int[] chkNode, int idx) {
		if(idx == 0)
			chkNode[s] = 1;
		else
			chkNode[s] = 0;
		
		for(int i = 1; i <= n; i++) {
			if(graph[s][i] == 1 && chkNode[i] == idx) {
				chkConnect(i, chkNode, idx);
			}
		}
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}