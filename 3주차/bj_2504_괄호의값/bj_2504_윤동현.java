import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_2504_윤동 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch = br.readLine().toCharArray();
		Stack<Character> s = new Stack<Character>();
		
		int sum = 0, mul = 1;
		boolean isCheck = false;
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == '(' || ch[i] == '[') {
				s.push(ch[i]);
				mul *= (ch[i] == '(')?2:3;
			} else if(ch[i] == ')') {
				if(s.isEmpty() || s.peek() != '(') {
					isCheck = true;
					break;
				}
				if(ch[i-1] == '(') {
					sum += mul;
				}
				s.pop();
				mul /= 2;
			} else if(ch[i] == ']') {
				if(s.isEmpty() || s.peek() != '[') {
					isCheck = true;
					break;
				}
				if(ch[i-1] == '[') {
					sum += mul;
				}
				s.pop();
				mul /= 3;
			}
			System.out.println(sum+" "+mul);
		}//end for
		System.out.println((!isCheck&&s.isEmpty())?sum:0);
		br.close();
	}//end main
}//end class
