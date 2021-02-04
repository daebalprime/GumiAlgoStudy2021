package com.ssafy.java;

import java.util.Scanner;

public class bj_10828_변우석 {
	
	static int[] stack;
	static int size=0;

	static void push(int i) {
		stack[size]=i;
		size++;
	}
	
	static int pop() {	
		if(size==0) {
			return -1;
		}
		else {
			int last=stack[size-1];
			stack[size-1]=0;
			size--;
			return last;
		}
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size==0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	static int top() {
		if(size==0) {
			return -1;
		}
		else {
			return stack[size-1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		
		stack=new int[N];
		
		
		for(int i=0;i<N;i++) {
			String str=sc.next();
			
			switch (str) {
			
			case "push":
				push(sc.nextInt());
				break;
			
			case "pop":
				sb.append(pop())
				.append('\n');
				break;
			
			case "size":
				sb.append(size())
				.append('\n');
				break;
				
			case "empty":
				sb.append(empty())
				.append('\n');
				break;
			
			case "top":
				sb.append(top())
				.append('\n');
				break;
			}
			
		}
		System.out.println(sb);
		sc.close();
	}
}
