package bj_1012;

import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int M;
	static int N;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	
	static void dfs(int x, int y) {
		if(map[y][x]==false)
			return;
		map[y][x] = false;
		for(int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split(" ");
			M = Integer.parseInt(tmp[0]);
			N = Integer.parseInt(tmp[1]);
			int K = Integer.parseInt(tmp[2]);
			int answer = 0;
			map = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				String[] coord = br.readLine().split(" ");
				map[Integer.parseInt(coord[1])][Integer.parseInt(coord[0])] = true;
			}
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[j][i] == true) {
						answer++;
						dfs(i,j);
					}
				}
			}
			System.out.println(answer);
		}
	}

}
