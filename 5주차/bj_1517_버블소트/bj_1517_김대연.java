package bj_1517;

import java.io.*;
import java.util.*;

public class Main {

	static long answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		mergeSort(list);
//		System.out.println(Arrays.toString(list));
		System.out.println(answer);
	}

	public static void mergeSort(int[] list) {
		mergeSort(list,0,list.length-1);
	}
	
	private static void mergeSort(int[] list,int start,int end) {
		
		if(start==end) return;
		
		// 2집합으로 분할하여 각각 정렬시킴
		int middle = (start+end)/2;
		mergeSort(list,start,middle); // 왼쪽 집합
		mergeSort(list,middle+1,end); // 오른쪽 집합
		
		// 정렬된 2집합을 이용하여 병합
		merge(list,start,middle,end);
		
	}

	private static void merge(int[] list, int start, int middle, int end) {
		
		int[] newArr = new int[end-start+1];
		int left = start, right = middle+1;
		long lc = 0, rc = 0;
		int i=0; // 결과 배열인덱스
		do {
			if(list[left] <= list[right]) {
				newArr[i++] = list[left++];
				lc++;
				answer += rc;
			}else{
				newArr[i++] = list[right++];
				rc++;
			}
		}while(left <= middle   &&  right <= end );
		
		// 오른쪽 집합이 다 소비된 경우.
		while(left<=middle) {
			newArr[i++] = list[left++];
			answer += rc;
		}
		
		// 왼쪽 집합이 다 소비된 경우.
		while(right<=end) {
			newArr[i++] = list[right++];
		}
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}
}

