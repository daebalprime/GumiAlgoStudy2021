package bj_11653;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		// 에라토스테네스의 체
		ArrayList<Integer> primes = new ArrayList<>();
		boolean[] ar = new boolean[input+1];
		for (int i = 2; i<input+1; i++) {
			if (ar[i] == false) {
				primes.add(i);
			}
			else {
				continue;
			}
			for (int itr = i; itr < input+1; itr += i) {
				ar[itr] = true;
			}
		}
		// 에라토스테네스의 체 끝

	/*
	 * https://coding-groot.tistory.com/4 
	 * 위 링크에 소수 구하기 관련 정리가 잘 되어 있습니다.
	 * 에라토스테네스의 체는 1-N까지의 소수를 구할 때,
	 * n*boolean(1bit) 만큼의 공간이 필요합니다.
	 * 보통은 큰 문제가 되지는 않으나 알고리즘을 응용하거나
	 * 매우 작은 메모리 제한조건이 걸려있다면 
	 * 퍼포먼스를 희생해서 각 수마다 sqrt(n)까지만 검사하는
	 * brute force로 진행하시는 것도 권장드립니다. 
	 * bigO 증명은 귀찮아서 각자의 몫으로...ㅎㅎ;
	 */
		
//		for (Integer a : primes) {
//			System.out.println(a);
//		}
		int quotient = input;
		int divider = 0;
		int itr = 0;
		while(quotient != 1) {
			divider = primes.get(itr);
			if(quotient % divider != 0) {
				itr += 1;
				continue;
			}
			System.out.println(divider);
			quotient = quotient / divider;
		}
	}
}
