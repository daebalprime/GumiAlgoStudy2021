
/*
17779번 - 게리맨더링 2 
https://www.acmicpc.net/problem/17779
1. 0,1 에서 부터 N-3,N-2 까지 탐색한다
2. 각 점에서 d1을 1부터 범위 벗어날때까지, d2를 1부터 범위 벗어날 때 까지 탐색
3. 경계를 그린다.
4. 그려진 경계에 따라 선거구의 인구수를 구한다.
5. 가장 많은 선거구 인구 수와 가장 적은 선거구 인구 수의 차이를 구한다. 
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result = Integer.MAX_VALUE, maxH;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt")); // 제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = stoi(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = stoi(stk.nextToken());
				maxH += map[i][j];
			}
		}
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 1; j <= n - 2; j++) {
				makeBound(i,j);
			}
		}
		System.out.println(result);
		br.close();
	}

	// 경계선 그을 필요 값 만들기
	static void makeBound(int y, int x) {
		int d1 = 1, d2 = 1;
		while (x - d1 >= 0 && y + d1 + d2 < n) {
			while (x + d2 < n && y + d1 + d2 < n) {
				result = Math.min(cal(y, x, d1, d2, new boolean[n][n]), result);
				d2++;
			}
			d1++;
			d2 = 1;
		}
	}

	// 경계선 긋기
	static int cal(int y, int x, int d1, int d2, boolean[][] vis) {
		int diff = 0;
		int[] area = new int[5];
		vis[y][x] = true;
		for (int i = 1; i <= d1; i++) {
			vis[y + i][x - i] = true; // 1
			vis[y + d2 + i][x + d2 - i] = true; // 4
		}
		for (int i = 1; i <= d2; i++) {
			vis[y + i][x + i] = true; // 2
			vis[y + d1 + i][x - d1 + i] = true; // 3
		}
		//---------------------------------------------------
		area[4] = maxH;
		
		for(int i = 0; i < y + d1; i++) {		// 1
			for(int j = 0; j <= x; j++ ) {
				if(vis[i][j])
					break;
				area[0] += map[i][j];
			}
		}
		for(int i = 0; i <= y + d2; i++) {		// 2
			for(int j = n - 1; j > x; j-- ) {
				if(vis[i][j])
					break;
				area[1] += map[i][j];
			}
		}
		for(int i = y + d1; i < n; i++) {	// 3
			for(int j = 0; j < x - d1 + d2; j++ ) {
				if(vis[i][j])
					break;
				area[2] += map[i][j];
			}
		}
		for(int i = y + d2 + 1; i < n; i++) {	// 4
			for(int j = n - 1; j >= x - d1 + d2; j--) {
				if(vis[i][j])
					break;
				area[3] += map[i][j];
			}
		}
		
		for(int i = 0; i < 4; i++) {
			area[4] -= area[i]; 
		}
		Arrays.sort(area);
		diff = area[4] - area[0];
		
		return diff;
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}