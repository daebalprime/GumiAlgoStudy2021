/*
1966번 - 프린터 큐
https://www.acmicpc.net/problem/1966
*/

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk; 
    	
    	int tc = stoi(br.readLine());
    	Queue<Pair> dc = new LinkedList<Pair>();
    	int n, m, cnt = 1;
    	while(tc-- != 0) {
    		// 초기화  시작
    		dc.clear();
    		cnt = 1;
    		stk = new StringTokenizer(br.readLine());
    		n = stoi(stk.nextToken());
    		m = stoi(stk.nextToken());
    		stk = new StringTokenizer(br.readLine());
    		for(int i = 0; i < n; i++)
    			dc.offer(new Pair(stoi(stk.nextToken()), i));
    		// 초기화 끝
    		
    		boolean isBiggest = true;
    		Pair curP, nextP;
    		while(!dc.isEmpty()) {
    			isBiggest = true;
    			curP = dc.poll();
        		for(int i = 0; i < dc.size(); i++) {
	    			nextP = dc.poll();
	    			if(curP.first < nextP.first)
	    				isBiggest = false;
	    			dc.offer(nextP);
	    		}
        		if(isBiggest) {
        			if(curP.second == m) {
        				System.out.println(cnt);
        				break;
        			}
        			cnt++;
        		}
        		else {
        			dc.offer(curP);
        		}	
    		}
    	}
    	
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
    
    static class Pair {
    	int first;
    	int second;
    	Pair(int a, int b){
    		this.first = a;
    		this.second = b;
    	}
    }
}