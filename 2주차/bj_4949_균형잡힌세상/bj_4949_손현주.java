package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_4949_������ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		// ��ȣ �˻�� ���� ����
		Stack<Character> st = new Stack<Character>();

		while (true) {
			// �� ���� �޾Ƶ��δ�.
			String values = br.readLine();
			// ù���� ���ڰ� . �̰� ���ڱ��̰� 1�̸� �Է��� �����Ѵ�.
			if (values.charAt(0) == '.' && values.length() == 1)
				break;
			// ���ڸ� �˻��Ѵ�.
			for (int i = 0; i < values.length(); ++i) {
				char ch = values.charAt(i);
				if (ch == '(') {
					st.push(')');
				} else if (ch == '[') {
					st.push(']');
				} else if (!st.isEmpty()) {
					if (ch == ')') {
						if (st.peek() == ')') //peek �˰ԵǾ ����! 0204
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
