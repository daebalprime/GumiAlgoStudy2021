package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_3190_뱀_구미_4_이동현 {
	static int[][] map;
	static int N, K, L, count, x, y, dir, len, time, idx, tailx, taily;
	static String change;
	static List<String[]> com;
	static List<int[]> past;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		K = stoi(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken())][stoi(st.nextToken())] = 2;
		}
		map[1][1] = 1;
		L = stoi(br.readLine());
		com = new ArrayList<>();
		past = new ArrayList<>();
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			com.add(new String[]{st.nextToken(), st.nextToken()});
		}
//		for(int[] a : map) System.out.println(Arrays.toString(a));
//		for(String[] a : com) System.out.println(Arrays.toString(a));
		x = 1; y = 1; dir = 0; len = 1; count = 0;
		idx = 0;
		past.add(new int[] {1,1});
		time = stoi(com.get(idx)[0]);
		change = com.get(idx)[1];
		while (true) {
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (1<= nx && nx <= N && 1<= ny && ny <= N && map[nx][ny]!= 1) {
				
				if (map[nx][ny] != 2) {
					past.add(new int[]{nx,ny});
					map[past.get(0)[0]][past.get(0)[1]] = 0;
					past.remove(0);
					
				} else {
					past.add(new int[]{nx,ny});
				}
				x = nx; y = ny;
			} else {
				System.out.println(count+1);
				return;
			}
			mark();
			count++;
			
			if (count == time) {
				if (change.equals("L")) {
					dir -= 1;
					if (dir < 0) dir = 3;
				} else {
					dir = (dir + 1) % 4;
				}
				if (++idx < com.size()) {
					time = stoi(com.get(idx)[0]);
					change = com.get(idx)[1];
				}
			}
		}
	}
	static void mark() {
		for (int i = 0; i < past.size(); i++) {
			map[past.get(i)[0]][past.get(i)[1]] = 1;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
