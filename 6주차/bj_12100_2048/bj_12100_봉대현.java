package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://jellyinghead.tistory.com/53 참고
public class Main_bj_12100_2048_봉대현 {

	static int maxn, n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(in.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = stoi(st.nextToken());
		}
		
		dfs(0);// 이동 횟수, 블록, 방향
		System.out.println(maxn);
		in.close();
	}

	static void dfs(int cnt) {
		if (cnt == 5) {// 최대 5번 이동

			// 가장 큰 블록찾기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					maxn = Math.max(maxn, map[i][j]);
				}
			}
			return;
		}
		int copy[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				copy[i][j] = map[i][j];

		for (int i = 0; i < 4; i++) {
			moveblock(i);
			dfs(cnt + 1);
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					map[j][k] = copy[j][k];
		}
	}

	static void moveblock(int d) {
		
		
		if (d == 0)// 오른쪽
		{
			for (int i = 0; i < n; i++) {
				// 숫자 저장
				int block=0;
				int index=n-1;
				// 오른쪽부터 넣기
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						//다음 블록과 값이 같다면 2배
						if(block==map[i][j]) {
							map[i][index+1]=block*2;
							
							block=0;
							map[i][j]=0;
						}
						else {
							block=map[i][j];
							map[i][j]=0;
							map[i][index--]=block;
						}
					}
				}
				
			}
		} else if (d == 1) {// 왼쪽
			for (int i = 0; i < n; i++) {
				// 숫자 저장
				int block=0;
				int index=0;
				// 왼쪽
				for (int j = 0; j <n; j++) {
					if (map[i][j] != 0) {
						//다음 블록과 값이 같다면 2배
						if(block==map[i][j]) {
							map[i][index-1]=block*2;
							block=0;
							map[i][j]=0;
						}
						else {
							block=map[i][j];
							map[i][j]=0;
							map[i][index++]=block;
						}
					}
				}
				
			}
		} else if (d == 2) {// 위쪽
			for (int i = 0; i < n; i++) {
				int block=0;
				int index=0;
				for (int j =0 ; j <n; j++) {
					if (map[j][i] != 0) {
						//다음 블록과 값이 같다면 2배
						if(block==map[j][i]) {
							map[index-1][i]=block*2;
							block=0;
							map[j][i]=0;
						}
						else {
							block=map[j][i];
							map[j][i]=0;
							map[index++][i]=block;
						}
					}
				}
			}
		} else {// 아래쪽
			for (int i = 0; i < n; i++) {
				// 숫자 저장
				int block=0;
				int index=n-1;
				// 아래부터 넣기
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						//다음 블록과 값이 같다면 2배
						if(block==map[j][i]) {
							map[index+1][i]=block*2;
							block=0;
							map[j][i]=0;
						}
						else {
							block=map[j][i];
							map[j][i]=0;
							map[index--][i]=block;
						}
					}
				}
				
			}
		}
		
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
