import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 참고링크
  https://jins-dev.tistory.com/entry/%EB%8B%A4%EC%9D%8C-%EC%88%9C%EC%97%B4-%EC%B0%BE%EA%B8%B0-%EC%A0%84%EC%B2%B4-%EC%88%9C%EC%97%B4-%ED%83%90%EC%83%89-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Next-Permutation
 */
public class Main_bj_10972_다음순열 {
	static int[] num;

	static void per(int idx) {
		int swapj = 0;
		// 스왑할 원소 찾기
		for (int i = num.length - 1; i >=0 ; i--) {
			if (num[idx] < num[i]) {
				swapj = i;
				break;
			}
		}
		// 스왑
		int temp = num[idx];
		num[idx] = num[swapj];
		num[swapj] = temp;
		// idx+1 부터 수열 마지막까지 reverse
		int left=idx+1;
		int right=num.length-1;
		while(left<right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++;
			right--;
		}
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String s[] = in.readLine().split(" ");
		num = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		// 마지막 순열인지 체크
		int idx = -1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1])
				idx = i;
		}
		if (idx == -1) {
			System.out.println(-1);
		} else {
			per(idx);
		}
	}

}
