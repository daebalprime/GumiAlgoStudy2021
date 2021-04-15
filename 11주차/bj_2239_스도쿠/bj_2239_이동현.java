package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2239_스도쿠_구미_4_이동현 {
	static int[][] map;
	static int[][] nums;
	static List<int[]> zero;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		nums = new int[9][9];
		zero = new ArrayList<>();
		sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9;j++) {
				map[i][j] = tmp[j] - '0';
				if (map[i][j] == 0) zero.add(new int[] {i,j}); 
			}
		}
		dfs(0);
		
	}
	static void dfs(int idx) {
		if (idx == zero.size()) {
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int[] cur = zero.get(idx);
		for (int i = 1; i <= 9; i++) {
			if(isPossible(cur,i)) {
				map[cur[0]][cur[1]] = i;
				dfs(idx+1);
				map[cur[0]][cur[1]] = 0;
			}
		}
	}
	static boolean isPossible(int[] site,int num) {
		for (int i = 0; i < 9;i++) { // 행, 열 검사
			if(map[i][site[1]] == num) return false;
			if(map[site[0]][i] == num) return false;
		}
		int nx = (site[0] / 3) * 3;
		int ny = (site[1] / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[nx + i][ny + j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
