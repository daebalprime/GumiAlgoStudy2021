package baekjoon;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	while(n-- != 0) {
        	int score = 0, ctn = 0;
    		String str = br.readLine();
    		for(int i = 0; i < str.length(); i++) {
    			char curN = str.charAt(i);
    			if(curN == 'O') {
    				ctn++;
        			score += ctn;
        		}
    			else
    				ctn = 0;
    		}
    		System.out.println(score);
    	}
    	
    	br.close();
    }
}