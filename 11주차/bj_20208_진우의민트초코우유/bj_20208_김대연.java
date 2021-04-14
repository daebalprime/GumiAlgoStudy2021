package bj_20208;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] mintChoco = new int[11][2];
	static int[] house = new int[2];
	static int N,M,H, answer, Z;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		Z = 0; // MintChoco Count
		answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int T = Integer.parseInt(st.nextToken());
				if(T == 2) {
					mintChoco[Z][0] = j;
					mintChoco[Z++][1] = i;
				}
				else if(T == 1) {
					house[0] = j;
					house[1] = i;
				}
			}
		}
		mintChoco[Z][0] = house[0];
		mintChoco[Z++][1] = house[1];
		visited = new boolean[Z];
		recur(0,house[0], house[1], M);
		br.close();
		System.out.println(answer);
	}
	
	static void recur(int cnt, int x, int y, int energy) {
		if(cnt != 0 && x == house[0] && y == house[1]) {
			answer = Math.max(cnt-1, answer);
			return;
		}
		for(int i = 0; i < Z; i++) {
			if(!visited[i] && distance(x,y,mintChoco[i]) <= energy) {
				visited[i] = true;
				recur(cnt+1, mintChoco[i][0], mintChoco[i][1], energy+H-distance(x,y,mintChoco[i]));
				visited[i] = false;
			}
		}
	}
	
	static int distance(int x, int y, int[] z) {
		return Math.abs(x-z[0]) + Math.abs(y-z[1]);
	}

}
