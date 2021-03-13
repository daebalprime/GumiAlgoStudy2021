/*
14889번 - 스타트와 링크
https://www.acmicpc.net/problem/14889
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result = Integer.MAX_VALUE;
	static int[][] stat;
	static boolean[] sel;
	static int[] a , b;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	stat = new int[n][n];
    	sel = new boolean[n];
    	a = new int[n / 2];
    	b = new int[n / 2];
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			stat[i][j] = stoi(stk.nextToken());
    		}
    	}
    	
    	DFS(0, 0);
    	System.out.println(result);
    	br.close();
	}
	
	static void DFS(int lv, int st) {
		// n/2 명의 선수들을 뽑는다.
		if(lv == n / 2 ) {
			int aIdx = 0, bIdx = 0, aV = 0, bV = 0;
			// 뽑은 사람을 각 팀으로 할당
			for(int i = 0; i < n; i++) {
				if(sel[i])
					a[aIdx++] = i;
				else
					b[bIdx++] = i;
			}
			// 총 능력치를 구한다
			for(int i = 0; i < n / 2; i++) {
				for(int j = 0; j < n / 2; j++) {
					if(i == j)
						continue;
					aV += stat[a[i]][a[j]];
					bV += stat[b[i]][b[j]];
				}
			}
			// 능력치 차이 중 최솟 값을 구한다.
			result = Math.min(Math.abs(aV - bV) , result);
			return;
		}
		
		for(int i = st; i < n; i++) {
			if(!sel[i]) {
				sel[i] = true;
				DFS(lv + 1, i + 1);
				sel[i] = false;
			}
		}
		
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}