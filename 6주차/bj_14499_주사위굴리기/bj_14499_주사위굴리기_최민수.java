package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드5] 주사위 굴리기
//https://www.acmicpc.net/problem/14499
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_14499_주사위굴리기_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_14499"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//세로 N, 가로 M, 1~20, 주사위를 놓은 좌표 x, y, 명령의 개수 k 1~1000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //0~9
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int move[] = new int[k];
		//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		//1씩 빼서 0~3으로 만들것임.
		int[] delX = {0, 0, -1, 1};
		int[] delY = {1, -1, 0, 0};
		for (int i = 0; i < k; i++) {
			move[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		//입력 끝
		
		//지도의 바깥으로 이동시키려고 하는 경우 해당 명령을 무시, 출력도 하면 안 된다.
		//이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력
		//가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
		
		//아이디어 2. 한칸이동할때마다 주사위 위치별로 값을 갱신해준다
		//예를 들어 밑면이 0이였는데 동쪽으로 구르면 밑면을 2로 갱신
		//동남서북별로 함수를 4개를 만들거나, 1개를 잘 코딩한다면?
		//0은 아랫면, 1은 중북, 2는 중동, 3은 중남, 4는 중서, 5는 윗면
		int dice[] = new int[6];
		int diceClone[] = new int[6]; //계산을 편하게 하기 위한 것

		//굴리기
		int count = 0;
		while(count < k) {
			//이번에 주사위가 옮겨질 곳
			int movX = x + delX[move[count]];
			int movY = y + delY[move[count]];
			//정상 이동 가능한지 체크
			boolean canMove = true;
			
			////지도의 바깥으로 이동시키려고 하는 경우
			if(movX < 0 || movX >= n || movY < 0 || movY >= m) {
				canMove = false;
			}else { //이제 주사위 굴린다.
				roll(dice, diceClone, move[count]);
				//1. 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 
				if(map[movX][movY] == 0) {
					//   주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
					map[movX][movY] = dice[0];					
				}else { //2. 0이 아닌 경우
					//   칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
					dice[0] = map[movX][movY];
					map[movX][movY] = 0;
				}
				System.out.println(dice[5]);
				canMove = true;
			}

			//정상 이동되었으면 x, y 변경
			if(canMove) {
				x = movX;
				y = movY;
			}
//			System.out.println(Arrays.toString(dice));
			count++;
		}
		br.close();
	}


	//방향 i: 동서북남 0123
	//0은 아랫면, 1은 중북, 2는 중동, 3은 중남, 4는 중서, 5는 윗면
	private static void roll(int[] dice, int[] diceClone, int i) {
		switch (i) {
		case 0://동쪽
			diceClone[0] = dice[2];
			diceClone[1] = dice[1];
			diceClone[2] = dice[5];
			diceClone[3] = dice[3];
			diceClone[4] = dice[0];
			diceClone[5] = dice[4];
			break;
		case 1://서쪽
			diceClone[0] = dice[4];
			diceClone[1] = dice[1];
			diceClone[2] = dice[0];
			diceClone[3] = dice[3];
			diceClone[4] = dice[5];
			diceClone[5] = dice[2];
			break;
		case 2://북쪽
			diceClone[0] = dice[1];
			diceClone[1] = dice[5];
			diceClone[2] = dice[2];
			diceClone[3] = dice[0];
			diceClone[4] = dice[4];
			diceClone[5] = dice[3];
			break;
		case 3://남쪽
			diceClone[0] = dice[3];
			diceClone[1] = dice[0];
			diceClone[2] = dice[2];
			diceClone[3] = dice[5];
			diceClone[4] = dice[4];
			diceClone[5] = dice[1];
			break;
		}
		//1차원 배열 깊은 복사
		//이게 왜 동작 잘 안할까
//		dice = diceClone.clone();
//		dice = Arrays.copyOf(diceClone, diceClone.length);
		for (int j = 0; j < diceClone.length; j++) {
			dice[j] = diceClone[j];
		}
	}
}

//폐기 아이디어 1. 이유: 이건 값이 변한다. 예를 들어 동동남남하면 순서가 바뀜.
////각 주사위의 밑면에 대해 0~3인 동서북남 위치를 기록해둔다. = 다음 밑면
////주사위 눈 값(1~6짜리면 7) - 현재 밑면 = 출력해야하는 윗면
//int[][] dice = {
//		//주사위의 눈은 0~5로 이루어져있다
//		{2, 3, 1, 4}, //0번이 밑면이면, 앞면은 5
//		{2, 3, 1, 4}, //1번이 밑면이면, 앞면은 4
//		{2, 3, 1, 4}, //2번이 밑면이면, 앞면은 3
//		{2, 3, 1, 4}, //3번이 밑면이면, 앞면은 2
//		{2, 3, 1, 4}, //4번이 밑면이면, 앞면은 1
//		{3, 4, 2, 5}  //5번이 밑면이면, 앞면은 0
//};