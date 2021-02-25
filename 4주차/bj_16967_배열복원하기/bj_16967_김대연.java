package bj_16967;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); 
		int W = Integer.parseInt(st.nextToken()); 
		int Y = Integer.parseInt(st.nextToken()); 
		int X = Integer.parseInt(st.nextToken()); 
//		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[H][W]; 
		
		
		for(int j = 0; j < H; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < W; i++) { 
				int tmp = Integer.parseInt(st.nextToken());
				if(i >= X && j >= Y) tmp -= map[j-Y][i-X];
//				System.out.print(tmp +" ");
				
				map[j][i] = tmp;
			}
//			System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < H; j++) {
			for(int i = 0; i < W; i++) {
				sb.append(map[j][i]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
