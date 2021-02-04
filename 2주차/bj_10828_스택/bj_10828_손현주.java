package BJ;

import java.util.StringTokenizer;
import java.io.*;

public class bj_10828_손현주 {
	public static int[] stack;
	public static int top = -1;
	
	// empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	public static boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
	public static int Empty() {
		if (isEmpty()) return 1;
		else return 0;
	}
	 // 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static int Top() {
		if (!isEmpty()) return stack[top];
		else return -1;
	}
	// 스택에 들어있는 정수의 개수를 출력한다.
	public static int Size() {
		if (!isEmpty()) return top+1;
		else return 0;
	}
	// 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static int Pop() {
		if(isEmpty()) return -1;
		else return stack[top--];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			switch (st.nextToken()) {
			case "push": // push X: 정수 X를 스택에 넣는 연산이다.
				stack[++top] = Integer.parseInt(st.nextToken());
				break;
			case "top":
				sb.append(Top()).append('\n');
				break;
			case "size": 
				sb.append(Size()).append('\n');
				break;
			case "empty": 
				sb.append(Empty()).append('\n');
				break;
			case "pop": 
				sb.append(Pop()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}
