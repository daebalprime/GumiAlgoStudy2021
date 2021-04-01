package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_4386_별자리만들기_구미_4_이동현 {
	static int N;
	static double result;
	static double[] dist;
	static double[][] map;
	static double[][] input;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new double[N][N];
		input = new double[N][2];
		dist = new double[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = stod(st.nextToken());
			input[i][1] = stod(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i == j) map[i][j] = 0;
				map[i][j] = Math.round(getDistance(input[i][0],input[i][1],input[j][0],input[j][1]) * 100)/100.0;
				map[j][i] = map[i][j];
			}
		}
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[0] = 0;
		
		for (int i = 0; i < N; i++) {
			double min = Integer.MAX_VALUE;
			int minIdx = 0;
			
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					minIdx = j;
				}
			}
			visited[minIdx] = true;
			result += min;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && map[minIdx][j] != 0&& dist[j] > map[minIdx][j]) {
					dist[j] = map[minIdx][j];
					
				}
			}
		}
		System.out.println(result);
	}
	static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static double stod(String s) {
		return Double.parseDouble(s);
	}

}
