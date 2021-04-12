package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[골드 5] DSLR
//https://www.acmicpc.net/problem/9019
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_9019_DSLR_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_9019"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			//전역 visited 초기화
			visited = new boolean[10000];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			//bfs
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			bfs(start, end);
			
		}//tc끝
		br.close();
	}
	
	static boolean visited[];

	private static void bfs(int start, int end) {
		ArrayDeque<numberAndOper> q = new ArrayDeque<numberAndOper>();
		
		q.offer(new numberAndOper(start, ""));
		while(!q.isEmpty()) {
			numberAndOper now = q.poll();
			if(visited[now.number]) continue; //방문한적이 있다.
			else visited[now.number] = true; //이제 방문했다.
			
			if(now.number == end) {
				//출력
				System.out.println(now.Oper);
				break;
			}
			
			//q에 연산 4개 결과 넣기
			q.offer(new numberAndOper(D(now.number), now.Oper+"D"));
			q.offer(new numberAndOper(S(now.number), now.Oper+"S"));
			q.offer(new numberAndOper(L(now.number), now.Oper+"L"));
			q.offer(new numberAndOper(R(now.number), now.Oper+"R"));
		}
	}
	//D는 2n mod 10000
	private static int D(int number) {
		return (number * 2) % 10000;
	}

	//S는 n-1, 0이면 9999
	private static int S(int number) {
		if(number == 0) return 9999;
		return number - 1;
	}

	//L이면 <<
	private static int L(int number) {
		int temp = number / 1000;
		return (number % 1000) * 10 + temp;
	}

	//R이면 >>
	private static int R(int number) {
		int temp = number % 10; //1의 자리수				
		return temp * 1000 + (number / 10);
	}

	static class numberAndOper{
		int number;
		String Oper;
		
		public numberAndOper(int number, String oper) {
			super();
			this.number = number;
			Oper = oper;
		}
	}
}
//아이디어 생각 안나서 알고리즘 분류보니까 BFS
//메모리 초과: BFS인데 visited처리 안했음.