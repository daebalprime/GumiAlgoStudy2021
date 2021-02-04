import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_10828_서권우 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>(); // int 스택 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		String[] st = {"push", "pop", "size", "empty", "top"}; // 명령저장
		String T = br.readLine();
		int tc = Integer.parseInt(T);
		for (int i = 0; i < tc; i++) {
			String pro = br.readLine();
			String[] array = pro.split(" ");
			if(pro.contains(st[0])) {
				String pu1 = array[1];
				int pu = Integer.parseInt(pu1);
				stack.push(pu);
			} else if(pro.equals(st[1])) {
				if(stack.isEmpty() == true) {
					System.out.println("-1");
				} else {
					System.out.println(stack.pop());					
				}
			} else if(pro.equals(st[2])) {
				System.out.println(stack.size());
			} else if(pro.equals(st[3])) {
				if(stack.isEmpty() == true) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if(pro.equals(st[4])) {
				if(stack.isEmpty() == true) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
				}
				
			}
		}
//		sc.close();
	}

}
