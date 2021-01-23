package bj_1316;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int answer = T;
		for (int tc = 0; tc < T; tc++) {
			Set<Character> charset = new HashSet<Character>();
			String str = sc.nextLine();
			char prev = ' ';
			for (int l = 0; l < str.length(); l++) {
				char curr = str.charAt(l);
				if (prev != curr) {
					if (!charset.contains(curr)) {
						charset.add(curr);
					}
					else {
						answer -= 1; 
						break;
					}
				}
				prev = curr;
			}
		}
		System.out.println(answer);
	}
}
