import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		printStar(0, 0, N, false);
		StringBuilder sb = new StringBuilder();
		for (char[] ch : star) {
			for(char c : ch) sb.append(c);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void printStar(int x, int y, int N, boolean blank) {
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}

		if(N == 1) {
			star[x][y] = '*';
			return;
		}

		int divideThree = N/3;
		int blankCnt = 0;
		for(int i=x; i<x+N; i+=divideThree) {
			for(int j=y; j<y+N; j+=divideThree) {
				if(blankCnt == 4) {
					printStar(i, j, divideThree, true);
				} else {
					printStar(i, j, divideThree, false);
				}
				blankCnt++;
			}
		}
	}
}//end class