package com.ssafy.java;

import java.util.Scanner;

public class bj_3052_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] input=new int[10];
		int[] count=new int[42];
		int result=0;
	
		for (int i = 0; i < 10; i++) {
			int re=-1;
			input[i]=sc.nextInt();
			re=input[i]%42;
			for(int k=0;k<42;k++)
			{
				if(re==k)
				{
					count[k]++;
				}
			}
		}
		
		for (int j=0;j<42;j++)
		{
			if(count[j]!=0)
			{
				result++;
			}
		}
		System.out.println(result);
			
		sc.close();
	}

}
