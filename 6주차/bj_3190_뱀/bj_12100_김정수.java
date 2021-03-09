package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b12100 {

	static int N;
	static int[][] board;
	static int maxBlock;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxBlock = 0;
		//game2048(in);
		permutation(0, board);
		System.out.println(maxBlock);
	}
	
	// 테스트용 메서드
	static void game2048(BufferedReader in) throws NumberFormatException, IOException {
		while(true) {
			int command = Integer.parseInt(in.readLine());
			if(command == -1) {
				break;
			}
			int[][] newBoard = new int[N][N];
			moveBoard(command, board, newBoard);
			System.out.println("-----------------");
			board = newBoard;
			for(int id=0;id<N;id++) System.out.println(Arrays.toString(newBoard[id]));
			System.out.println("-----------------");
		}
	}
	
	// 중복순열
	static void permutation(int cnt, int[][]gameBoard) {

		// 현재 게임판에서 제일 큰 블록 값 검사
		maxBlock = Math.max(maxBlock, getMaxBlockVal(gameBoard));
		
		if(cnt == 5) {
			return;
		}
		//System.out.println("<"+cnt+">");
		//for(int id=0;id<N;id++) System.out.println(Arrays.toString(gameBoard[id]));

		// 4방향으로 블록 밀어보기
		for(int i=0;i<4;i++) {
			int[][] newBoard = new int[N][N];

			//System.out.println(i);

			moveBoard(i, gameBoard, newBoard);
			
			//for(int id=0;id<N;id++) System.out.println(Arrays.toString(newBoard[id]));

			
			permutation(cnt+1, newBoard);

		}
	}
	
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0},{0, -1}};
	
	static void moveBoard(int dir, int[][]gameBoard, int[][]newBoard) {
		// dir 반대 방향부터 시작해서 2개씩 짝지어 더한 후 newBoard에 쌓기
		
		int[] newBoardNum = new int[N]; //쌓인 높이

		
		if(dir == 0) {
			for(int i=0;i<N;i++) {
				int couple = -1;
				for(int j=0;j<N;j++) {
					if(gameBoard[j][i] != 0) {
						if(couple == -1) {
							couple = gameBoard[j][i];
						}
						else {
							if(couple == gameBoard[j][i]) {
								couple += gameBoard[j][i];
								newBoard[newBoardNum[i]++][i] = couple;
								couple = -1;
							}
							else {
								newBoard[newBoardNum[i]++][i] = couple;
								couple = gameBoard[j][i];
							}
						}
					}
				}
				if(couple != -1) {
					newBoard[newBoardNum[i]++][i] = couple;
				}
			}
		}
		else if(dir == 1) {
			//Stack <Integer> stack = new Stack<>();
			for(int i=0;i<N;i++) {
				int couple = -1;
				for(int j=N-1;j>=0;j--) {
					if(gameBoard[i][j] != 0) {
						if(couple == -1) {
							couple = gameBoard[i][j];
						}
						else {
							if(couple == gameBoard[i][j]) {
								couple += gameBoard[i][j];
								newBoard[i][N-1-newBoardNum[i]++] = couple;
								//stack.push(couple);
								couple = -1;
							}
							else {
								newBoard[i][N-1-newBoardNum[i]++] = couple;
								//stack.push(couple);
								couple = gameBoard[i][j];
							}
						}
					}
				}
				if(couple != -1) {
					//stack.push(couple);
					newBoard[i][N-1-newBoardNum[i]++] = couple;
				}
				//int newIndex = N-1;
				//while(!stack.isEmpty()) {
				//	newBoard[i][newIndex--] = stack.pop();
				//}
			}
			
		}
		else if(dir == 2) {
			Queue <Integer> queue = new LinkedList<>();
			for(int i=N-1;i>=0;i--) {
				int couple = -1;
				for(int j=N-1;j>=0;j--) {
					if(gameBoard[j][i] != 0) {
						if(couple == -1) {
							couple = gameBoard[j][i];
						}
						else {
							if(couple == gameBoard[j][i]) {
								couple += gameBoard[j][i];
								queue.offer(couple);
								couple = -1;
							}
							else {
								queue.offer(couple);
								couple = gameBoard[j][i];
							}
						}
					}
				}
				if(couple != -1) {
					queue.offer(couple);
				}
				int newIndex = N-1;
				while(!queue.isEmpty()) {
					newBoard[newIndex--][i] = queue.poll();
				}
			}
		}
		else {
			for(int i=0;i<N;i++) {
				int couple = -1;
				for(int j=0;j<N;j++) {
					if(gameBoard[i][j] != 0) {
						if(couple == -1) {
							couple = gameBoard[i][j];
						}
						else {
							if(couple == gameBoard[i][j]) {
								couple += gameBoard[i][j];
								newBoard[i][newBoardNum[i]++] = couple;
								couple = -1;
							}
							else {
								newBoard[i][newBoardNum[i]++] = couple;
								couple = gameBoard[i][j];
							}
						}
					}
				}
				if(couple != -1) {
					newBoard[i][newBoardNum[i]++] = couple;
				}
			}
		}
	}
	
	static int getMaxBlockVal(int[][]gameBoard) {
		int maxVal = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				maxVal = Math.max(maxVal, gameBoard[i][j]);
			}
		}
		return maxVal;
	}
	

}
