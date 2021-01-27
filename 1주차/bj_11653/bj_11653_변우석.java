package com.ssafy.java;

import java.util.Scanner;

public class bj_11653_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N<1||10000000<N)
		{
			System.out.println("조건 확인");
		}
		else
		{
			for(int i=2;i<=N;i++) {
				if(N%i==0) {
					N=N/i;
					System.out.println(i);
					i--;
				}
			}
		}		
		sc.close();
	}
}
