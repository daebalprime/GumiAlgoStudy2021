package bj_3190;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0}; // URDL

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int A = Integer.parseInt(br.readLine());
		for(int i = 0; i < A; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = -1;
		}
		int T = Integer.parseInt(br.readLine());
		int[][] drift = new int[T][2]; 
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			drift[i][0] = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			if(d.equals("D")) {
				drift[i][1] = 1;
			}else {
				drift[i][1] = -1;
			}
		}
		int ori = 1;
		int x = 0, y = 0;
		int tx = 0, ty = 0;
		int time = 0;
		map[0][0] = ori+1;
		int cmditr = 0;
		while(true) {
//			for(int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
//			System.out.println();
//			System.out.println(x+" "+y);
//			System.out.println(tx+" "+ty);
			int nx = x+di[ori];
			int ny = y+dj[ori];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx] > 0) { 
				time++;
				// crashed into wall
				// hit its body
				break;
			}
			
			if(map[ny][nx] == 0) {
				int tori = map[ty][tx];
				map[ty][tx] = 0;
				tx += di[tori-1];
				ty += dj[tori-1];
			}
			if(drift[cmditr][0] == time+1) {
				ori = (ori+4+drift[cmditr][1])%4;
				if(cmditr < T-1) {
					cmditr++;
				}
			}
			map[ny][nx] = ori+1;
			
			x= nx;
			y = ny;
			
			
		
			time++;
		}
		System.out.println(time);
	}

}
