import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BOJ_18258_큐2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
				case "push": {
					dq.offer(Integer.parseInt(st.nextToken()));
					break;
				}case "pop": {
					sb.append((dq.isEmpty())?-1:dq.pop()).append("\n");
					break;
				}case "size": {
					sb.append(dq.size()).append("\n");
					break;
				}case "empty": {
					sb.append((dq.isEmpty())?1:0).append("\n");
					break;
				}case "front": {
					sb.append((dq.isEmpty())?-1:dq.peekFirst()).append("\n");
					break;
				}case "back": {
					sb.append((dq.isEmpty())?-1:dq.peekLast()).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
		br.close();
	}// end main
}// end class