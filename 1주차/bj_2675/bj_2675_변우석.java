package com.ssafy.java;

import java.util.Scanner;

public class bj_2675_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		if(T<1||T>1000)
		{
			System.out.println("조건 확인");
		}
	
		for(int tc=0;tc<T;tc++) {
			int R=sc.nextInt();
			if(R<1||R>8)
			{
				System.out.println("조건 확인");
				continue;
			}
			String str=sc.next();
			char input[]=new char[str.length()];
			if(str.length()<1||str.length()>20)
			{
				System.out.println("조건 확인");
				break;
			}
			for(int i=0;i<str.length();i++)
			{
				if((str.charAt(i)>=(char)45 &&str.charAt(i)<=(char)58)||(str.charAt(i)>=65&&str.charAt(i)<=90)||str.charAt(i)==(char)36||str.charAt(i)==(char)38||str.charAt(i)==(char)42||str.charAt(i)==(char)43||str.charAt(i)==(char)92||str.charAt(i)==(char)37)
				{
					input[i]=str.charAt(i);
				}else {
					System.out.println("범위 밖 문자");
					continue;
				}
				if(i==str.length()-1)
				{
					for(int j=0;j<input.length;j++)
					{
						for(int k=0;k<R;k++) {
						System.out.print(input[j]);
						}
					}
					System.out.println();
				}
			}			
		}
		sc.close();
	}	

}
