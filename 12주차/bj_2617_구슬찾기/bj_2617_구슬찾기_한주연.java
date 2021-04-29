import java.util.*;
import java.io.*;

public class Main {
	static int n, m, result, downCnt, upCnt;
	
	static boolean[][] up, down;
	static boolean[] upVis, downVis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	
    	up = new boolean[n+1][n+1];
    	down = new boolean[n+1][n+1];	
    	
    	int big, small;
    	for(int i = 0; i < m; i++) {
    		stk = new StringTokenizer(br.readLine());
    		big = stoi(stk.nextToken());
    		small = stoi(stk.nextToken());
    		down[big][small] = true;	// 무거운 구슬에서 가벼운 구슬로
    		up[small][big] = true;		// 가벼운 구슬에서 무거운 구슬로
    	}
    	
    	int bound = (n / 2) + 1;		// 중간이 될 수 없는 경계 값
    	for(int i = 1; i <= n; i++) {
    		init();
    		FindDown(i);				// 현재 구슬보다 가벼운 구슬을 찾는다.
    		FindUp(i);					// 현재 구슬보다 무거운 구슬을 찾는다.
    		if(upCnt >= bound || downCnt >= bound)
    			result++;
    	}
    	
    	System.out.println(result);
    	
    	br.close();
	}
	// 구슬 방문여부, 개수 초기화
	private static void init() {
		upVis = new boolean[n+1];
    	downVis = new boolean[n+1];
    	upCnt = 0;
    	downCnt = 0;
	}
	// 시작 구슬부터 더 가벼운 구슬들을 찾는다
	private static void FindDown(int num) {
		for(int i = 1; i <= n; i++) {
			if(down[num][i] && !downVis[i]) {
				downVis[i] = true;
				downCnt++;
				FindDown(i);
			}
		}
	}
	// 시작 구슬부터 더 무거운 구슬들을 찾는다
	private static void FindUp(int num) {
		for(int i = 1; i <= n; i++) {
			if(up[num][i] && !upVis[i]) {
				upVis[i] = true;
				upCnt++;
				FindUp(i);
			}
		}
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}