package bj_2675;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	int r;
    	String s;
    	for(int i = 0; i < tc; i++) {
    		StringTokenizer stk = new StringTokenizer(br.readLine());
    		r = Integer.parseInt(stk.nextToken());
    		s = stk.nextToken();
			//각 문자를 앞서 받은 반복 횟수 만큼 반복
    		for(int j = 0; j < s.length(); j++) {
    			for(int k = 0; k < r; k++) {
    				System.out.print(s.charAt(j));
    			}
    		}
    		System.out.println();
    	}
    	br.close();
    }
}