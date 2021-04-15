package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20208_진우의민트초코우유_구미_4_이동현 {
	static int N,M,H,max,homeX,homeY,minchoCnt;
	static int[][] map;
	static List<int[]> mincho;
	static int[] nums;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken()); H = stoi(st.nextToken());
		map = new int[N][N];
		mincho = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 1) {
					homeX = i;
					homeY = j; 
				} else if (map[i][j] == 2) {
					mincho.add(new int[] {i,j});
					minchoCnt++;
				}
			}
		}
		nums = new int[minchoCnt];
		check = new boolean[minchoCnt];
		permu(0);
		System.out.println(max);
	}
	static void permu(int idx) {
		if (idx == minchoCnt) {
			find();
			return;
		}
		for (int i = 0; i < minchoCnt; i++) {
			if (check[i]) continue;
			check[i] = true;
			nums[idx] = i;
			permu(idx+1);
			check[i] = false;
		}
	}
	static void find() {
		int x = homeX;
		int y = homeY;
		int power = M;
		int cnt = 0;
		for (int i = 0; i < minchoCnt; i++) {
			int mx = mincho.get(nums[i])[0];
			int my = mincho.get(nums[i])[1];
			int dist = getDist(x,y,mx,my);
			int home = getDist(homeX,homeY,mx,my);
			if (dist <= power) {
				cnt++;
				power-=dist;
				power+=H;
				if (home <= power) {
					max = Math.max(max, cnt);
				}
				x = mx;
				y = my;
			} else return;
		}
	}
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
