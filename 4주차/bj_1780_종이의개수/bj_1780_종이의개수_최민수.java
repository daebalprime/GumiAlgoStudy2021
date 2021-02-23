package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[실버 2] 종이의 개수
//https://www.acmicpc.net/problem/1780
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1780_종이의개수_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1780"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//N: 1~3^7
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer	st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		divide(paper, 0, 0, N);
		
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
		
		
		
		br.close();
	}
	static int minusOne = 0, zero = 0, plusOne = 0;

	private static void divide(int[][] paper, int startX, int startY, int length) {
		for (int i = startX; i < startX + length; i++) {
			for (int j = startY; j < startY + length; j++) {
				if (paper[i][j] != paper[startX][startY]) {
					// divide 9개
					int smL = length / 3;
					divide(paper, startX, startY, smL); // 좌상
					divide(paper, startX, startY + smL, smL); // 상
					divide(paper, startX, startY + smL * 2, smL); // 우상
					divide(paper, startX + smL, startY, smL); // 좌중
					divide(paper, startX + smL, startY + smL, smL); // 중중
					divide(paper, startX + smL, startY + smL * 2, smL); // 우중
					divide(paper, startX + smL * 2, startY, smL); // 좌하
					divide(paper, startX + smL * 2, startY + smL, smL); // 중하
					divide(paper, startX + smL * 2, startY + smL * 2, smL); // 우하
					return;
				}
			}
		}

		if (paper[startX][startY] == -1) minusOne++;
		else if (paper[startX][startY] == 0) zero++;
		else plusOne++;
		return;
	}
}
