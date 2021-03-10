package bj_17779;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map, debug;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N =Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j = 0; j < N-1; j++) {
			for(int i = 0; i < N-1; i++) {
				for(int a1 = 1; a1 < N-1; a1++) {
					for(int a2 = 1; a2 < N-1; a2++) {
						if(isValid(i,j,a1,a2)) {
							int local = simulate(i,j,a1,a2);
							if(answer > local) {
								answer = local;
							}
						}
						else break;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
	static boolean isValid(int x, int y, int d1, int d2) {
		if(y+d2 < N && y-d1 >= 0 && x >= 0 && x+d1+d2 < N) return true;
		return false;
	}
	
	static int simulate(int x, int y, int d1, int d2) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int population = area1(x,y,d1,d2);
		max = Math.max(max,population);
		min = Math.min(min,population);
		population = area2(x,y,d1,d2);
		max = Math.max(max,population);
		min = Math.min(min,population);
		population = area3(x,y,d1,d2);
		max = Math.max(max,population);
		min = Math.min(min,population);
		population = area4(x,y,d1,d2);
		max = Math.max(max,population);
		min = Math.min(min,population);
		population = area5(x,y,d1,d2);
		max = Math.max(max,population);
		min = Math.min(min,population);
		return max-min;
		
	}
	
	
	static int area1(int x, int y, int d1, int d2) {
		int sum = 0;
		for(int j = y-1; j >= 0; j--) {
			if(j >= y-d1 && j <= y-1) {
				for(int i = 0; i < x+ y-j; i++) {
					sum += map[j][i];
				}
			}
			else {
				for(int i = 0; i <= x+d1; i++) {
					sum += map[j][i];
				}
			}
		}
		return sum;
	}
	static int area2(int x, int y, int d1, int d2) {
		int sum = 0;
		for(int j = y-d1+d2; j >= 0; j--) {
			if(j <= y-d1+d2 && j >= y-d1) {
				for(int i = x+d1+1 + j-y+d1; i < N; i++) {
					sum += map[j][i];
				}
			}
			else {
				for(int i = x+d1+1; i < N; i++) {
					sum += map[j][i];
				}
			}
		}
		return sum;
	}
	static int area3(int x, int y, int d1, int d2) {
		int sum = 0;
		for(int j = N-1; j >= y; j--) {
			if(j <= y+d2 && j >= y) {
				for(int i = 0;  i < + x+d2-(y+d2-j); i++) {
					sum += map[j][i];
				}
			}
			else {
				for(int i = 0; i < x+d2; i++) {
					sum += map[j][i];
				}
			}
		}
		return sum;
	}
	static int area4(int x, int y, int d1, int d2) {
		int sum = 0;
		for(int j = N-1; j >= y-d1+d2+1; j--) {
			if(j <= y+d2 && j > y+d2-d1) {
				for(int i = x+d1+d2 -j+(y-d1+d2+1); i < N; i++) {
					sum += map[j][i];
				}
			}
			else {
				for(int i = x+d2; i < N; i++) {
					sum += map[j][i];
				}
			}
		}
		return sum;
	}
	
	static int area5(int x, int y, int d1, int d2) {
		int sum = 0;
		
		for(int j = y+d2; j > Math.max(y,y-d1+d2); j--) {
			int start = x-y+j;
			for(int i = start; i < start+1+2*(d2+y-j); i++) {
				sum += map[j][i];
			}
		}
		for(int j = Math.max(y,y-d1+d2); j >= Math.min(y,y-d1+d2); j--) {
			int start = x + y-j;
			if(d2> d1) start = x-y+j;
			for(int i = start; i < start+2*(Math.min(d2, d1))+1; i++) {
				sum += map[j][i];
			}
		}
		for(int j = Math.min(y,y-d1+d2)-1; j >= y-Math.max(d1, d2); j--) {
			int start = x + y-j;
			for(int i = start; i < start+2*(Math.min(d2, d1)-(Math.min(y,y-d1+d2)-j))+1; i++) {
				sum += map[j][i];
			}
		}
		return sum;
	}
}

