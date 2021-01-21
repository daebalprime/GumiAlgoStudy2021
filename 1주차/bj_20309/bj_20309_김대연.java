package bj_20309;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean is_possible = true;
//		ArrayList<Integer> num_list = new ArrayList<Integer>();
		int sz = sc.nextInt();
		int[] num_list = new int[sz];
		for(int i = 0; i < sz; i++) {
			int n = sc.nextInt();
			num_list[i] = n;
		}
		
		for (int i = 0; i < num_list.length; i++) {
			int tmp = num_list[i];
			if (i % 2 == 0) {
				if (tmp % 2 == 0) {
					is_possible = false;
					break;
				}
			}
			else {
				if (tmp % 2 == 1) {
					is_possible = false;
					break;
				}
			}
		}
		if (is_possible) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		sc.close();
	}

}
