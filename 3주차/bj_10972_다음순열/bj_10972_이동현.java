package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_10972_다음순열_구미_4_이동현 {
	// 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인
	// 다시 뒤에서부터 탐색하면서 a보다 큰 첫번째 인덱스를 확인
	// a랑 b를 스왑
	// a+1에서부터 끝까지를 오름차순 정렬
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		if (next_permutation() == -1) System.out.println(-1);
		else for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
	}
	
	static int next_permutation() {
		int i;
		for (i = arr.length - 2; i >=0; i--) {
			if (arr[i] < arr[i + 1] ) break;
		}
		if (i != -1) {
			for (int j = arr.length - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					swap(arr,i,j);
					break;
				}
			}
			Arrays.sort(arr, i + 1, arr.length);
		} else return -1;
		
		return 1;
	}
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
