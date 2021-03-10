package BJ;

import java.io.*;

public class bj_2447_S1 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < N; ++y) {
				Draw(x, y);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void Draw(int x, int y) {
		while (y > 0) {
			if (x % 3 == 1 && y % 3 == 1) {
				sb.append(" ");
				return;
			}
			x /= 3;
			y /= 3;
		}
		sb.append("*");
	}
}
