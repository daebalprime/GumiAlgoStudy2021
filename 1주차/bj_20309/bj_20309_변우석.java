package com.ssafy.java;

import java.util.Scanner;

public class bj_20309_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N<3||N>300000)
		{
			System.out.println("조건 제한");
		}
		int[] arr=new int[N];
		int result=0;
		
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		for(int j=0;j<N;j+=2)
		{
			if(arr[j]%2==1)
			{
				result++;
			}
		}
		for(int k=1;k<N;k+=2)
		{
			if(arr[k]%2==0)
			{
				result++;
			}
		}
		if(result==N)
		{
			System.out.println("YES");
		}else
			System.out.println("NO");
	
		sc.close();
	}

}
