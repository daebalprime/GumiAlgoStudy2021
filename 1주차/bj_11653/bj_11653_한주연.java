package bj_11653;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int MAX = 10000000;
    	int n = Integer.parseInt(br.readLine());
    	for(int i = 2; i < MAX; i++) {
    		if(n % i == 0) {		// 만약 나누어 떨어지면
    			while(true) {		// 그 수로 최대한 나눈다.
    				if(n % i == 0) {
    					n /= i;
    					System.out.println(i);
    				}
    				else {
    					break;
    				}
    			}
    			if(n == 1)			// 주어진 수가 1이되면 종료
    				break;
    		}
    	}
    	br.close();
    }
}