import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static long result;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	while(true) {
    		stk = new StringTokenizer(br.readLine());
	    	n = stoi(stk.nextToken());	// 집의 수
	    	m = stoi(stk.nextToken());	// 길의 수
	    	result = 0;
			// n과 m이 0, 0이라면 입력이 종료된다.
	    	if(n == 0 && m == 0)
	    		break;
	    	
	    	parent = new int[n]; 
	    	
	    	PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2)->{return Integer.compare(o1.v, o2.v);});
	    	int from, to, v;
	    	for(int i = 0; i < m; i++) {
	    		stk = new StringTokenizer(br.readLine());
	    		from = stoi(stk.nextToken());
	    		to = stoi(stk.nextToken());
	    		v = stoi(stk.nextToken());;
	    		pq.add(new Road(from,to,v));
	    		result += v;
	    	}
	    	
	    	init();
	    	
	    	Road rd;
	    	int cnt = 0;
	    	long sum = 0;
	    	
	    	while(!pq.isEmpty()) {
	    		rd = pq.poll();
	    		// 간선 연결 개수는 정점의 수 - 1 개
	    		if(cnt == n - 1)
					break;
	    		
	    		if(union(rd.from, rd.to)) {
	    			sum += rd.v;
	    			cnt++;
	    		}
	    	}
	    	
	    	System.out.println(result - sum);
    	}
    	br.close();
	}

	static void init() {
		for(int i = 0; i < n; i++)
			parent[i] = i;
	}
	
	static int findSet(int num) {
		if(num == parent[num])
			return num;
		return parent[num] = findSet(parent[num]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		int min = Math.min(aRoot, bRoot);
		parent[aRoot] = min;
		parent[bRoot] = min;
		return true;
	}
	
	static class Road{
		int from, to, v;

		public Road(int from, int to, int v) {
			super();
			this.from = from;
			this.to = to;
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[from=").append(from).append(", to=").append(to).append(", v=").append(v).append("]");
			return builder.toString();
		}
		
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}