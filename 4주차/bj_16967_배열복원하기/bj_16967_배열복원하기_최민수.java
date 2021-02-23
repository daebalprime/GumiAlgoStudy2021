package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//[실버 3] 배열 복원하기
//https://www.acmicpc.net/problem/16967
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16967_배열복원하기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16967"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//정수 H, W, X, Y
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		//변경된 배열
		int afterMap[][] = new int[H+X][W+Y];
		//변경전 배열, 정답
		int beforeMap[][] = new int[H][W];
		for (int i = 0; i < H+X; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W+Y; j++) {
				afterMap[i][j] = Integer.parseInt(st2.nextToken());
				if(i<H && j<W) beforeMap[i][j] = afterMap[i][j];
			}
		}
		
		//바뀐 지점인 X, Y부터 시작한다.
		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				beforeMap[i][j] = afterMap[i][j] - beforeMap[i-X][j-Y];
			}
		}

		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(beforeMap[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}
}
