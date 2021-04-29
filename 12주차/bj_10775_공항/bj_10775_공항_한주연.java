import java.util.*;
import java.io.*;

public class Main {
	static int G,P, result;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	G = stoi(br.readLine());
    	P = stoi(br.readLine());
    	
    	parent = new int[G + 1];
    	
    	int curG;
    	init();
    	for(int i = 0; i < P; i++) {
    		curG = stoi(br.readLine());
			// 만약 넣으려는 게이트가 이미 꽉차있으면
    		if(findSet(curG) == 0)
    			break;
			// 현재 게이트와 이전 게이트와 유니온
    		union(curG, findSet(curG) - 1);
    		result++;
    	}
    	
    	System.out.println(result);
    	br.close();
	}
	// --------- Disjoint Set 시작 ------------
	static void init() {
		for(int i = 1; i <= G; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int num) {
		if(parent[num] == num)
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
	// --------- Disjoint Set 끝 ------------
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}