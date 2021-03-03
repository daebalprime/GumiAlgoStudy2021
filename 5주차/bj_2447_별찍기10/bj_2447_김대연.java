package bj_2447;

import java.util.Scanner;
import java.io.*;

public class Main {
	static final int size = (int)Math.pow(3, 7);
	static boolean[][] plane = new boolean[size][size];
	
	static void mark(int s, int x, int y) {
		if(s == 1) {
			plane[x][y] = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				mark(s/3, x+(s/3)*i, y+(s/3)*j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		mark(T,0,0);
		for (int i = 0; i < T; i++) {
			for(int j = 0; j < T; j++) {
				if(plane[i][j] == true) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
