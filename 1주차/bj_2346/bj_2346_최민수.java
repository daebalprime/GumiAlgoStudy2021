package baekjoon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

//[실버 3] 풍선 터뜨리기
//https://www.acmicpc.net/problem/2346
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_2346_최민수 {
	public static int[][] remove(int[][] arr, int index) {
		int[][] temp = arr;
		for (int i = index; i < temp.length - 1; i++) {
			temp[i] = temp[i + 1];
		}
		temp[temp.length - 1] = null;

		return temp;
	}

	public static int mod(int a, int b) {
		if (a >= 0)
			return a % b;
		while (a < 0) {
			a += b;
//			System.out.println("왜");
		}

		return a;
	}

	public static void main(String[] args) throws Exception {
		// 테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_2346_input"));
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[][] balloon = new int[N][2];
		for (int i = 0; i < N; i++) {
			// 이동값
			balloon[i][0] = scan.nextInt();
			// 삭제된 곳인지 check
			balloon[i][1] = 0;
		}

		// 풍선N개 터뜨리기
		//다음 풍선 수
		int balls = balloon.length - 1;
		int pos_now = 0;
		// 몇칸 움직일껀지
		int pos_mov = 0;
		while (balls > 0) {
			System.out.println(pos_now + 1);
			
			if(N == 1) break;
			// pow_now는 터졌다.
			balloon[pos_now][1] = 1;

			pos_mov = balloon[pos_now][0];

			if (pos_mov >= 0) {
				while (pos_mov != 0) {
					// 현재 위치 풍선이 안터졌다면
					if (balloon[pos_now][1] == 0) {
						// 이동횟수를 1 빼고
						pos_mov--;
						if (pos_mov == 0) break;
					}
					// 현재 위치가 배열 범위 밖으로 가는지 확인한 다음
					if (pos_now + 1 > balls) {
						pos_now = 0;
					} else {
						// 한 칸 이동한다.
						pos_now++;
					}

				}
			} else if (pos_mov < 0) {
				while (pos_mov != 0) {
					// 현재 위치 풍선이 안터졌다면
					if (balloon[pos_now][1] == 0) {
						// 이동횟수를 1 빼고 (음수라 더함)
						pos_mov++;
						if (pos_mov == 0)
							break;
					}
					// 현재 위치가 배열 범위 밖으로 가는지 확인한 다음
					if (pos_now - 1 < 0) {
						pos_now = balls;
					} else {
						// 한 칸 이동한다.
						pos_now--;
					}

				}
			}
			N--;
		}
		scan.close();
	}
}
