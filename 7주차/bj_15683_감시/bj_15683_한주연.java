/*
15683번 - 감시
https://www.acmicpc.net/problem/15683
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, m, result = Integer.MAX_VALUE, size;
	static int[][] map;			// 지도
	static List<CCTV> cctvs;	// cctv 리스트
	static int[] direct;		// cctv가 바라보는 방향
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	map = new int[n][m];
    	cctvs = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = stoi(stk.nextToken());
    			if(0 < map[i][j] && map[i][j] < 6) {
    				cctvs.add(new CCTV(i,j,map[i][j]));
    			}
    		}
    	}
    	size = cctvs.size();
    	direct = new int[size];
    	
    	DFS(0);
    	
    	System.out.println(result);
    	br.close();
	}
	// list에 담긴 cctv가 처음 바라보는 방향들을 설정해준다.
	static void DFS(int lv) {
		if(lv == size) {
			int[][] cloneMap = new int[n][m];
			for(int i = 0; i < n; i++) {
				cloneMap[i] = map[i].clone();
			}
			cal(cloneMap);
			result = Math.min(result, getResult(cloneMap));
			return;
		}
		
		for(int i = 0; i < 4; i++) {
				direct[lv] = i;
				DFS(lv + 1);
		}
	}
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	// 타입별로 감시할 수 있는 방법이 다르므로, 타입별로 나눈다.
	static void cal(int[][] cMaps) {
		for(int idx = 0; idx < size; idx++) {
			int y = cctvs.get(idx).y;
			int x = cctvs.get(idx).x;			
			int type = cctvs.get(idx).type;
			int dir = direct[idx];
			
			switch(type) {
				case 1:
					watch(y, x, dir, cMaps);
					break;
				case 2:
					for(int i = 0; i < 2; i ++) {
						watch(y,x,dir, cMaps);
						dir = (dir + 2) % 4;
					}
					break;
				case 3:
					for(int i = 0; i < 2; i ++) {
						watch(y,x,dir, cMaps);
						dir = (dir + 1) % 4;
					}
					break;
				case 4:
					for(int i = 0; i < 3; i ++) {
						watch(y,x,dir, cMaps);
						dir = (dir + 1) % 4;
					}
					break;
				case 5:
					for(int i = 0; i < 4; i ++) {
						watch(y,x,dir, cMaps);
						dir = (dir + 1) % 4;
					}
					break;
			}
		}
	}
	// 주어진 방향대로 벽을 만날때 까지 감시를 한다.
	static void watch(int y, int x, int dir, int[][] cMaps) {
		int curY = y;
	    int curX = x;
	    while (true) {
	        curY += dy[dir];
	        curX += dx[dir];
	        if (curY == -1 || curY == n || curX == -1 || curX == m || cMaps[curY][curX] == 6) {
	            break;
	        }
	        else {
	        	cMaps[curY][curX] = 7;
	        }
	    }
	}
	
	// 결과를 구하는 메서드
	static int getResult(int[][] cMaps) {
		int temp = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (cMaps[i][j] == 0)
	                temp++;
	        }
	    }
	    return temp;
	}
	
	static class CCTV{
		int y;
		int x;
		int type;
		public CCTV(int y, int x, int type) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(y).append(", ").append(x).append(", ").append(type).append("]");
			return builder.toString();
		}
		
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}