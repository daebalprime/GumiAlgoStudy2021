import java.io.*;
import java.util.*;

public class bj_17070_G5 {

	static final int garo = 0;							// 가로 타입
	static final int sero = 1;							// 세로 타입
	static final int daegak = 2;						// 대각선 타입
	static int N, arr[][], cnt =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(garo, 0, 1);								// 첫 파이프는 가로
		System.out.println(cnt);						// 카운트 출력
	}
	
	static void dfs(int type, int x, int y) {
		if (x == N - 1 && y == N - 1) { 				// 기저조건
			cnt++;										// 도착 시 카운팅
			return;
		}

		switch (type) {
		case garo:
			// 가로
			if (isAvailable(x, y + 1) && isMapZero(x, y + 1))
				dfs(garo, x, y + 1);
			// 대각선
			if (isAvailable(x + 1, y + 1) && isMapZero(x, y + 1) 
				   && isMapZero(x + 1, y) && isMapZero(x + 1, y + 1))
				dfs(daegak, x + 1, y + 1);
			break;
		case sero:
			// 세로
			if (isAvailable(x + 1, y) && isMapZero(x + 1, y))
				dfs(sero, x + 1, y);
			// 대각선
			if (isAvailable(x + 1, y + 1) && isMapZero(x, y + 1) 
				   && isMapZero(x + 1, y) && isMapZero(x + 1, y + 1))
				dfs(daegak, x + 1, y + 1);
			break;
		case daegak:
			// 가로
			if (isAvailable(x, y + 1) && isMapZero(x, y + 1))
				dfs(garo, x, y + 1);
			// 세로
			if (isAvailable(x + 1, y) && isMapZero(x + 1, y))
				dfs(sero, x + 1, y);
			// 대각선
			if (isAvailable(x + 1, y + 1) && isMapZero(x, y + 1) 
			       && isMapZero(x + 1, y) && isMapZero(x + 1, y + 1))
				dfs(daegak, x + 1, y + 1);
			break;
		}
	}

	static boolean isMapZero(int x, int y) {			// 맵의 값이 0인지 반환
		return arr[x][y] == 0;
	}
	
	static boolean isAvailable(int x, int y) {			// 깔 수 있는지 반환
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
