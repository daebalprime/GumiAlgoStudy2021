package bj;

import java.util.Scanner;

public class bj_2346_김소빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		//입력 끝
		int remain = N;
		int idx = 0; int dir = 1;
		while(remain > 0) {
			int move = arr[idx];
			dir = 1;
			if(move < 0) {
				move *= -1;
				dir = -1;
			}
			arr[idx] = 0;//check 만들 필요 x
			remain--;
			System.out.print(idx+1+" ");
			
			while(move > 0 && remain > 0) {//move(arr[idx])만큼 이동하기
				int nidx = idx+dir;
				if(nidx < 0) nidx = N-1;
				if(nidx >= N) nidx = 0;
				
				if(arr[nidx] != 0) {
					idx = nidx;
					move--;
				}
				else {
					idx = nidx;
				}
			}
		}
		
		sc.close();
	}
}

//1차원 배열을 잘 다루기가 쉽지않다고 느껴졌다
//좋은 반례 
//5
//-5 -5 -5 -5 -5
