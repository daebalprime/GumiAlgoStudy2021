package bj_silver;

import java.util.*;

public class Main_bj_5904_Moo게임 {
	static int[] len = new int[29];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int idx = 0;
//		int size = check(); //n값의 최대값으로 최대 S(k)의 k값 구하기
//		System.out.println(size); //출력값 28 따라서 len = new int[29];
		
		while (n > len[idx]) {
			len[idx + 1] = len[idx] + idx + 3 + len[idx]; // len: S(idx)길이를 저장하는 배열
			idx++;
		}
		// n번째 문자를 확인하려면 필요한 idx를 계산해서 넘겨준다
		if (moo(0, idx, n-1)) System.out.println("m");
		else System.out.println("o");
		sc.close();
		
		
		
//		메모리초과 코드(무식하게 재귀)
//		System.out.println(moo(n).charAt(n-1));
	}

	private static boolean moo(int start, int k, int n) {
		int mid = start + len[k - 1] + k + 2; // idx는 k+1
		if (n == start || n == start + len[k - 1] || n == mid)
			return true;
		if (n < start + len[k - 1]) // 첫번째 블록 확인
			return moo(start, k - 1, n);
		else if (n < mid)
			return false; // 두번째 블록의 m이 아닌 경우
		else
			return moo(mid, k - 1, n); // 세번째 블록 확인
	}

	/*private static String moo(int cnt) {
		if (cnt == 0)
			return "moo";

		String cur = "m";
		for (int i = 0; i < cnt + 2; i++) {
			cur += "o";
		}
		String prev = moo(cnt - 1);
		return prev + cur + prev;
	}*/
	
	/*private static int check() {
		int idx = 0;
		while(1000000000 >= len[idx]) {
			len[idx+1] = len[idx]*2 +  idx+3;
			idx++;
		}
		return idx;
	}*/

}
