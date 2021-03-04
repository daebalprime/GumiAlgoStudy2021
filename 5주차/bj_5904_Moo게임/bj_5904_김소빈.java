/** 메모리초과코드*/
package bj_silver;

import java.util.*;

public class Main_bj_5904_Moo게임 {
	static String moo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(moo(n).charAt(n-1));
		sc.close();
	}
	private static String moo(int cnt) {
		if(cnt == 0) {
			return "moo";
		}
		
		String cur = "m";
		for(int i = 0; i < cnt+2; i++) {
			cur += "o";
		}
		String prev = moo(cnt-1);
		return prev+cur+prev;
	}
}
