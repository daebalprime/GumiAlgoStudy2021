package bj_3052;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int arr[] = new int[42];	//42의 나머지를 보는 것이므로, 42의 크기로 초기화
    	for(int i = 0; i < 10; i++) {
    		int cal = Integer.parseInt(br.readLine()) % 42; 	//입력받는 값을 42로 나누어 나머지로 변환
    		arr[cal]++;				//위 나머지를 인덱스로 배열에 입력
    	}
    	int cnt = 0;
    	for(int v : arr) {			//배열을 전부 탐색하여 0이 아닌 서로 다른 나머지의 개수를 센다.
    		if(v != 0)
    			cnt++;
    	}
    	System.out.println(cnt);
    	br.close();
    }
}
