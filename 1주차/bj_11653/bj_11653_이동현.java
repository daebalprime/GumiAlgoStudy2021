import java.util.*;
import java.io.*;

public class Main {
	final static int MAX_NUM = 10000000;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_bj_11653.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num = 0;
		if (N == 1) return;
		while (!is_prime(N)) {
			int np = is_next_prime(num);
			if (N % np == 0) {
				N /= np;
				System.out.println(np);
			} else {
				num = np;
			}
		}
		System.out.println(N);
	}
	public static boolean is_prime(int n) {
		boolean check = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}
	public static int is_next_prime(int n) {
		int num = 0;
		for (int j = n + 1; j < MAX_NUM; j++ ) {
			if (j != 1 && is_prime(j)) {
				num = j;
				break;
			}
		}
		return num;
	}
}