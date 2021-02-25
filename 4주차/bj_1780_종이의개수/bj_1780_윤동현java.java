import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_1780_종이의개수 {

	static int[][] paper;
	static int N,negative,zero,postive;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		negative = zero = postive = 0;
		divide(N, 0, 0);
		System.out.println(negative);
		System.out.println(zero);
		System.out.println(postive);
		br.close();
	}

	static void divide(int n, int x, int y) {
		if(n == 1) {
			paperCnt(x, y);
			return;
		}
		if(isCheck(n,x,y)) {
			paperCnt(x, y);
			return;
		} else {
			//9등분 하기
			//1 2 3
			//4 5 6
			//7 8 9
			int half = n/3;
			divide(half, x, y); //1
			divide(half, x, y+half); //2
			divide(half, x, y+2*half); //3
			divide(half, x+half, y); //4
			divide(half, x+half, y+half); //5
			divide(half, x+half, y+2*half); //6
			divide(half, x+2*half, y); //7
			divide(half, x+2*half, y+half); //8
			divide(half, x+2*half, y+2*half); //9
		}
	}

	static boolean isCheck(int n, int x, int y) {
		int temp = paper[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(paper[i][j] != temp) return false;
			}
		}
		return true;
	}

	static void paperCnt(int x, int y) {
		if(paper[x][y] == -1) negative++;
		else if(paper[x][y] == 1) postive++;
		else zero++;
	}
}