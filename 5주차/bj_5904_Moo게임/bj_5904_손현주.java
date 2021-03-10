package BJ;

import java.io.*;

/*
 * [ 아이디어 ] 
 * 1. 처음에는 재귀로 S(1) = moo 부터 만들어 나가면서 타겟을 찾았지만 메모리초과.
 * 2. 3개의 파트로 나눈다는 아이디어를 찾았음.
 * 3. 이분탐색을 활용하여 파트를 나누었고, 나누어서 재탐색 혹은 리턴함.
 * 4. 예를 들어서, S[index]
 * 				S[3] = S[2] + index + 2 + S[2]; = 10 + 3 + 2 + 10
 *              S[2] = S[1] + index + 2 + S[1]; = 3 + 2 + 2 + 3
 *              S[1] = S[0] + index + 2 + S[0]; = 0 + 1 + 2 + 0
 * 5. 파티션 A | 파티션 B | 파티션 C 라고 가정하면 
 *    1) A,C는 더 잘개 쪼개서 다시 재탐색한다.
 *    2) 파티션 B에 해당하면 맨 앞글자가 m인지 검색한다.
 */
public class bj_5904_S1 {
	static int[] mooLength = new int[100]; 										// moo길이 저장 배열
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int index = 0;
		while (N > mooLength[index]) 											// N이 몇번째 인덱스에 있는지 
			mooLength[++index] = 2 * mooLength[index-1] + (index + 2);			// 길이도넣어준다
		if (moo(0, index)) System.out.println("m");
		else System.out.println("o");
	}

	static boolean moo(int start, int index) {
		int mid = start + mooLength[index - 1] + (index + 2);					// mid 위치 잡기
		if (N <= start + mooLength[index - 1]) return moo(start, index - 1); 	// 앞부분에서 다시 탐색
		else if (N <= mid) return N == mid - (index + 1);						// 맨앞글자검사
		else return moo(mid, index - 1); 										// 뒷부분에서 다시 탐색
	}
}
