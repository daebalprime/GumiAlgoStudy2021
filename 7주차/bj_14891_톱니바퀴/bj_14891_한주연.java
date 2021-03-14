/*
123번 - asdf
https://www.acmicpc.net/problem/123
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result = 0;
	static List<List<Integer>> gear;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	
    	gear = new ArrayList<>();
    	for(int i = 0; i < 4; i++) {
    		gear.add(new ArrayList<Integer>());
    		String str = br.readLine();
    		for(int j = 0; j < 8; j++) {
    			gear.get(i).add(str.charAt(j) - '0');
    		}
    	}
    	n = stoi(br.readLine());
    	int gearN, dir;
    	while(n > 0) {
    		stk = new StringTokenizer(br.readLine());
    		gearN = stoi(stk.nextToken());
    		dir = stoi(stk.nextToken());
    		turn(gearN - 1, dir, new boolean[4]);
    		n--;
    	}
    	int[] score = {1,2,4,8};
    	for(int i = 0; i < 4; i++) {
    		if(gear.get(i).get(0) == 1) {
    			result += score[i];
    		}
    	}
    	System.out.println(result);
    	br.close();
	}
	
	static void turn(int m, int dir, boolean[] vis) {
		vis[m] = true;
		// 제일 왼쪽 기어일 때
		if(m == 0) {
			if(!vis[m + 1] && gear.get(m).get(2) != gear.get(m+1).get(6)) {
				turn(m + 1, CngDir(dir), vis);
			}
		}
		// 제일 오른쪽 기어일 때
		else if(m == 3) {
			if(!vis[m - 1] && gear.get(m).get(6) != gear.get(m-1).get(2)) {
				turn(m - 1, CngDir(dir), vis);
			}
		}
		else {
			// 자신보다 오른쪽 기어를 확인
			if(!vis[m + 1] && gear.get(m).get(2) != gear.get(m+1).get(6)) {
				turn(m + 1, CngDir(dir), vis);
			}
			// 자신보다 왼쪽 기어를 확인
			if(!vis[m - 1] && gear.get(m).get(6) != gear.get(m-1).get(2)) {
				turn(m - 1, CngDir(dir), vis);
			}
		}
		// 이제 자기 자신을 돌린다.
		TurnGear(m,dir);
	}
	
	static void TurnGear(int m, int dir) {
		int num;
		// 시계방향
		if(dir == 1) {
			num = gear.get(m).get(7);
			gear.get(m).remove(7);
			gear.get(m).add(0,num);
		}
		// 반시계방향
		else {
			num = gear.get(m).get(0);
			gear.get(m).remove(0);
			gear.get(m).add(num);
		}
	}
	
	static int CngDir(int dir){
		if(dir == -1)
			return 1;
		return -1;
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}