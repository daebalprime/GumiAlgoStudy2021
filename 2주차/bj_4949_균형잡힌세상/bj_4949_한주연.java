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
    	StringTokenizer stk; 
    	//st = new StringTokenizer(br.readLine());
    	Stack<Character> st = new Stack<Character>();
    	boolean bl = true;
    	while(true) {
    		String str = br.readLine();
    		if(str.equals("."))
    			break;
    		for(int i = 0; i < str.length(); i++) {
    			char c = str.charAt(i);
    			if(c == '[' || c == '(') {
    				st.push(c);
    			}
    			else if(c == ']') {
    				if(!st.empty() && st.peek() == '[') {
    					st.pop();
    				}
    				else {
    					bl = false;
    					break;
    				}
    			}
    			else if(c == ')') {
    				if(!st.empty() && st.peek() == '(') {
    					st.pop();
    				}
    				else {
    					bl = false;
    					break;
    				}
    			}
    		}
    		if(bl && st.empty())
    			System.out.println("yes");
    		else {
    			System.out.println("no");
    			bl = true;
    		}
    		st.clear();
    	}
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}