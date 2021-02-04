package wk2.bj2841;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int P = sc.nextInt();
		List<Stack<Integer>> strs = new ArrayList<Stack<Integer>>();
		//String&Finger status
		for(int i = 0; i < 6; i++) strs.add(new Stack<Integer>());
		int answer = 0;
		for(int i = 0; i < T; i++) {
//			System.out.println("음시작");
			int sn = sc.nextInt() - 1;
			int fret = sc.nextInt();
			
			Stack<Integer> currStr = strs.get(sn);
			
			if( currStr.size()==0 || currStr.peek() < fret) {
//				System.out.println("손붙임");
				currStr.add(fret);
				answer++;
				continue;
			}
			else if(currStr.size()!=0 && currStr.peek() == fret) {
//				System.out.println("안씀");
				continue;
			}
			while(currStr.size() != 0 && currStr.peek() > fret) {
//				System.out.println("손뗌");
				currStr.pop();
				answer++;
			}
			if(currStr.size() == 0 || currStr.peek() < fret) {
//				System.out.println("손씀");
				currStr.add(fret);
				answer++;			
			}

		}
		System.out.println(answer);
		sc.close();
	}

}
