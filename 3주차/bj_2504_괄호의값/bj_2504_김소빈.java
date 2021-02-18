package bj_silver;

import java.util.*;
import java.io.*;

public class Main_bj_2504_괄호의값 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] li;
		li = br.readLine().toCharArray();
//		for(char tmp: li) System.out.println(tmp);
		Stack<String> s = new Stack<>();
		
		for(char t: li) {
			int tmp = 0;
			if(t == '(') s.push(")");
			else if(t == '[') s.push("]");
			else if(t == ')') {
				if(s.isEmpty()) break;
				if(")"==s.peek()) {
					s.pop(); 
					s.push("2");
				}
				else {
					while(!s.isEmpty() && s.peek() != ")" && s.peek() != "]") {
						tmp+= Integer.parseInt(s.pop());
					}
					if(s.isEmpty()) break;
					else if(s.peek() == ")") {
						s.pop();
						tmp *= 2;
					}
					s.push(Integer.toString(tmp));
				}
			}
			else if(t == ']') {
				if(s.isEmpty()) break;
				if("]"==s.peek()) {
					s.pop(); 
					s.push("3");
				}
				else {
					while(!s.isEmpty() && s.peek() != ")" && s.peek() != "]") {
						tmp += Integer.parseInt(s.pop());
					}
					if(s.isEmpty()) break;
					else if(s.peek() == "]") {
						s.pop();
						tmp *= 3;
					}
					s.push(Integer.toString(tmp));
				}
			}
//			System.out.println(s);
		}
		int ans = 0;
		while(!s.isEmpty()) {
			if(s.peek() == ")" || s.peek() == "]") {
				ans = 0;
				break;
			}
			ans += Integer.parseInt(s.pop());
		}
		System.out.println(ans);
	}
}
