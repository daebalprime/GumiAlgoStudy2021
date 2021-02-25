import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_2504_괄호의값 {

	static boolean gwalhocheck(char[] gwalho) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < gwalho.length; i++) {
			char c = gwalho[i];
			if (c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				else {
					if (c == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (c == ')' && stack.peek() == '(')
						stack.pop();
					else
						stack.push(c);
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	//완벽한 것들
	static int cal(char[] gwalho) {
		//int->문자형 변환이 10이넘어가면 이상해진다.?
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < gwalho.length; i++) {
			String c = String.valueOf(gwalho[i]);
			if (c.equals("(" ) || c.equals("[" )) {
				stack.push(c);
			} else if(c.equals(")" )){
				if(stack.peek().equals("("))
				{
					stack.pop();
					stack.push("2");
				}
				else {
					int temp1=0;
					while(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							stack.pop();
							break;
						}
						else {
							temp1+=Integer.parseInt(stack.pop());
						}
					}
					temp1=temp1*2;
					stack.push(Integer.toString(temp1));
				}
			}else {
				if(stack.peek().equals("["))
				{
					stack.pop();
					stack.push("3");
				}
				else {//괄호안의 연산 
					int temp=0;
					while(!stack.isEmpty()) {
						//열린 괄호 만나면 연산종료
						if(stack.peek().equals("[")) {
							stack.pop();
							break;
						}
						else {
							temp+=Integer.parseInt(stack.pop());
						}
					}
					temp=temp*3;
					stack.push(Integer.toString(temp));
				}
			}
		}
		int sum=0;
		while(!stack.isEmpty())
			sum+=Integer.parseInt(stack.pop());
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		char[] gwalho = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			gwalho[i] = s.charAt(i);
		}

		if (!gwalhocheck(gwalho)) // 괄호 짝이 안맞으면 0
			System.out.println(0);
		else
			System.out.println(cal(gwalho));

		in.close();
	}

}
