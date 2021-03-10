package BJ;

import java.util.*;
import java.io.*;

public class bj_1780 {
	static int[][] paper;									// 색종이 배열
	static int[] cnt = new int[3]; 							// 개수 배열 0,1,2(=-1)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Int(br.readLine());
		paper = new int[n][n];								// 색종이 배열 
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {					// 입력
				paper[i][j] = Int(st.nextToken());
			}
		}
		divide(n, 0, 0);									// 분할 시작
		
		System.out.println(cnt[2]);							// -1 개수
		System.out.println(cnt[0]);							// 0 개수
		System.out.println(cnt[1]);							// 1 개수
	}

	static void divide(int n, int x, int y) {
		if (isAvailable(n, x, y)) {							// 가능하다면 카운팅
			int tmp = paper[x][y];
			if(tmp == -1) tmp = 2;							// 인덱스는 양수라서 조정해줌
			cnt[tmp]++;										// 카운팅
		} else {
			int div = n / 3;
			divide(div, x, 					y); 			// 0,0
			divide(div, x + div, 			y); 			// div*1,0
			divide(div, x + (div * 2), 		y); 			// div*2,0

			divide(div, x, 					y + div); 		// 0,0
			divide(div, x + div, 			y + div); 		// div*1,0
			divide(div, x + (div * 2), 		y + div); 		// div*2,0

			divide(div, x, 					y + (div * 2)); // 0,0
			divide(div, x + div, 			y + (div * 2)); // div*1,0
			divide(div, x + (div * 2),		y + (div * 2)); // div*2,0
		}
	}

	static boolean isAvailable(int n, int x, int y) {
		int tmp = paper[x][y];								// 값 비교용 
		for (int i = x; i < x + n; ++i) 
			for (int j = y; j < y + n; ++j) 
				if (tmp != paper[i][j]) return false;		// 하나라도 다르면 false
		return true;
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
