/*
18258번 - 큐 2
https://www.acmicpc.net/problem/2841
*/

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = stoi(br.readLine());
    	int back= 0;
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer stk; 
    	Queue<Integer> st = new LinkedList<>();
    	while(n-- != 0) {
    		stk = new StringTokenizer(br.readLine());
    		switch(stk.nextToken()) {
    		case "push":
    			back = stoi(stk.nextToken());
    			st.offer(back);
    			break;
    		case "pop":
    			if(st.isEmpty()) {
    				sb.append("-1 \n");
    				break;
    			}
    			sb.append(st.poll() + "\n");
    			break;
    		case "size":
    			sb.append(st.size() + "\n");
    			break;
    		case "empty":
    			if(st.isEmpty())
    				sb.append("1 \n");
    			else
    				sb.append("0 \n");
    			break;
    		case "front":
    			if(st.isEmpty()) {
    				sb.append("-1 \n");
    				break;
    			}
    			sb.append(st.peek() + "\n");
    			break;
    		case "back":
    			if(st.isEmpty()) {
    				sb.append("-1 \n");
    				break;
    			}
    			sb.append(back + "\n");
    			break;
    		}
    		
    	}
    	System.out.print(sb.toString());
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}