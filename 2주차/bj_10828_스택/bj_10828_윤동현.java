import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack();
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			sb.append(str.nextToken());
			switch(sb.toString()) {
				case "push": {
					int num = Integer.parseInt(str.nextToken());
					stack.push(num);
					break;
				}case "pop": {
					System.out.println((stack.isEmpty())?"-1":stack.pop());
					break;
				}case "size": {
					System.out.println(stack.size());
					break;
				}case "empty": {
					System.out.println((stack.isEmpty())?"1":"0");
					break;
				}case "top": {
					System.out.println((stack.empty())?"-1":stack.peek());
					break;
				}
			}
			sb.setLength(0);
		}
		br.close();
	}// end main
}// end class