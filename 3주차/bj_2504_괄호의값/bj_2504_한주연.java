import java.util.*;
import java.io.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		Stack<Integer> numSt = new Stack<>();
		boolean isRight = true;
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == ']') {
    			if(st.empty() || st.peek() == '(') {	// ] 인 경우나  (] 인 틀린 경우
    				isRight = false;
    				break;
    			}
    			else if(st.peek() == '[') {				// []와 같이 바로 닫기는 틀린 경우
    				st.pop();
        			st.push('a');
        			numSt.push(3);
    			}
    			else if(st.peek() == 'a') {		// 중간에 숫자가 껴 있는 경우
    				int sum = 0;
    				while(!st.empty() && st.peek() != '[') {	// [를 만날 때 까지 3을 곱하며 더한다
    					if(st.peek() == '(') {			// (()]인 틀린 경우
    						isRight = false;			 
    						break;
    					}
    					st.pop();
    					sum += numSt.pop() * 3;
    				}
    				if(st.empty()) {	// 틀린 경우
    					isRight = false;
    					break;
    				}
    				st.pop();
    				st.push('a');
    				numSt.push(sum);
    			}
    		}
    		else if(str.charAt(i) == ')') {
    			if(st.empty() || st.peek() == '[') {	// ) 인 경우나  [) 인 틀린 경우
    				isRight = false;
    				break;
    			}
    			else if(st.peek() == '(') {				// ()와 같이 바로 닫기는 틀린 경우
    				st.pop();
        			st.push('a');
        			numSt.push(2);
    			}
    			else if(st.peek() == 'a') {
    				int sum = 0;
    				while(!st.empty() && st.peek() != '(') {
    					if(st.peek() == '[') {			// [[]) 과 같은 틀린 경우
    						isRight = false;			 
    						break;
    					}
    					st.pop();
    					sum += numSt.pop() * 2;
    				}
    				if(st.empty()) {
    					isRight = false;
    					break;
    				}
    				st.pop();
    				st.push('a');
    				numSt.push(sum);
    			}
    		}
    		else {
    			st.push(str.charAt(i));
    		}
    	}
    	
    	while(!st.empty()) {				// 위 과정이 끝나고 아래 괄호가 남아 있으면 완전히 닫히지 않은 틀린 괄호이다.  
    		char c = st.pop();
    		if(c == '[' || c == '(' || c == ')' || c == ']') {
    			isRight = false;
    			break;
    		}
    	}
    	
    	if(!isRight) {
    		System.out.println(0);
    		br.close();
    		return;
    	}
    	int result = 0;
    	while(!numSt.empty())
    		result += numSt.pop();
    	
    	System.out.println(result);
    	br.close();
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}