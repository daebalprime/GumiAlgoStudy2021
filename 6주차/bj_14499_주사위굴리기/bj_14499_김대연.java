package bj_14499;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = new int[] {1,-1,0,0};
	static int[] dj = new int[] {0,0,-1,1};
	public static void main(String[] args) throws Exception{
//		int[] dice1 = new int[] {0,1,2,3,4,5};
//		int[] dice2 = new int[] {0,1,2,3,4,5};
//		for(int i = 0; i < 4; i++) {
//			rearrange(dice1, 2);
//			System.out.println(Arrays.toString(dice1));
//			System.out.println(Arrays.toString(dice2));
//			System.out.println();
//		}
//		System.exit(0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] dice = new int[6];
		/*
		 * 0 = up
		 * 1 = back
		 * 2 = right
		 * 3 = left
		 * 4 = front
		 * 5 = down
		 * */
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int x = X;
		int y = Y;
		for(int k = 0; k < K; k++) {
			int ori = Integer.parseInt(st.nextToken())-1;
			/*
			 * east = 0 west = 1 north = 2 south = 3
			 * */
			int nx = x + di[ori];
			int ny = y + dj[ori];
		
//			System.out.println(nx + " " + ny);
			if(nx < 0 || nx >= M || ny < 0 || ny >=N) continue;
			rearrange(dice,ori);
			int next = map[ny][nx];
			if(next == 0) map[ny][nx] = getBottom(dice);
			else {
				setBottom(dice, next);
				map[ny][nx] = 0;
			}
			sb.append(getTop(dice)+"\n");
			x = nx;
			y = ny;
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void rearrange(int[] s, int ori) {
		if(ori == 0) {
			int tmp = s[0];
			s[0] = s[3];
			s[3] = s[5];
			s[5] = s[2];
			s[2] = tmp;
		}
		else if(ori == 1) {
			int tmp = s[0];
			s[0] = s[2];
			s[2] = s[5];
			s[5] = s[3];
			s[3] = tmp;
		}else if(ori == 2) { //0->1->5->4->0
			int tmp = s[0];
			s[0] = s[4];
			s[4] = s[5];
			s[5] = s[1];
			s[1] = tmp;
		}else {
			int tmp = s[0];
			s[0] = s[1];
			s[1] = s[5];
			s[5] = s[4];
			s[4] = tmp;
		}
	}
	
	static int getBottom(int[] s) {
		return s[5];
	}
	static int getTop(int[] s) {
		return s[0];
	}
	static void setBottom(int[] s, int x) {
		s[5] = x;
	}
}
