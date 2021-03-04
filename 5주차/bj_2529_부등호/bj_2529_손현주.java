package BJ;

import java.io.*;
import java.util.*;

public class bj_2529_S2 {
	static boolean[] isSelect = new boolean[10];						// 방문체크배열
	static int N;														// 부호 개수
	static String[] sign;												// 부호 배열
	static ArrayList<String> output = new ArrayList<String>();			// 결과 저장 리스트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sign = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) sign[i] = st.nextToken();			// 부호 입력

		for (int i = 0; i < 10; ++i) {
			Arrays.fill(isSelect, false);								// false로 다시 돌려준다.
			isSelect[i] = true;											// 방문체크
			search(i, 0, 0, i + "");									// 탐색 시작
		}
		System.out.println(output.get(output.size() - 1));				// 최대 값
		System.out.println(output.get(0));								// 최소 값
	}

	static void search(int start, int signIndex, int cnt, String str) {
		if (cnt == N) output.add(str);									// 카운팅확인되면 리스트에 추가
		else {
			for (int i = 0; i < 10; ++i) {
				if (isSelect[i]) continue;								// 방문시 continue;
				if (sign[signIndex].equals("<") && start > i) continue;	// 넣으려는거보다 기존거가 크면 X
				if (sign[signIndex].equals(">") && start < i) continue; // 넣으려는거보다 기존거 작으면 X
				isSelect[i] = true;										// 방문 체크
				search(i, signIndex + 1, cnt + 1, str + i);				// 다시 탐색
				isSelect[i] = false;									// 방문 체크 해제
			}
		}
	}
}
