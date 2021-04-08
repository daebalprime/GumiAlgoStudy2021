package bj_gold;

import java.io.*;
import java.util.*;
public class Main_bj_17070_파이프옮기기1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] check = new int[n][n][3];
		check[0][1][0] = 1;
		for(int i = 2; i < n; i++) {
			if(arr[0][i] == 0) {
				check[0][i][0] = check[0][i-1][0];
			}
		}
		//0 오른쪽 1 대각선 2 아래
		for(int i = 1; i < n; i++) {
			for(int j = 2; j < n; j++) {
				if(arr[i-1][j] == 0 && arr[i][j-1] == 0 && arr[i][j] == 0) {
					check[i][j][1] = check[i-1][j-1][0]+check[i-1][j-1][1]+check[i-1][j-1][2];
				}
				if(arr[i][j] == 0) {
					check[i][j][0] = check[i][j-1][0]+check[i][j-1][1];
					check[i][j][2] = check[i-1][j][1]+check[i-1][j][2];
				}
			}
		}
		
		System.out.println(check[n-1][n-1][0]+check[n-1][n-1][1]+check[n-1][n-1][2]);
		
	}
}
