package com.ssafy.java;

import java.util.Scanner;

public class bj_8958_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		String ox;
		int score=0;

		for(int k=0;k<T;k++)
		{
			ox=sc.next();
			if(ox.length()==0||ox.length()>80)
			{
				System.out.println("길이 조건 확인");
			}
			score=0;
			int con=1;
			for(int i=0;i<ox.length();i++)
			{
				if(ox.charAt(i)=='O') {
					if((i-1)<0)
					{
						score++;
						continue;
					}
					else if(ox.charAt(i-1)==ox.charAt(i))
					{
						con++;
						
					}
					score+=con;
				}
				else if(ox.charAt(i)=='X')
				{
					con=1;
				}
				
			}
			System.out.println(score);
		}
		sc.close();
	}
}
