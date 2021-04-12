package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[골드 5] 파이프 옮기기 1
//https://www.acmicpc.net/problem/17070
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_17070_파이프옮기기1_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_17070"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지
		//회전은 45도만 회전
		//파이프가 벽을 긁으면 안 된다. 즉, 파이프는 항상 빈 칸만 차지
		
		//이동시킬 수 없는 경우에는 0을 출력
		//파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수
		//방법의 수는 항상 1,000,000보다 작거나 같다.
		
		//끝점에서 거꾸로 dp?
		//끝점에 도달할 수 있는 경우의 수 3가지
		
		//집의 크기 n = 3~16
		int n = Integer.parseInt(br.readLine());
		int map[][][] = new int[n][n][4]; //[0]:실제 값 1: -, 2: \, 3: |
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j][0] = -Integer.parseInt(st.nextToken()); //벽은 -1로 저장할 것이다.
			}
		}
		//각 칸마다 값 3가지를 저장할 것, 방법 1, 2, 3으로 해당 위치에 도달할 수 있는 가짓수 저장
		//따라서 해당 방법으로 해당 위치에 접근할 때 깂이 1이상이면 방문하지 않고 그 값만 가져옴

		//상태 1: -, 2: \, 3: |
		dfs(map, 0, 1, 1);
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j][1] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j][2] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j][3] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(map[0][1][1] + map[0][1][2] + map[0][1][3]);
		
		br.close();
	}

	private static void dfs(int[][][] map, int x, int y, int state) {
		if(x == map.length-1 && y == map.length-1) {
			map[x][y][state] = 1;
			return;
		}
		
		//다음에 방문할 후보 찾기
		//관련 요인: 자신의 이전 상태, 다음 방문 후보지가 공간이 비어있는지
		
		//1: -, 2: \, 3: |
		//state가 1이면 1, 2 가능, 2면 1, 2, 3가능, 3이면, 2, 3가능
		if(state == 1) {
			//방문 가능한지 체크
			checkOne(map, x, y, state);
			checkTwo(map, x, y, state);
		}else if(state == 2) {
			checkOne(map, x, y, state);
			checkTwo(map, x, y, state);
			checkThree(map, x, y, state);
		}else if(state == 3) {
			checkTwo(map, x, y, state);
			checkThree(map, x, y, state);
		}
		
	}

	private static void checkOne(int[][][] map, int x, int y, int state) {
		//범위초과
		if(y+1 >= map.length) return; 
		//벽
		if(map[x][y+1][0] == -1) return;
		//이미 방문 했는지
		if(map[x][y+1][1] >= 1) {
			map[x][y][state] += map[x][y+1][1];
			return; 
		}else {
			//방문 한적도 없다.
			dfs(map, x, y+1, 1);
			//방문한 뒤에 타고 올라오면서 갱신
			map[x][y][state] += map[x][y+1][1];
			return;
		}
		
	}
	
	private static void checkTwo(int[][][] map, int x, int y, int state) {
		//범위초과
		if(y+1 >= map.length || x+1 >= map.length) return; 
		//벽이 있는지
		if(map[x][y+1][0] == -1 || map[x+1][y+1][0] == -1 || map[x+1][y][0] == -1 ) return;
		//이미 방문 했는지
		if(map[x+1][y+1][2] >= 1) {
			map[x][y][state] += map[x+1][y+1][2];
			return; 
		}else {
			//방문 한적도 없다.
			dfs(map, x+1, y+1, 2);
			//방문한 뒤에 타고 올라오면서 갱신
			map[x][y][state] += map[x+1][y+1][2];
			return;
		}
		
	}
	private static void checkThree(int[][][] map, int x, int y, int state) {
		//범위초과
		if(x+1 >= map.length) return; 
		//벽이 있는지
		if(map[x+1][y][0] == -1 ) return;
		//이미 방문 했는지
		if(map[x+1][y][3] >= 1) {
			map[x][y][state] += map[x+1][y][3];
			return; 
		}else {
			//방문 한적도 없다.
			dfs(map, x+1, y, 3);
			//방문한 뒤에 타고 올라오면서 갱신
			map[x][y][state] += map[x+1][y][3];
			return;
		}
		
	}
}
