package baekjoon_01001_02000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 4] 내리막길
//https://www.acmicpc.net/problem/1520
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_1520_내리막길_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_1520"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//제일 왼쪽 위 지점에서 출발
		//제일 오른쪽 아래 지점까지 항상 내리막길로만 이동
		//경로의 개수
		
		//세로 크기 M, 가로 크기 N 1~500
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		int visited[][] = new int[m][n]; 
		for (int i = 0; i < m; i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[0][0] = 0;
		dfs(map, visited, 0, 0, m, n);
		
//		for(int[] ii : visited)System.out.println(Arrays.toString(ii));
		System.out.println(visited[0][0]);
		
		br.close();
	}

	//상, 우, 하, 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; 
	static int answer;
	
	//그냥 DFS로는 터진다. 따라서 DP 개념을 추가 도입하겠다.
	//dp값으로 해당 위치에서 도달할 수 있는 경로 수를 저장한다.
	
	private static void dfs(int[][] map, int[][] visited, int x, int y, int m, int n) {
		
		
		//기저조건. 오른쪽 아래 도달하면 끝
		if(x == m-1 && y == n-1) {
			visited[x][y] = 1;
			return;			
		}
		
		for (int i = 0; i < 4; i++) {
//			for(int[] ii : visited)System.out.println(Arrays.toString(ii));
//			System.out.println();
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			//배열 범위 밖
			if(cx < 0 || cx >= m || cy < 0 || cy >= n) continue;
			//방문했으면
			if(visited[cx][cy] >= 0) { //내가 5일 때, 8은 continue, 4는 더하기
				if(map[cx][cy] >= map[x][y]) continue; //지금 나보다 값이 크다 = 내가 방문할 수 없는 곳이다.
				else { //내가 방문할 수 있는 곳이다.
					//내 값이 0보다 크면 방문할 곳의 값을 더해준다.
					//그렇지 않으면 -1이라는 뜻이니까, 방문할 곳의 값으로 갱신해준다.
					if(visited[x][y] >= 0) visited[x][y] += visited[cx][cy];
					else visited[x][y] = visited[cx][cy];
				}
				continue;
			}
			//(방문여부 관계 없이) 현재 값보다 크거나 같아도 못감
			if(map[x][y] <= map[cx][cy]) continue;
			
			//이제 방문할꺼임
			visited[cx][cy] = 0; //-1 => 0
			dfs(map, visited, cx, cy, m, n);
			visited[x][y] += visited[cx][cy]; //타고 올라가면서 갱신
		}
	}
}

//1. 16% 시간초과: DFS -> DFS+DP
//참고: https://sihyungyou.github.io/baekjoon-1520