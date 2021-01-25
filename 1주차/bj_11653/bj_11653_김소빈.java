package bj_11653;

import java.util.*;

public class bj_11653_김소빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int n = N;
		for(int i = 2; i*i <= N; i++) {
			while(n%i == 0) {
				n /= i;
				System.out.println(i);
			}
		}
		if(n != 1) System.out.println(n);
	}
}
