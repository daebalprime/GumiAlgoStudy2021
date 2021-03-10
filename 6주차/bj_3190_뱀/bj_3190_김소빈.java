package bj_gold;

import java.io.*;
import java.util.*;

public class Main_bj_3190_뱀 {
	static int[] dx = {-1, 0, 1, 0}; //시계방향
	static int[] dy = { 0, 1, 0,-1};
	static Deque<int[]> snake = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n]; //1,1부터 주어지므로 x,y값 하나씩 줄일 것
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;//board nXn으로 설정했기 때문에 하나씩 줄임
		}
		
		int L = Integer.parseInt(br.readLine());
		int[] times = new int[10001]; //최대명령 시간 10000초 초를 인덱스로 오른쪽(1)왼쪽(-1)값 넣을 거기때문에 크기 설정 -> 그냥 LX2이차원배열이 더 효율적일듯
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[Integer.parseInt(st.nextToken())] = (st.nextToken().charAt(0)=='D')?1:3; //직관적으로 index초에 방향결정할 수 있도록 작성
		}
		//입력완료
		int cnt = 0;
		int x = 0, y = 0, nx = 0, ny = 0;
		int dir = 1;
		snake.offer(new int[] {x,y});//처음위치 0,0
		
		while(true) {//처음엔 명령이 10000초까지니까 그까지인 for문을 돌렸으나 명령이 더 이상 없다해도 뱀은 가능하다면 전진할 수 있다. -> while로 변경
			cnt++;
			nx = x+dx[dir]; ny = y+dy[dir]; //다음위치
			if (0 <= nx && nx < n && 0 <= ny && ny < n && isSnake(nx, ny)) {//범위안 && 새로운위치가 뱀의 몸통인지 아닌지
				if (board[nx][ny] == 1) { //사과
					snake.offer(new int[] {nx, ny});
					board[nx][ny] = 0; //사과를 먹었으니까 없애야함(중요)
				} else {
					snake.offer(new int[] {nx, ny});
					snake.poll(); //꼬리자르기
				}
				x = nx; y = ny;
			} 
			else{
				break;//범위밖이거나 새로운위치가 뱀인 경우
			}
			
			dir = (dir+times[cnt])%4; //방향전환
		}
		System.out.println(cnt);
	}
	private static boolean isSnake(int nx, int ny) {
		for(int[] part: snake) {
			if(part[0] == nx && part[1] == ny) return false;
		}
		return true;
	}
}
