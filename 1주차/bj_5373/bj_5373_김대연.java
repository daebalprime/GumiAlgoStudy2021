package bj_5373;
import java.util.Scanner;


/*            50 51 52
 *            53 54 55
 *            56 57 58
 *          ------------
 * 10 11 12 | 00 01 02 | 20 21 22 | 30 31 32
 * 13 14 15 | 03 04 05 | 23 24 25 | 33 34 35
 * 16 17 18 | 06 07 08 | 26 27 28 | 36 37 38
 *          ------------
 *            40 41 42
 *            43 44 45
 *            46 47 48
 * zbqld tlqkf 
 * */

public class Main {
	// counter-clockwise.
	public static int[][] rotate = 
	{{12,15,18,40,41,42,26,23,20,58,57,56},
	{ 6, 3, 0,56,53,50,32,35,38,46,43,40},
	{ 2, 5, 8,42,45,48,36,33,30,52,55,58},
	{22,25,28,48,47,46,16,13,10,50,51,52},
	{ 8, 7, 6,18,17,16,38,37,36,28,27,26},
	{ 0, 1, 2,20,21,22,30,31,32,10,11,12}};
	
	public static void main(String[] args) {
		int[] emptyArr = new int[12];
		char[] emptyCharArr = new char[12];
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			char[][][] cube = new char[6][3][3];
			// 0-> up 3-> down 
			// 1-> left 2-> right
			// 4-> front 5-> back
			// initialize end
			for(int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						char color = '.';
						switch (i) {
						case 0:	
							color = 'w';
							break;
						case 1:
							color = 'g';
							break;
						case 2:	
							color = 'b';
							break;
						case 3:	
							color = 'y';
							break;
						case 4:	
							color = 'r';
							break;
						case 5:	
							color = 'o';
							break;
						}
						cube[i][j][k] = color;
					}
				}
			}
			// initialize end
			// parsing actions
			int action = sc.nextInt();
			int side = 0;
			int rotation = 0;
			for (int z = 0; z < action; z++) {
				String tokens = sc.next();
				switch (tokens.charAt(0)) {
				case 'U':
					side = 0; 
					break;
				case 'L':
					side = 1; 
					break;
				case 'R':
					side = 2; 
					break;
				case 'D':
					side = 3; 
					break;
				case 'F':
					side = 4; 
					break;
				case 'B':
					side = 5; 
					break;
				}
				switch (tokens.charAt(1)) {
				case '-':
					rotation = -1;
					break;
				case '+':
					rotation = 1;
					break;
				}
				// parsing actions end
				// rotate face
				int r1 = rotation == 1 ? 2 : 0;
				char[][] newSide = new char[3][3]; 

				for (int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						newSide[(2-r1)+rotation*j][r1-(rotation*i)] = 
								cube[side][i][j];
					}
				}
				cube[side] = newSide;			
				// rotate face end
				// rotate side start
				for(int i = 3; i < 15; i++) {
					emptyArr[(i+(-3*rotation))%12] = rotate[side][i%12];
				}
				for(int i = 0; i < 12; i++) {
					int src = emptyArr[i];
					emptyCharArr[i] = cube[src/10][(src%10)/3][(src%10)%3];
				}

				for(int i = 0; i < 12; i++) {
					int target = rotate[side][i];
					cube[target/10][target%10/3][target%10%3] = 
							emptyCharArr[i];
				}
			}
			for (char[] t1 : cube[0]) {
				for(char c : t1)System.out.print(c);
				System.out.println();
			}
		}
	}
}