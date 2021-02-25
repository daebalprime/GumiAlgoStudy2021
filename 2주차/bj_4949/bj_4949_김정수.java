package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_4949 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = in.readLine();
			char [] stack = new char[input.length()];
			int top = -1;
			if(input.equals(".")) break;
			
			for(int i=0;i<input.length();i++) {
				char c = input.charAt(i);
				if(c == '[' || c==']'||c=='('||c==')') {
					if(top!= -1) {
						if(stack[top] == '[' && c == ']') {
							top--;
						}
						else if(stack[top] == '(' && c == ')') {
							top --;
						}else {
							stack[++top] = c;
						}
					}else {
						stack[++top] = c;
					}
				}
			}
			if(top == -1){
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}

}
