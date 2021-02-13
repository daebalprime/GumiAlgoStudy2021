/*
17225번 - 세훈이의 선물가게
https://www.acmicpc.net/problem/17225
*/

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	int bS = stoi(stk.nextToken());
    	int rS = stoi(stk.nextToken());
    	int csNum = stoi(stk.nextToken());		//customer number
    	
    	int time, pNum, bTime = 0, rTime = 0;
    	char color;
    	Queue<Integer> bp = new LinkedList<Integer>();
    	Queue<Integer> rp = new LinkedList<Integer>();
    	while(csNum-- != 0) {
    		stk = new StringTokenizer(br.readLine());
    		time = stoi(stk.nextToken());
    		color = stk.nextToken().charAt(0);
    		pNum = stoi(stk.nextToken());
    		
    		if(color == 'B') {
	    		if(time < bTime)
	    			time = bTime;
	    		
	    		for(int i = 0; i < pNum; i++) {
	    			bp.offer(time);
	    			time += bS;
	    			bTime = time;
	    		}
    		}
    		else {
    			if(time < rTime)
	    			time = rTime;
	    		
	    		for(int i = 0; i < pNum; i++) {
	    			rp.offer(time);
	    			time += rS;
	    			rTime = time;
	    		}
    		}
    	}
    	int curT = 0, idx = 1;
    	ArrayList<Integer> ba = new ArrayList<>();
    	ArrayList<Integer> ra = new ArrayList<>();
    	while(!bp.isEmpty() || !rp.isEmpty()) {
    		if(!bp.isEmpty() && curT == bp.peek()) {
    			ba.add(idx++);
    			bp.poll();
    			if(!bp.isEmpty() && bp.peek() == curT)
    				continue;
    		}
    		if(!rp.isEmpty() && curT == rp.peek()) {
    			ra.add(idx++);
    			rp.poll();
    			if(!rp.isEmpty() && rp.peek() == curT)
    				continue;
    		}
    			
    		curT++;
    	}
    	
    	System.out.println(ba.size());
    	for(int v : ba)
    		System.out.print(v + " ");
    	System.out.println();
    	System.out.println(ra.size());
    	for(int v : ra)
    		System.out.print(v + " ");
    	
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }

}