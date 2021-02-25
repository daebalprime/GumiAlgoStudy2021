/*
1780번 - 종이의 개수
https://www.acmicpc.net/problem/1780
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, minus = 0, zero = 0, plus = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	arr = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			arr[i][j] = stoi(stk.nextToken());
    		}
    	}
    	
    	Paper(0,0,n);
    	System.out.println(minus);
    	System.out.println(zero);
    	System.out.println(plus);
    	br.close();
	}
	
	static void Paper(int y, int x, int size) {
		if(size == 1) {
			check(arr[y][x]);
			return;
		}
		
		int pivot = arr[y][x];
		boolean isSame = true;
		end : for(int i = y; i < size + y; i++) {
			for(int j = x; j < size + x; j++) {
				if(pivot != arr[i][j]) {
					isSame = false;
					break end;
				}
			}
		}
		if(isSame) {
			check(pivot);
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					Paper(y + i * (size / 3), x + j * (size / 3), size / 3);
				}
			}
		}
	}
	static void check(int num) {
		switch(num) {
		case -1:
			minus++;
			break;
		case 0:
			zero++;
			break;
		case 1:
			plus++;
			break;
		}
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}