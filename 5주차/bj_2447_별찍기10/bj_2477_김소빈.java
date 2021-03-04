package bj_silver;

import java.util.Scanner;

public class Main_bj_2477_별찍기10 {
	static StringBuilder sb;
	static char[][] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new char[n][n];
		makeStar(0, 0, n);
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == '*') sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}
	private static void makeStar(int x, int y, int n) {
		if(n == 1) {
			a[x][y] = '*';
			return;
		}
		n = n/3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				makeStar(x+n*i, y+n*j, n);
			}
		}
	}
}
