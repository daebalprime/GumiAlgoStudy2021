package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_10828 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] stack = new int[N];
		int top = 0;
		
		for(int i=0;i<N;i++) {
			String[] command = in.readLine().split(" ");
			
			switch(command[0]) {
			
			case "push":
				if(top <N-1) {
					stack[top++] = Integer.parseInt(command[1]);
				}
				break;
			case "pop":
				if(top == 0) {
					System.out.println("-1");
				}else {
					System.out.println(stack[--top]);
				}
				break;
			case "size":
				System.out.println(top);
				break;
			case "empty":
				System.out.println(top==0?"1":"0");
				break;
			case "top":
				System.out.println(top==0?"-1":stack[top-1]);
				break;
			}
		}
	}

}
