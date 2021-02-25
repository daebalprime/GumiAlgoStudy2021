import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

	

public class bj_4949_서권우 {
	public static void main(String[] args) throws IOException {
		// 출력문 만들기
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		String s;
		// 라인을 받고 문장끝에 .이 있을경우 다음줄로 이동
		while(true) {
			Stack<String> stack = new Stack<>();
//			s = sc.nextLine();
			s = br.readLine();
			
			if(s.equals(".")) {
				break;
			}
			String[] input = s.split(""); // 입력값 쪼개기
//			System.out.println(Arrays.toString(input));
			for (String str : input) {
				if(str.equals("(") || str.equals("[")) stack.push(str);
				else if(str.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) {
					stack.pop();
				}
				else if(str.equals("]") && !stack.isEmpty() && stack.peek().equals("[")) {
					stack.pop();
				}
				else if(str.equals(")") || str.equals("]")) {
					stack.push(str);
				}
			}
			if(stack.empty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
