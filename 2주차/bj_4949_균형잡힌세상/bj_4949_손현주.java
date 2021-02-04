package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_4949_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		// 괄호 검사용 스택 생성
		Stack<Character> st = new Stack<Character>();

		while (true) {
			// 한 줄을 받아들인다.
			String values = br.readLine();
			// 첫번쨰 문자가 . 이고 문자길이가 1이면 입력을 종료한다.
			if (values.charAt(0) == '.' && values.length() == 1)
				break;
			// 문자를 검사한다.
			for (int i = 0; i < values.length(); ++i) {
				char ch = values.charAt(i);
				if (ch == '(') {
					st.push(')');
				} else if (ch == '[') {
					st.push(']');
				} else if (!st.isEmpty()) {
					if (ch == ')') {
						if (st.peek() == ')') //peek 알게되어서 수정! 0204
							st.pop();
					} else if (ch == ']') {
						if (st.peek() == ']')
							st.pop();
					}
				}
			}
			System.out.println(st.isEmpty() ? "yes" : "no");
			st.clear();
		}
	}

}
