package com.ssafy.hello;

import java.util.Scanner;

public class cubing {

	public static final int U = 0;
	public static final int D = 1;
	public static final int F = 2;
	public static final int B = 3;
	public static final int L = 4;
	public static final int R = 5;
	public static int [][][] sideOrder = {
			{{-1}, {-1}, {0,0}, {0,0}, {0,0},{0,0} }, // U
			{{-1}, {-1}, {0,2}, {0,2}, {0,2},{0,2} }, // D
			{{0, 2}, {0, 0}, {-1}, {-1}, {1,2},{1,0} }, // F
			{{0, 0}, {0, 2}, {-1}, {-1}, {1,0},{1,2} }, // B
			{{1, 0}, {1, 0}, {1 ,0}, {1,0}, {-1},{-1} }, // L
			{{1, 2}, {1, 2}, {1 ,2}, {1,2}, {-1},{-1} }, // R
	
	}; // 앞 뒤 위 아래 왼 오
	
	public static int [][][] turnOrder= {
			{
				{-1, -1, 4, 5, 3, 2},
				{-1, -1, 5, 4, 2, 3},
				{5, 4, -1, -1, 0, 1},
				{4, 5, -1, -1, 1, 0},
				{2, 3, 1, 0, -1, -1},
				{3, 2, 0, 1, -1, -1}
			},
			{
				{-1, -1, 5, 4, 2, 3},
				{-1, -1, 4, 5, 3, 2},
				{4, 5, -1, -1, 1, 0},
				{5, 4, -1, -1, 0, 1},
				{3, 2, 0, 1, -1, -1},
				{2, 3, 1, 0, -1, -1}
			}
	};
	
	
	public static char[][][] turnSide(int index, char direction, char[][][] cube) {
		char [][][] dummy = new char[6][3][3];
		for(int i=0;i<6;i++) {
			for(int j=0;j<3;j++) {
				//if(j == 0) dummy[i] = new char[3][3];
				for(int k=0;k<3;k++) {
					//if(k == 0) dummy[i][j] = new char[3];
					dummy[i][j][k] = cube[i][j][k];
				}
			}
		}
		int dir = direction=='+' ? 0: 1;
		int [][] order = sideOrder[index];
		// 노가다
		// U
		if(index == U) {
			if(dir == 0) {
				// 시계 방향
				// F -> L
				for(int i=0;i<3;i++) {
					dummy[L][0][i] = cube[F][0][i];
				}
				// L -> B
				for(int i=0;i<3;i++) {
					dummy[B][0][i] = cube[L][0][i];
				}
				// B -> R
				for(int i=0;i<3;i++) {
					dummy[R][0][i] = cube[B][0][i];
				}
				// R -> F
				for(int i=0;i<3;i++) {
					dummy[F][0][i] = cube[R][0][i];
				}
			}
			else {
				// F -> L
				for(int i=0;i<3;i++) {
					dummy[F][0][i] = cube[L][0][i];
				}
				// L -> B
				for(int i=0;i<3;i++) {
					dummy[L][0][i] = cube[B][0][i];
				}
				// B -> R
				for(int i=0;i<3;i++) {
					dummy[B][0][i] = cube[R][0][i];
				}
				// R -> F
				for(int i=0;i<3;i++) {
					dummy[R][0][i] = cube[F][0][i];
				}
			}
		}
		// D
		if(index == D) {
			if(dir == 0) {
				// 시계 방향
				// F -> L
				for(int i=0;i<3;i++) {
					dummy[R][2][i] = cube[F][2][i];
				}
				// L -> B
				for(int i=0;i<3;i++) {
					dummy[B][2][i] = cube[R][2][i];
				}
				// B -> R
				for(int i=0;i<3;i++) {
					dummy[L][2][i] = cube[B][2][i];
				}
				// R -> F
				for(int i=0;i<3;i++) {
					dummy[F][2][i] = cube[L][2][i];
				}
			}
			else {
				// F -> L
				for(int i=0;i<3;i++) {
					dummy[F][2][i] = cube[R][2][i];
				}
				// L -> B
				for(int i=0;i<3;i++) {
					dummy[R][2][i] = cube[B][2][i];
				}
				// B -> R
				for(int i=0;i<3;i++) {
					dummy[B][2][i] = cube[L][2][i];
				}
				// R -> F
				for(int i=0;i<3;i++) {
					dummy[L][2][i] = cube[F][2][i];
				}
			}
		}
		// F
		if(index == F) {
			if(dir == 0) {
				// 시계 방향
				// U -> R
				for(int i=0;i<3;i++) {
					dummy[R][i][0] = cube[U][2][i];
				}
				// R -> D
				for(int i=0;i<3;i++) {
					dummy[D][0][2-i] = cube[R][i][0];

				}
				// D -> L
				for(int i=0;i<3;i++) {
					dummy[L][i][2] = cube[D][0][i];
				}
				// L -> U
				for(int i=0;i<3;i++) {
					dummy[U][2][2-i] = cube[L][i][2];
				}
			}
			else {
				// U -> R
				for(int i=0;i<3;i++) {
					dummy[U][2][i] = cube[R][i][0];
				}
				// R -> D
				for(int i=0;i<3;i++) {
					dummy[R][i][0] = cube[D][0][2-i];
				}
				// D -> L
				for(int i=0;i<3;i++) {
					dummy[D][0][i] = cube[L][i][2];
				}
				// L -> U
				for(int i=0;i<3;i++) {
					dummy[L][2-i][2] = cube[U][2][i];
				}
			}
		}
		// B
		if(index == B) {
			if(dir == 1) {
				// 시계 방향
				// U -> R
				for(int i=0;i<3;i++) {
					dummy[R][i][2] = cube[U][0][i];
				}
				// R -> D
				for(int i=0;i<3;i++) {
					dummy[D][2][2-i] = cube[R][i][2];
				}
				// D -> L
				for(int i=0;i<3;i++) {
					dummy[L][i][0] = cube[D][2][i];
				}
				// L -> U
				for(int i=0;i<3;i++) {
					dummy[U][0][2-i] = cube[L][i][0];
				}
			}
			else {
				// U -> R
				for(int i=0;i<3;i++) {
					dummy[U][0][i] = cube[R][i][2];
				}
				// R -> D
				for(int i=0;i<3;i++) {
					dummy[R][2-i][2] = cube[D][2][i];
				}
				// D -> L
				for(int i=0;i<3;i++) {
					dummy[D][2][i] = cube[L][i][0];
				}
				// L -> U
				for(int i=0;i<3;i++) {
					dummy[L][2-i][0] = cube[U][0][i];
				}
			}
		}
		// L
		if(index == L) {
			if(dir == 0) {
				// 시계 방향
				// F -> D
				for(int i=0;i<3;i++) {
					dummy[D][i][0] = cube[F][i][0];
				}
				// D -> B
				for(int i=0;i<3;i++) {
					dummy[B][2-i][2] = cube[D][i][0];

				}
				// B -> U
				for(int i=0;i<3;i++) {
					dummy[U][2-i][0] = cube[B][i][2];
				}
				// U -> F
				for(int i=0;i<3;i++) {
					dummy[F][i][0] = cube[U][i][0];
				}
			}
			else {
				// F -> D
				for(int i=0;i<3;i++) {
					dummy[F][i][0] = cube[D][i][0];
				}
				// D -> B
				for(int i=0;i<3;i++) {
					dummy[D][2-i][0] = cube[B][i][2];

				}
				// B -> U
				for(int i=0;i<3;i++) {
					dummy[B][2-i][2] = cube[U][i][0];
				}
				// U -> F
				for(int i=0;i<3;i++) {
					dummy[U][i][0] = cube[F][i][0];
				}
			}
		}
		// R
		//
		if(index == R) {
			if(dir == 1) {
				// 시계 방향
				// F -> D
				for(int i=0;i<3;i++) {
					dummy[D][i][2] = cube[F][i][2];
				}
				// D -> B
				for(int i=0;i<3;i++) {
					dummy[B][2-i][0] = cube[D][i][2];

				}
				// B -> U
				for(int i=0;i<3;i++) {
					dummy[U][2-i][2] = cube[B][i][0];
				}
				// U -> F
				for(int i=0;i<3;i++) {
					dummy[F][i][2] = cube[U][i][2];
				}
			}
			else {
				// F -> D
				for(int i=0;i<3;i++) {
					dummy[F][i][2] = cube[D][i][2];
				}
				// D -> B
				for(int i=0;i<3;i++) {
					dummy[D][2-i][2] = cube[B][i][0];

				}
				// B -> U
				for(int i=0;i<3;i++) {
					dummy[B][2-i][0] = cube[U][i][2];
				}
				// U -> F
				for(int i=0;i<3;i++) {
					dummy[U][i][2] = cube[F][i][2];
				}
			}
		}
		
		return dummy;
		
	}

	
	public static void turnOneself(int index, char direction, char[][][] cube) {
		// 스스로 돌리기
		char [][] dummy = new char[3][3];
		if(direction == '+') {
			// 시계 방향
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					dummy[j][2-i] = cube[index][i][j];
				}
			}
		}
		else {
			// 반시계방향
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					dummy[2-j][i] = cube[index][i][j];
				}
			}
		}
		
		// 변경사항 반영
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[index][i][j] = dummy[i][j];
			}
		}
	}
	
	public static int getSideByChar(char c) {
		int value = 0;
		char [] values = {'U', 'D', 'F', 'B', 'L', 'R'};
		for(int i=0;i<6;i++) {
			if(c ==values[i]) {
				value = i;
				break;
			}
		}
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char [] colorOrder = {'w', 'y', 'r', 'o', 'g', 'b'};
		char [] values = {'U', 'D', 'F', 'B', 'L', 'R'};

		
		for(int tc=1;tc<= T;tc++) {
			// 초기화
			char [][][] cube = new char[6][3][3];
			
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					for(int k=0;k<3;k++) {
						cube[i][j][k] = colorOrder[i];
					}
				}
			}
			
			int n = sc.nextInt();
			for(int turn=0;turn<n;turn++) {
				String command = sc.next();
				int side = getSideByChar(command.charAt(0));
				char direction = command.charAt(1);
				
				// 스스로 돌리기
				turnOneself(side, direction, cube);
				
				// 사이드 부분 돌리기
				cube = turnSide(side, direction, cube);
			
			}
			
			// 윗면 색상 출력하기
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}
			
		}
	}

}
