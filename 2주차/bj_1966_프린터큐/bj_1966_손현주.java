package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bj_1966_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Queue를 만든다
		LinkedList<int[]> q = new LinkedList<>();
		// 1. 테스트 케이스의 수가 주어진다.
		int T = Integer.parseInt(br.readLine());
		int cnt, N, M, imp;
		// 2. 테케 만큼 반복한다.
		for (int tc = 1; tc <= T; ++tc) {
			cnt = 0;
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);// 문서개수를 입력받는다.
			M = Integer.parseInt(tmp[1]);// 찾으려는 문서의 위치
			String[] tmp2 = br.readLine().split(" ");// 문서값을 입력받는다.
			if (N == 1) {
				cnt++;
			} else {
				for (int i = 0; i < N; ++i) {// 문서 개수만큼 입력받는다.
					imp = Integer.parseInt(tmp2[i]);
					q.offer(new int[] { i, imp });// 입력받는순서대로
				}
				// 3. 검사
				while (true) {
					boolean canPrint = true;
					// 인쇄 가능한지 검색(하나라도 큰게있으면 불가능)
					for (int i = 1; i < q.size(); ++i) {
						if (q.peek()[1] < q.get(i)[1]) {
							canPrint = false;
							break;
						}
					}
					// 뒤로 넣을지 말지 검사
					if(canPrint) {
						cnt++;
						if(M==q.peek()[0]) break; //찾는거면 그만
						q.poll();
						
					}else { // 출력불가면 뒤로 넣기
						q.add(q.peek());
						q.poll();
					}
				}
			}
			// 4. 출력
			System.out.println(cnt);
			q.clear();
		}
	}
}
