package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class bj_17255 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		Deque <int[]> sangmin = new LinkedList<>();
		Deque <int[]> jisu = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			char type = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
			if(type == 'B') {
				// 상민
				sangmin.add(new int[] {time, num});
			}else {
				jisu.add(new int[] {time, num});
			}
		}
		
		// 주문 받은 리스트
		Deque <Integer> sangminTask = new LinkedList<>();
		Deque <Integer> jisuTask = new LinkedList<>();
		
		// 포장 경과 시간
		int sangminTime = -1;
		int jisuTime = -1;
		
		// 현재 포장하고 있는 선물 번호
		int sangminItem = 0;
		int jisuItem = 0;
		
		// 선물 번호 리스트
		Deque <Integer> sangminList = new LinkedList<>();
		Deque <Integer> jisuList = new LinkedList<>();
		
		int ticker = 0;
		int item = 1;
		while(true) {
			if((sangmin.size() ==0 && jisu.size()==0) && (sangminItem == 0 && jisuItem==0)) {
				break;
			}
			//System.out.println(ticker+"초");
			// 상민
			// 1. 주문 받기
			if(!sangmin.isEmpty()) {
				while(sangmin.getFirst()[0] <= ticker) {
					int s = sangmin.poll()[1];
					for(int i=0;i<s;i++) {
						sangminTask.add(A);
					}
					if(sangmin.isEmpty()) break;
				}
			}
			// 2. 상품 포장
			while(sangminTime<=0) {
				// 현재 작업 종료되었는지 확인
				if(sangminItem != 0) {
					// 3. 포장 끝
					// 포장 마친 아이템 리스트에 넣기
					//System.out.println("상민: "+ sangminItem+"번 포장 끝!");
					sangminList.add(sangminItem);
					sangminItem = 0; // 초기화
				}
				if(!sangminTask.isEmpty()) {
					// 현재 작업중인거 없으면 다음꺼 챙기기
					sangminTime = sangminTask.poll();
					// 포장 시작할때 상품번호 붙이기
					sangminItem = item++;
					//System.out.println("상민: "+ sangminItem+"번 포장 시작!");
				}else {
					break;
				}
			}
			
			// 지수
			// 1. 주문 받기
			if(!jisu.isEmpty()) {
				while(jisu.getFirst()[0] <= ticker) {
					int s = jisu.poll()[1];
					for(int i=0;i<s;i++) {
						jisuTask.add(B);
					}
					if(jisu.isEmpty()) break;
				}
			}
			// 2. 상품 포장
			while(jisuTime<=0) {
				// 현재 작업 종료되었는지 확인
				if(jisuItem != 0) {
					// 3. 포장 끝
					// 포장 마친 아이템 리스트에 넣기
					//System.out.println("지수: "+ jisuItem+"번 포장 끝!");
					jisuList.add(jisuItem);
					jisuItem = 0; // 초기화
				}
				if(!jisuTask.isEmpty()) {
					// 현재 작업중인거 없으면 다음꺼 챙기기
					jisuTime = jisuTask.poll();
					// 포장 시작할때 상품번호 붙이기
					jisuItem = item++;
					//System.out.println("지수: "+ jisuItem+"번 포장 시작!");
				}else {
					break;
				}
			}
			
			ticker++;
			sangminTime--;
			jisuTime--;
		}
		
		// 출력
		System.out.println(sangminList.size());
		for(int i: sangminList) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println(jisuList.size());
		for(int i: jisuList) {
			System.out.print(i+" ");
		}
	}

}
