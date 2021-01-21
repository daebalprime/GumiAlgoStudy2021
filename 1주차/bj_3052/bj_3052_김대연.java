package bj_3052;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> sett = new HashSet<Integer>();
		int sz = 10;
		for (int i = 0; i < sz; i++) {
			int curr = sc.nextInt();
			sett.add(curr%42);
		}
		System.out.println(sett.size());
		sc.close();
	}

}
