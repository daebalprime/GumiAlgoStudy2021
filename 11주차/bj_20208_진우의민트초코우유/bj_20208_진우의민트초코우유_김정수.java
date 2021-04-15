// 순열
// 0:36

import java.io.*;
import java.util.*;
public class b20208 {

	static int N, M, H;
	static List<int[]> milk;
	static int[][] board;
	static int[] initPos;
	static int maxMilk;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		milk = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == 1) {
					initPos= new int[] {i, j};
				}
				else if(board[i][j] == 2) {
					milk.add(new int[] {i, j});
				}
			}
		}
		
		maxMilk = 0;
		
		perm(initPos[0], initPos[1], M, 0, 0); // 초기 위치, 초기 체력, 플래그, 먹은 우유 개수
		
		System.out.println(maxMilk);
	}

	public static void perm(int r, int c, int health, int flag, int cnt) {
		//System.out.println(Integer.toBinaryString(flag));
		
		// 현재 위치에서 집에 돌아갈 수 있는 경우 우유 개수 카운트
		if(isAvailable(r, c, initPos[0], initPos[1], health)>=0) {
			maxMilk = Math.max(maxMilk, cnt);
		}
		
		// 기저조건: 플래그가 1로 다 채워졌을 경우
		if(flag == Math.pow(2, milk.size())-1) {
			return;
		}
		
		// 가지치기: 체력 다됐을 경우
		if(health == 0) {
			return;
		}
		
		// 순열 만들기
		for(int i=0;i<milk.size();i++) {
			if((flag&1<<i)!= 0) continue;
			
			// 선택 위치로 갈 수 있을 만큼의 체력이 남은 경우 이동
			int d = isAvailable(r, c, milk.get(i)[0], milk.get(i)[1], health);
			
			if(d >= 0) {
				perm(milk.get(i)[0], milk.get(i)[1], health+H-d, flag|1<<i, cnt+1);
			}
		}
	}
	
	public static int isAvailable(int r1, int c1, int r2, int c2, int health) {
		int dist = Math.abs(r1 - r2) + Math.abs(c1 - c2);
		
		if(dist > health) {
			return -1;
		}
		return dist;
	}
}
