package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2504_괄호의값_구미_4_이동현 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		Stack<String> s = new Stack<>();
		int ridx = 0;
		int sidx = 0;
		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) == '(' ) {
				s.push("(");
				ridx++;
			} else if (arr.charAt(i) == ')') {
				ridx--;
				if (ridx < 0) {
					System.out.println(0);
					return;
				}
				if (s.peek().equals("(")) {
					s.pop();
					s.push("2");
				}
				else {
					int sum = 0;
					while(!s.isEmpty()) {
						if (s.peek().equals("(")) {
							s.pop();
							sum*=2;
							s.push(Integer.toString(sum));
							break;
						} else if (s.peek().equals("[")) {
							System.out.println(0);
							return;
						} else {
							sum += Integer.parseInt(s.pop());
						}
					}
				}
			} else if (arr.charAt(i) == '[') {
				s.push("[");
				sidx++;
			} else if (arr.charAt(i) == ']'){
				sidx--;
				if (sidx < 0) {
					System.out.println(0);
					return;
				}
				if (s.peek().equals("[")) {
					s.pop();
					s.push("3");
				} else {
					int sum = 0;
					while(!s.isEmpty()) {
						if (s.peek().equals("[")) {
							s.pop();
							sum*=3;
							s.push(Integer.toString(sum));
							break;
						} else if (s.peek().equals("(")) {
							System.out.println(0);
							return;
						} else {
							sum += Integer.parseInt(s.pop());
						}
					}
				}
			}
		}
		if (sidx != 0 || ridx != 0) {
			System.out.println(0);
			return;
		}
		int result = 0;
		while(!s.isEmpty()) {
			result += Integer.parseInt(s.pop());
		}
		System.out.println(result);
	}
}
