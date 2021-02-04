package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Solution_bj_10828_스택_구미_4_이동현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
				case "push":
					stack.push(s[1]);
					break;
				case "pop":
					if(stack.empty()) {
						System.out.println(-1);
						break;
					}
					System.out.println(stack.pop());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.empty()) System.out.println(1);
					else System.out.println(0);
					break;
				case "top":
					if(stack.empty()) System.out.println(-1);
					else System.out.println(stack.peek());
					break;
			}
		}
		br.close();
	}
}
