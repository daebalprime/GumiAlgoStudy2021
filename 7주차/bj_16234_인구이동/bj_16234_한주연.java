/*
16234번 - 인구 이동
https://www.acmicpc.net/problem/16234

1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100
0 ≤ A[r][c] ≤ 100
인구 이동이 발생 횟수 <= 2000
제한시간 : 2초

1. 어떻게 연합끼리 나눌것인가?
-> BFS?

1. 0,0 ~ n-1, n-1 까지 하나씩 탐색
2. bfs를 이용하여 근처에 갈 수 있는 모든 곳 방문
3. 방문 할 때마다 cnt 증가, 총합 증가, 방문했다는 증거 남긴다
4. 방문 했던 곳의 인구를 균등하게 분배
5. 1번~4번 과정을 while문으로 돌린다 -> 인구 이동이 발생하는 횟수
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, L, R, result;
	static int[][] A;
	static boolean[][] vis;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	L = stoi(stk.nextToken());
    	R = stoi(stk.nextToken());
    	A = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			A[i][j] = stoi(stk.nextToken());
    		}
    	}
    	
    	boolean isMoved = false;
    	do {
    		vis = new boolean[n][n];
    		isMoved = false;
    		// map 전체를 다 탐색하여 갈 수 있는 모든 곳을 간다
    		for(int i = 0; i < n; i++) {
    			for(int j = 0; j < n; j++) {
    				if(!vis[i][j]) {
    					// 한번이라도 연합을 구성하였으면, 이동하였다고 표시를 남긴다.
    					if(!isMoved)
    						isMoved = BFS(i,j);
    					else {
    						BFS(i,j);
    					}
    				}
    			}
    		}
    		
    		if(isMoved) {// 인구 이동 횟수 증가
    			result++;
    		}
    	}while(isMoved);
    	
    	
    	System.out.println(result);
    	br.close();
	}
	// 우 하 좌 상
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	private static boolean BFS(int y, int x) {
		boolean ismoved = false;
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> saved = new LinkedList<>();
		q.add(new Pair(y,x));
		int sum = 0, cnt = 0, ny, nx;
		Pair p;
		while(!q.isEmpty()) {
			p = q.poll();
			saved.add(p);
			// 현재 점에서 우 하 좌 상으로 탐색한다
			for(int i = 0; i < 4; i++) {
				ny = p.y + dy[i];
				nx = p.x + dx[i];
				// 현재 점과 새로운 점의 차이가 L과 R사이이며, 한번도 방문 안했다면
				if(isIn(ny,nx,n) && !vis[ny][nx] && CanMove(A[p.y][p.x], A[ny][nx])) {
					q.add(new Pair(ny,nx));
					ismoved = true;
					sum += A[ny][nx];
					vis[ny][nx] = true;
					cnt++;
				}
			}
		}
		
		if(ismoved) { // 한 번이라도 연합 되면
			int rst = sum / cnt;
			while(!saved.isEmpty()) {
				p = saved.poll();
				A[p.y][p.x] = rst; 
			}
		}
		else {	// 연합이 되지 않으면
			vis[y][x] = false;
		}
		
		return ismoved;
	}
	
	public static class Pair{
    	int y;
    	int x;
    	Pair(int k,int v){
    		y = k;
    		x = v;
    	}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(y).append(", ").append(x).append("]");
			return builder.toString();
		}	
    }
	// 주어진 범위 안에 있는가
    public static boolean isIn(int y, int x, int size){
        if(y < 0 || y == size || x < 0 || x == size)
            return false;
        return true;
    }
    
    public static boolean CanMove(int A, int B) {
    	int diff = Math.abs(A - B);
    	if(L <= diff && diff <= R) {
    		return true;
    	}
    	return false;
    }
    
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}