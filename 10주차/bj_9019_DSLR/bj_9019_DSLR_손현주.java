import java.io.*;
import java.util.*;

public class bj_9019_G5 {
	
	static class Register{							// 레지스터 클래스
		public boolean isVisited = false;			// 방문 체크
		public int parent = 0;						// 바꾸기 전의 값 저장
		public char register =' ';					// 레지스터 명령어
		public Register() { }
		public void set(boolean isVisited, int parent, char register) {
			this.isVisited = isVisited;
			this.parent = parent;
			this.register = register;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int max = 10000;						// 맥스 값 
		int T = Integer.parseInt(br.readLine());	// 테케
		for (int tc = 1; tc <= T; ++tc) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Register[] registers = new Register[max];
			for(int i=0;i<max;++i) registers[i] = new Register();
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			registers[A].isVisited = true;
			while (true) {							// bfs로 탐색
				int current = q.poll();
				int D = (2 * current) % max;		
				int S = current == 0 ? max - 1 : current - 1;
				int L = (current * 10 + (current / 1000)) % max;
				int R = 1000 * (current % 10) + current / 10;
				if(!registers[D].isVisited) {		// D명령어 실행
					registers[D].set(true, current, 'D');
					q.add(D);
				}
				if(!registers[S].isVisited) {		// S명령어 실행
					registers[S].set(true, current, 'S');
					q.add(S);
				}
				if(!registers[L].isVisited) {		// L명령어 실행
					registers[L].set(true, current, 'L');
					q.add(L);
				}
				if(!registers[R].isVisited) {		// R명령어 실행
					registers[R].set(true, current, 'R');
					q.add(R);
				}
				if(registers[B].isVisited) {		// 바꾸려는 값을 찾았으면
					int tmp = B;
					while(tmp != A) {				// 처음값이 될때 까지 쭉 올라간다
						sb.append(registers[tmp].register);
						tmp = registers[tmp].parent;
					}								// 역순으로 출력해야 한다. 타겟부터 올라가서.
					bw.write(sb.reverse().append('\n').toString());
					break;
				}
			}
		}
		bw.close();									// 출력
	}
}
