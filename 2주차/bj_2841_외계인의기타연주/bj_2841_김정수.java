package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_2841 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int [][] stack = new int[6][P];
		int [] top = new int[6];
		int count= 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int line = Integer.parseInt(st.nextToken()) -1;
			int pret = Integer.parseInt(st.nextToken()) -1;
			
			// 해당 프렛이 현재 줄에서 가장 높은 음일때까지 stack pop
			while(true) {
				if(top[line] == 0) {
					// 해당 프렛 push
					stack[line][top[line]] = pret;
					top[line] ++;
					count++;
					break;
				}
				if(stack[line][top[line]-1] < pret) {
					// 해당 프렛 push
					stack[line][top[line]] = pret;
					top[line] ++;
					count++;
					break;
				}
				else if(stack[line][top[line]-1] == pret) {
					break;
				}
				top[line] --;
				count ++;
			}
			
		}
		System.out.println(count);
	}

}
