package bj_1780;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		int[] res = divide(map, N, 0, 0);
		for(int i : res) {
			sb.append(i+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int[] divide(int[][] map, int level, int x, int y) {
		if(level == 1) {
			int[] ret = new int[3];
			ret[map[y][x]]++;
			return ret;
		}
		int a = map[y][x];
		boolean flag = true;
		for(int j = 0; j < level; j++) {
			if(!flag) break;
			for(int i = 0; i < level; i++) {
				if(a != map[y+j][x+i]) {
					flag = false;
					break;
				}
			}
		}
		int[] ret = new int[3];
		if(!flag) {
			for(int j = 0; j < 3; j++) {
				for(int i = 0; i < 3; i++) {
					int nL = level/3;
					int[] res = divide(map, nL, x+nL*i, y+nL*j);
					for(int k = 0; k < 3; k++) {
						ret[k] += res[k];
					}
				}
			}
		}
		else {
			ret[a]++;
		}
		return ret;
	}

}
