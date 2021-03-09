package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b14499 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int x = stoi(st.nextToken());
		int y = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		
		int [][] board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = stoi(st.nextToken());
			}
		}
		int[] dice = new int[6];
		int[][] direction = {{0, 1}, {0,-1},{-1, 0}, {1, 0}}; // 동 서 북 남
		// 아랫면 index: 5 상단값 index: 0
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<K;i++) {
			int command = stoi(st.nextToken());
			
			int newX = x + direction[command-1][0];
			int newY = y + direction[command-1][1];
			
			if(0<=newX&&newX<N && 0<=newY&&newY<M) {
				rollDice(command, dice); // 주사위 굴리기
				// 값 복사하기
				if(board[newX][newY] == 0) {
					board[newX][newY] = dice[5];
				}
				else {
					dice[5] = board[newX][newY];
					board[newX][newY] = 0;
				}
				x = newX;
				y = newY;
				System.out.println(dice[0]);
			}
		}
	}
	
	static void rollDice(int dir, int[]dice) {
		if(dir == 1) {
			// 동쪽으로 굴리기
			// 0->2->5->3
			int temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		}
		else if(dir == 2) {
			// 서쪽으로 굴리기
			// 0->3->5->2
			int temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		}
		else if(dir == 3) {
			// 북쪽으로 굴리기
			// 0->1->5->4
			int temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		}
		else if(dir == 4) {
			// 남쪽으로 굴리기
			// 0->4->5->1
			int temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
