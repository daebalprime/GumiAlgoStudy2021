/*
2841번 - 외계인의 기타 연주
https://www.acmicpc.net/problem/2841
*/

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = stoi(br.readLine());
    	int num;
    	String order;
    	
    	StringTokenizer stk; 
    	Stack<Integer> st = new Stack<Integer>();
    	while(n-- != 0) {
    		stk = new StringTokenizer(br.readLine());
    		order = stk.nextToken();
    		switch(order) {
    		case "push":
    			num = stoi(stk.nextToken());
    			st.push(num);
    			break;
    		case "pop":
    			if(st.empty()) {
    				System.out.println(-1);
    				break;
    			}
    			System.out.println(st.peek());
    			st.pop();
    			break;
    		case "size":
    			System.out.println(st.size());
    			break;
    		case "empty":
    			if(st.empty())
    				System.out.println(1);
    			else
    				System.out.println(0);
    			break;
    		case "top":
    			if(st.empty()) {
    				System.out.println(-1);
    				break;
    			}
    			System.out.println(st.peek());
    			break;
    		}
    	}
    	
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}