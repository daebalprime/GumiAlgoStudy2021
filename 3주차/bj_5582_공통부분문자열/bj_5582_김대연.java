package bj_5582;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		
		int answer = 0;
		
		int[][] map = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i-1 >= 0 && j-1 >= 0) {
						map[i][j] = map[i-1][j-1]+1;
					}
					else {
						map[i][j] = 1;
					}
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		System.out.println(answer);
		
	}

}
