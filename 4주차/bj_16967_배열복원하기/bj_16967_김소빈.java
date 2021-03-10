package bj_silver;

import java.io.*;
import java.util.*;

public class Main_bj_16967_배열복원하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int [][] ans = new int[H+X][W+Y];
		int tmp;
		
		for(int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < W+Y; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp == 0) continue;
				else if(X<=i&&i<H && Y<=j&&j<W) {
					ans[i][j] = tmp-ans[i-X][j-Y];
				}
				else if(X<=i&&i<H+X && Y<=j&&j<W+Y) continue;
				else ans[i][j] = tmp;
			}
		}
		StringBuilder sb= new StringBuilder();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
