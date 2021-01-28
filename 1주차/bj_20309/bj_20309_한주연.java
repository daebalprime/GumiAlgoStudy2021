package bj_20309;

/*
11724번 - 연결 요소의 개수
https://www.acmicpc.net/problem/20309
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n+1];
    	boolean isSort = true;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int i = 1; i <= n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    	//System.out.println(Arrays.toString(arr));
    	for(int i = 1; i <= n; i++) {
    		if(arr[i] % 2 != 1 && i % 2 == 1) {
    			isSort = false;
    		}
    		else if(arr[i] % 2 != 0 && i % 2 == 0) {
    			isSort = false;
    		}
    	}
    	
    	if(isSort) {
    		System.out.println("YES");
    	}else {
    		System.out.println("NO");
    	}
    	
    	br.close();
    }
}
