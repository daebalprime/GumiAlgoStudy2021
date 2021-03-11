package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b3190 {
	static int APPLE = 1;
	static int SNAKE = 2;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(in.readLine());
		int K = stoi(in.readLine());
		
		int [][] board = new int[N][N];
		//for(int i=0;i<N;i++) Arrays.fill(board[i], -1);
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			board[stoi(st.nextToken())-1][stoi(st.nextToken())-1] = APPLE;
		}
		
		
		int L = stoi(in.readLine());
		Queue<String[]> command = new LinkedList<>();
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			command.offer(new String[] {st.nextToken(), st.nextToken()});
		}
		
		int time = 0;
		// 뱀은 보드에 뱀 길이로 마킹
		int[][] direction = {{-1, 0}, {0, 1},{1, 0},{0, -1}}; // 북 동 남 서
		int headDir = 1; //뱀 방향

		Deque <int[]> snake = new LinkedList<>();
		snake.offer(new int[] {0, 0});
		
		board[0][0] = SNAKE;
		while(true) {
			//System.out.println(time);
			//for(int i=0;i<N;i++) System.out.println(Arrays.toString(board[i]));
			
			// 방향 바꾸는지 확인
			if(!command.isEmpty()) {
				if(time == stoi(command.peek()[0])) {
					String c = command.poll()[1];
					if(c.equals("L")) { // 왼쪽 90도
						headDir = (headDir+3)%4;
					}
					else if(c.equals("D")) { // 오른쪽 90도
						headDir = (headDir+1)%4;
					}
				}
			}
			int[] head = snake.peekFirst();
			int[] tail = snake.peekLast();
			int newR = head[0]+direction[headDir][0];
			int newC = head[1]+direction[headDir][1];
			
			// 게임 오버 1: 새로운 위치가 보드를 벗어날 경우
			if(!(0<=newR && newR<N && 0<=newC && newC <N)) {
				time++;
				break;
			}
			
			// 게임 오버 2: 새로운 위치가 꼬리를 제외한 몸통과 부딪힐 경우
			if(board[newR][newC] == SNAKE) {
				time++;
				break;
			}
			
			// 이동 및 사과 먹기
			snake.addFirst(new int[] {newR, newC});
			if(board[newR][newC] == APPLE) {
				// 냠냠
				K--;
				//System.out.println("냠냠");
				
				
			}
			else {
				// 꼬리 없어지기
				int[] t = snake.pollLast();
				board[t[0]][t[1]] = 0;

			}
			board[newR][newC] = SNAKE;

			time++;

		}
		System.out.println(time);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
