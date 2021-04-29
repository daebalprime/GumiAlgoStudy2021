import java.util.*;
import java.io.*;

public class Main {
	static int n, m, result;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	
    	parent = new int[n];
    	
    	init();
    	
    	int time = 0;
    	int from, to;
    	for(int i = 0; i < m; i++) {
    		stk = new StringTokenizer(br.readLine());
    		from = stoi(stk.nextToken());
    		to = stoi(stk.nextToken());
    		if(!union(from,to)) {		// 사이클이 만들어 진다면
    			time = i + 1;
    			break;
    		}
    	}
    	
    	System.out.println(time);
    	
    	br.close();
	}
	// --------- disjoint set 시작 --------------
	static void init() {
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int num) {
		if(num == parent[num])
			return num;
		return parent[num] = findSet(parent[num]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)			// 부모 노드가 같으면, 사이클이 만들어 진 것이다.  
			return false;
		int min = Math.min(aRoot, bRoot);
		parent[aRoot] = min;
		parent[bRoot] = min;		
		return true;
	}
	// --------- disjoint set 끝 --------------
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}