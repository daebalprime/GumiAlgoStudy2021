package com.ssafy.java;

import java.util.Scanner;

public class bj_7568_변우석 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N<2||N>50)
		{
			System.out.println("조건 확인");
		}
		int[][] hei_wei=new int[N][2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<2;j++) {
				hei_wei[i][j]=sc.nextInt();
				if(hei_wei[i][j]<10||hei_wei[i][j]>200)
				{
					System.out.println("조건 확인");
					break;
				}
			}
		}		
		for(int i=0;i<N;i++) {
			int rank=0;
			for(int k=0;k<N;k++) {
				if(hei_wei[i][0]<hei_wei[k][0]&&hei_wei[i][1]<hei_wei[k][1]) {
					rank++;
				}
			}
			System.out.print((rank+1)+" ");
		}
		sc.close();
	}
}
