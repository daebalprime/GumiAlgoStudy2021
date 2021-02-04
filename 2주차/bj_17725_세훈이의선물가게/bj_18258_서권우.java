import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_18258_서권우 {

static int[] q = new int[2000000];	// 명령의 수는 2,000,000을 안넘음 
	
	static int size = 0;	
	static int front = 0;
	static int back = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<>(); 
		
		StringTokenizer st;
		String copy = null;
		String N = br.readLine();
		int n = Integer.parseInt(N);
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()){
			case "push": push(Integer.parseInt(st.nextToken())); break;
			case "pop" : pop(); break;
			case "size" : size(); break;
			case "empty" : empty(); break;
			case "front" : front(); break;
			case "back" : back(); break;
			
			}
		}
		System.out.println(sb);
	}
	
	static void push(int n) {
		q[back] = n;
		back++;
		size++;
	}
	
	static void pop() {
		if(size == 0) {
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[front]).append('\n');	// 맨 앞의 원소를 출력 
			size--;
			front++;	// front가 가리키는 위치 1 증가 
		}
	}
	
	static void size() {
		sb.append(size).append('\n');
	}
	
	static void empty() {
		if(size == 0) {
			sb.append(1).append('\n');
		}
		else sb.append(0).append('\n');
	}
	
	static void front() {
		if(size == 0) { 
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[front]).append('\n');	 // 맨 앞의 원소 출력 
		}
	}
	
	static void back() {
		if(size == 0) {
			sb.append(-1).append('\n');
		}
		else {
			sb.append(q[back - 1]).append('\n');	// 맨 뒤의 원소 출력 
		}
	}
}
		/*
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			swtich(st.nextToken()) {
				case "push" :
					String num = st.nextToken();
					q.offer(num);
					break;
				case "pop" :
				case "" :
				case "" :
				case "" :
				case "" :
					
			}
		}*/
		/*속도 초과
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(st.nextToken().equals("push")) { // 큐에 값 추가
				String num = st.nextToken();
				q.offer(num);
			} else if(st.nextToken().equals("pop")) { // 값 호출후 제거
				if(q.size() == 0) System.out.println("-1");
				else {
					System.out.println(q.poll());
				}
			} else if(st.nextToken().equals("size")) { // 큐에 들어있는 정수의 개수를 출력한다.
				System.out.println(q.size());
			} else if(st.nextToken().equals("empty")) { // 큐가 비어있으면 1, 아니면 0을 출력한다.
				if(q.size() == 0) System.out.println("1");
				else System.out.println(0);
			} else if(st.nextToken().equals("front")) { // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(q.size() == 0) System.out.println("-1");
				else System.out.println(q.peek());
			} else if(st.nextToken().equals("back")) { // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(q.size() == 0) System.out.println("-1");
				else {
					for (int j = 0; j < q.size(); j++) {
						copy = q.poll();
						q.offer(copy);
					}
					System.out.println(copy);
				}
				
			}
		}
	}

}*/
