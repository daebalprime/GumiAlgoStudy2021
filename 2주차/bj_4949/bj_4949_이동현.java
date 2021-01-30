package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Solution_bj_4949_균형잡힌세상_구미_4_이동현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ca = new char[100];
		String st;
		Stack<Character> stack = new Stack<Character>();
		while(!(st = br.readLine()).equals(".")) {
			ca = st.toCharArray();
			int result = 0;
			for (char c : ca) {
				if (c == '(' || c == '[') stack.push(c);
				else if (c == ')' || c == ']'){
					if(stack.empty()) {
						System.out.println("no");
						result = 1;
						break;
					}
					char check = stack.pop();
					if ((c == ')' && check != '(') || (c == ']' && check != '[')) {
						System.out.println("no");
						result = 1;
						break;
					} 
				}
			}
			if (result != 1 && stack.empty()) System.out.println("yes");
			else if (result == 0 && !stack.empty()) System.out.println("no");
			stack.clear();
		}
	}
}
