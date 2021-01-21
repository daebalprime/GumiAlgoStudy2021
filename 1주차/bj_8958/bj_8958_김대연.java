package bj_8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int streak = 0;
		sc.nextLine();
		for (int c = 0; c < cases; c++) {
			int point = 0;
			String str = sc.nextLine();
//			System.out.println("----------------------");
//			System.out.println(str + str.length());
			for (int i = 0; i < str.length(); i++) {
//				System.out.println("index : " + i);
				if (str.charAt(i) == 'O') {
					streak += 1;
					point += streak;
//					System.out.println("O " + point+" " + streak);
				}
				else {
					streak = 0;
					point += streak;
//					System.out.println("X " + point+" " + streak);
				}
			}
//			point += streak;
			System.out.println(point);
			streak = 0;
		}
		
		sc.close();
	}
}
