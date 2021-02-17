package BJ;

import java.io.*;
import java.util.*;

public class bj_1012 {
	static int[] di = new int[] { -1, 1, 0, 0 };	// 행라인 배열
	static int[] dj = new int[] { 0, 0, -1, 1 };	// 열라인 배열
	static int[][] grounds;							// 배추밭 배열
	static int M, N;								// 배추밭 가로, 세로
	static int cnt;									// 인접 배추 그룹 개수 
	static boolean isCnt = false;					// 한번만 카운팅(그룹이니까)위한 플래그
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Int(br.readLine());					// 테케를 입력받는다.
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Int(st.nextToken());				// 행
			N = Int(st.nextToken());				// 열
			int K = Int(st.nextToken());			// 배추 개수
			grounds = new int[M][N];				// 배추밭 배열 할당
			cnt = 0;								// 카운트 초기화
			for (int i = 0; i < K; ++i) {			// 배추밭 입력
				st = new StringTokenizer(br.readLine(), " ");
				grounds[Int(st.nextToken())][Int(st.nextToken())] = 1;
			}
			for (int i = 0; i < M; ++i) {
				for (int j = 0; j < N; ++j) {
					isCnt = true;					// 카운트 초기화
					search(i,j);					// 탐색
				}
			}
			System.out.println(cnt);				// 출력
		}
	}

	static void search(int i, int j) {
		if(grounds[i][j] != 1) return;				// 이미 방문했으면 리턴
		else if (grounds[i][j] == 1) {				// 배추가 심어져있으면 입장
			if(isCnt) {								// 첫카운팅이면
				cnt++;								// 카운팅
				isCnt = false;						// 카운트 플래그 off
			}
			grounds[i][j] = -1;						// 방문 처리
			for (int d = 0; d < 4; ++d) {			// 4방향 탐색 시작
				int ni = i + di[d];					// 이동할 행 방향
				int nj = j + dj[d];					// 이동할 열 방향
													// 범위 내 && 이동 위치가 배추면 
				if (isBoundary(ni, nj) && grounds[ni][nj] == 1) {
					search(ni,nj);					// 재탐색 
				}
			}
		}
	}

	static boolean isBoundary(int i, int j) {		// 범위 내에 있는지 검사
		if (0 <= i && i < M && 0 <= j && j < N)
			return true;
		return false;
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
