package bj_gold;

import java.util.Scanner;

//np 사용코드, 시간 초과 걸립니다.
public class Main_bj_1256_사전 {
	static char[] arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int z = sc.nextInt();
		int k = sc.nextInt();
		n = a+z;
		arr = new char[n];
		for(int i = 0; i < a; i++) arr[i] = 'a';
		for(int i = a; i < n; i++) arr[i] = 'z';
		//입력완료
		
		for(int i = 1; i < k; i++) {
			np();
		}
		for(char cur: arr) System.out.print(cur);
		sc.close();
	}
	private static boolean np() {
		int i = n-1;
		while(i>0 && arr[i]<=arr[i-1]) i--;
		if(i == 0) return false;
		
		int j = n-1;
		while(arr[i-1] >= arr[j]) j--;
		swap(i-1, j);
		
		int k = n-1;
		while(i < k) swap(i++, k--);
		return true;
	}
	private static void swap(int x, int y) {
		char tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
