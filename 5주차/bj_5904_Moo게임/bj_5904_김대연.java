package bj_5904;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())-1;
		br.close();
		if(N == 0) {
			System.out.println("m");
			return;
		}
		if(N == 1 || N == 2) {
			System.out.println("o");
			return;
		}
		int[] mooLength = new int[28];
		mooLength[0] = 3;
		int i = 0;
		//S(27) max!
		while(true) {
			if(mooLength[i] > N) break;
			i++;
			mooLength[i] = mooLength[i-1]*2+(i+3);
		}
		divide(N,i, mooLength);
	}
	
	static void divide(int n, int level, int[] length) {
		if(n==0) {
			System.out.println("m");
			return;
		}
		if(level == 0) {
			System.out.println("o");
			return;
		}
		if(n < length[level-1]) {
			divide(n, level-1, length);
		}
		else if(n==length[level-1]) {
			System.out.println("m");
			return;
		}else if(n > length[level-1] && n <= length[level-1]+2+level) {
			System.out.println("o");
			return;
		} 
		else {
//			System.out.println("");
			divide(n-(level+3)-length[level-1], level-1, length);
		}
		
	}
}


