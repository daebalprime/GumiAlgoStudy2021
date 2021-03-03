package a_5weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_1517_버블소트 {
	//자기보다 작은 숫자 만큼 스왑을 한다? ->n^2 ..
	//병합 정렬?? nlogn 참고:https://log-laboratory.tistory.com/72
	static long ans;
	static long [] arrcopy;
	public static void main(String[] args)throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		long [] arr=new long[n];
		arrcopy=new long[n];
		String []s=in.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			arr[i]=Integer.parseInt(s[i]);
		}
		mergeSort(arr, 0, n-1);
		System.out.println(ans);
	}
	static void mergeSort(long arr[], int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			mergeSort(arr, left,mid); //왼쪽
			mergeSort(arr, mid+1,right); //오른쪽
			merge(arr,left,mid,right);//병합
		}
	}
	static void merge(long []arr,int left,int mid,int right) {
		int i=left;
		int j=mid+1;
		int k=left;
		//한쪽리스트가 사라질때까지
		while(i<=mid&&j<=right) {
			if(arr[i]<=arr[j]) {
				arrcopy[k++]=arr[i];
				i++;
			}
			else { //왼쪽을 기준으로 오른쪽 배열과 비교해서 오른쪽부터 놓는 경우 swap!
				arrcopy[k++]=arr[j];
				j++;
				ans+=mid-i+1;//왼쪽의 남은 크기 만큼 더한다.
			}
		}
		//배열에서 남은 것들을 리스트에 추가
		if(i>mid) {//오른쪽 배열이 남음
			while(j<=right) {
				arrcopy[k++]=arr[j++];
			}
		}else {//왼쪽 배열
			while(i<=mid)
				arrcopy[k++]=arr[i++];
		}
		//arrcopy->arr 
		for(int p=left;p<=right;p++)
			arr[p]=arrcopy[p];
	}
}
