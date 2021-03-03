package baekjoon_02001_03000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//[실버 1] 별 찍기 - 10
//https://www.acmicpc.net/problem/2447
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2447_별찍기10_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_2447"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//핵심 아이디어
		//공간을 별로 꽉 채운다음에
		//재귀적으로 들어가면서 비우기
		
		//3의 거듭제곱 N 1~3^8 (6500쯤)
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		//*로 가득 채우기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = '*';
			}
		}
		
		//재귀 함수
		delete(map, map.length, 0, 0);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void delete(char[][] map, int length, int startX, int startY) {
		//종료 조건
		if(length == 1) return;
		
		//공백 찍기
		length /= 3;
		for (int i = startX+length; i < startX+length*2; i++) {
			for (int j = startY+length; j < startY+length*2; j++) {
				map[i][j]= ' ';
			}
		}
		
		//재귀적으로 돌리기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				delete(map, length, startX+length*i, startY+length*j);
			}
		}
		
	}
}
