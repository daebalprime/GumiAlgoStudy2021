package bj_silver;

import java.io.*;
import java.util.*;

public class bj_10972_김소빈 {
	static int [] a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = new int [N];
		for(int i = 0 ; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int i = N-1;
		while(i>0 && a[i] < a[i-1]) i--;
		if(i == 0) {
			System.out.println(-1);
			return;
		}
		
		int j = N-1;
		while(a[j] < a[i-1]) j--;
		 
		int tmp = a[j];
		a[j] = a[i-1];
		a[i-1] = tmp;
		
		int k = N-1;
		while(i < k) {
			tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
			i++; k--;
		}
		for(int at: a) System.out.print(at+" ");
		br.close();
	}
}
