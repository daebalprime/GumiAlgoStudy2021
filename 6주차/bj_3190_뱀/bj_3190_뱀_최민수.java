package baekjoon_03001_04000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 5] 뱀
//https://www.acmicpc.net/problem/3190
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_3190_뱀_최민수 {
	//상우하좌
	static int[] delX = {-1, 0, 1, 0};
	static int[] delY = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_3190"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//사과를 먹으면 뱀 길이가 늘어난다
		//종료 조건: 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
		
		//NxN 정사각 보드위
		
		//게임이 시작할때 뱀은 맨위 맨좌측에 위치
		//뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.
		
		//n: 2~100
		int n = Integer.parseInt(br.readLine());
		//사과: 9, 뱀 몸통: 1, 뱀 머리: 2, 뱀 꼬리: 3
		int[][] map = new int[n][n];
		
		//사과의 개수 K: 0~100
		int k = Integer.parseInt(br.readLine());
		//사과 개수 + 1만큼이 뱀의 최대 길이다.
		//+2를 한것은 overflow 때문에 귀찮아서
		int[][] snake = new int[k+3][2];
		int[][] snakeClone = new int[k+3][2];
		for (int i = 0; i < k; i++) {
			//행, 열 순서대로 주어짐 1, 0 = 1행 0열 = (1, 0)
			//맨 위, 맨 좌측이 1, 1이니까 1빼서 0, 0으로 만들자
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int temX = Integer.parseInt(st.nextToken()) - 1;
			//map에 사과는 9로 표기할 것임
			map[temX][Integer.parseInt(st.nextToken()) - 1] = 9;
		}
		
		//방향 변환 횟수 L: 1~100
		int l = Integer.parseInt(br.readLine());
		//[0]에는 X초가 끝난 뒤에, [1]에는 방향
		String change[][] = new String[l][2];
		for (int i = 0; i < l; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			change[i][0] = st2.nextToken();
			change[i][1] = st2.nextToken();
		}
		
		
		//이동하기
		//1. change[i][0] 시간에 도달할 때까지 움직이기
		//2. 움직이면서 종료조건에 해당하면 종료
		//3. 사과 만나면 길이 늘리기
		//4. 시간에 도달하면 방향 전환하기
		snake[0][0] = 0;
		snake[0][1] = 0;
		int time = 0;
		int changeCheck = 0;
		int length = 1;
		int way = 1; //상우하좌 0123
		//전진할 장소
		int movX = 0, movY =0;
		//현재 머리 위치
		int curX = 0, curY =0;
		//종료 조건
		boolean endFlag = false;
		//사과 먹었냐
		boolean eatApple = false;
		map[0][0] = 2;
		
//		for(int[] i : map)System.out.println(Arrays.toString(i));
//		System.out.println();
		
		while (!endFlag) {
			time++;
			//한 칸 전진하기 전에 내 몸, 벽, 사과인지 확인
			movX = curX + delX[way];
			movY = curY + delY[way];
			if(movX < 0 || movX >= n || movY < 0 || movY >= n) { //벽에 닿으면
				endFlag = true;
				break;
			}else if(map[movX][movY] == 1 || map[movX][movY] == 3) { //몸에 닿으면, 꼬리도 안돼
				endFlag = true;				
				break;
			}else if(map[movX][movY] == 9) {
				eatApple = true;
				length++;
			}
			
			//몸길이 늘리기
			increase(map, snake, snakeClone, curX, curY, movX, movY, eatApple, time, length);
			eatApple = false;
			
			//방향 전환 조건되면 전환하기
			if(changeCheck < l && time == Integer.parseInt(change[changeCheck][0])) {
				//방향 조절(mod연산?)
				if(change[changeCheck][1].equals("L")) {
					if(way == 0) way = 3;
					else way--;
				}else {//D
					if(way == 3) way = 0;
					else way++;
				}
				changeCheck++;
			}

			curX = movX;
			curY = movY;

		}
		
		//출력 8초에 벽에 닿아있고
		//9초에 한칸 이동하면서 죽으니까 9를 출력a
		System.out.println(time);
		
		br.close();
	}

	private static void increase(int[][] map, int[][] snake, int[][] snakeClone, int curX, int curY, int movX, int movY, boolean eatApple, int time, int length) {
		// 머리 1칸 옮기고, 머리자리에 그다음 몸통 옮기고 ~~
		//clone에다가 옮겨서 clone을 덮어씌울 것임.
		
		//뱀 길이가 무조건 1이면(사과 0개)
		if(length == 1) {
			map[movX][movY] = 2;
			map[curX][curY] = 0;
			snake[0][0] = movX;
			snake[0][1] = movY;
			return;
		}
		
		//map: 머리 옮기기
		map[movX][movY] = 2;
		//snakeClone 머리 좌표 조정
		snakeClone[0][0] = movX;
		snakeClone[0][1] = movY;
		int i = 0;
		while(true) {
			i++;
			if(i >= length) return;
			//snake 조정
			snakeClone[i][0] = snake[i-1][0];
			snakeClone[i][1] = snake[i-1][1];
			map[snakeClone[i][0]][snakeClone[i][1]] = 1;
			
			if(i == length-1) { //이번에 옮길게 꼬리다
				if(eatApple) {
					//마지막에 꼬리가 있던 위치
					map[snake[i-1][0]][snake[i-1][1]] = 3;
				}else {
					//원래 3있던데 지우기
					if(map[snake[i][0]][snake[i][1]] != 2)map[snake[i][0]][snake[i][1]] = 0;
					//새로 생긴 꼬리를 1이면 3으로바꾸고
					map[snakeClone[i][0]][snakeClone[i][1]] = 3;
				}
				
				//복사
				for (int j = 0; j < snake.length; j++) {
					for (int j2 = 0; j2 < snake[0].length; j2++) {
						snake[j][j2] = snakeClone[j][j2];
					}
				}
				break;
			}
		}
		
	}
}

//실패 아이디어 1
//뱀꼬리 찾는 과정: 머리부터 꼬리까지 DFS로 찾기
//몸통은 값을 1로 머리랑 꼬리는 1이 아닌 다른 값으로 구분하자
//=> 딱붙은 ㄹ이면 ㅁ으로 인식해서 dfs가 고장난다
