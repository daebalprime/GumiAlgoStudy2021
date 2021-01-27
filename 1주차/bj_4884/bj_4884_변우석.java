package com.ssafy.java;

import java.util.Scanner;

public class bj_4884_변우석 {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		long G=0; //그룹의 수
		long A=0; //그룹하나당 진출하는 팀의 수
		long T=0; //그룹 하나당 팀의 수
		long D=0; //바로 토너먼트로 진출하는 팀의 수
		long X=0; //총 경기 수

		while(true)
		{
			long one_group_match=0; //하나의 그룹에서 치뤄지는 경기의 수
			long round_1=0;
			long round_2=0;
			long round_2_total_team=0;
			long Y=0;
			G=sc.nextLong();
			T=sc.nextLong();
			A=sc.nextLong();
			D=sc.nextLong();
			
			if(G==-1&&A==-1&&T==-1&&D==-1)
			{
				sc.close();
				break;
			}
			if(G<=0||D<0||T<=0||(G>(1<<16))||(T>(1<<16))||(A>(1<<16))||(D>(1<<16))||A>T || A<=0)
			{
				System.out.println("진출팀 조건을 확인하세요.");
				continue;
			}
									
			for(long k=1;k<T;k++) { //하나의 그룹에서 치뤄지는 경기의 수
				one_group_match+=((long)T-k);
			}
			round_1=G*one_group_match; //조별리그의 경기 수
									
			for(long i=0;i<=33;i++) //Y값 구하기
			{
				if(((long)G*A)+D==((long)1<<i)) //2진수인지 확인
				{
					break;
				}
				else
				{
					long test=((long)G*A)+D+Y;
					
					if(test<=((long)1<<i)) {
						Y=((long)1<<i)-test;
						break;
					}
				}
			}
			
			round_2_total_team=((long)G*A)+Y+D; //토너먼트를 치르는 팀의 수
			round_2=round_2_total_team-1; //토너먼트 경기의 수
			
			X=round_1+round_2; 
		
			System.out.println(G+"*"+A+"/"+T+"+"+D+"="+X+"+"+Y);		
		}
	}

}
