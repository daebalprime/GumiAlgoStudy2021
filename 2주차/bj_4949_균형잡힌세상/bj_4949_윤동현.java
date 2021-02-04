import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


class BOJ_4949_균형잡힌세상 {
	static char parenthesis1 = '(';
	static char parenthesis2 = ')';
	static char bracket1 = '[';
	static char bracket2 = ']';
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			Stack<Character> stack = new Stack<>();
			sb.append(br.readLine());
			if(sb.toString().equals(".")) break;
			boolean isCheck = true;
			for(int i=0; i<sb.length(); i++) {
				if(sb.charAt(i) == parenthesis1 || sb.charAt(i) == bracket1) {
					stack.add(sb.charAt(i));
				}
				if(sb.charAt(i) == parenthesis2) {
					if(stack.isEmpty()) {
						isCheck = false;
						break;
					}else {
						char tmp = stack.pop();
						if(tmp == bracket1) {
							isCheck = false;
							break;
						}
					}
				}
				if(sb.charAt(i) == bracket2) {
					if(stack.isEmpty()) {
						isCheck = false;
						break;
					} else {
						char tmp = stack.pop();
						if(tmp == parenthesis1) {
							isCheck = false;
							break;
						}
					}
				}
			}
			if(!stack.isEmpty()) isCheck = false;
			System.out.println((isCheck)?"yes":"no");
			sb.setLength(0);
		}
		br.close();
	}// end main
}// end class