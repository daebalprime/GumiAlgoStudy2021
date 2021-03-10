package BJ;

import java.util.StringTokenizer;
import java.io.*;

public class bj_10828_������ {
	public static int[] stack;
	public static int top = -1;
	
	// empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
	public static boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
	public static int Empty() {
		if (isEmpty()) return 1;
		else return 0;
	}
	 // ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	public static int Top() {
		if (!isEmpty()) return stack[top];
		else return -1;
	}
	// ���ÿ� ����ִ� ������ ������ ����Ѵ�.
	public static int Size() {
		if (!isEmpty()) return top+1;
		else return 0;
	}
	// ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
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
			case "push": // push X: ���� X�� ���ÿ� �ִ� �����̴�.
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
