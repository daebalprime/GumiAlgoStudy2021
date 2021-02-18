package bj_1010;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			long answer = 1;
			int N = sc.nextInt();
			int M = sc.nextInt();
			N = Math.min(N, M-N);
			for(int i = 0; i < N; i++) {
				answer *= (M-i);
				answer /= (i+1);
			}
//			for(int i = 1; i <= N; i++) {
//				answer /= i;
//			}
			System.out.println(answer);
		}
	}
}
