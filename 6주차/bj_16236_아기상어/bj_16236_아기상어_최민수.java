package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

//[골드 4] 아기 상어
//https://www.acmicpc.net/problem/16236
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16236_아기상어_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16236"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//공간의 크기 n 2~20
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] visited = new int[n][n];
		int[] fishSize = new int[7]; //1~6 크기의 물고기 숫자, 0은 생략
		int sharkX = 0, sharkY = 0; //상어 위치
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				//아이디어 1.
				//입력을 받을 떄 물고기 사이즈별로 배열을 만들어서 각 물고기 숫자 저장하기
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					if(map[i][j] != 9) { //물고기다
						fishSize[map[i][j]]++;
					}else { //상어다
						sharkX = i;
						sharkY = j;
					}
				}
			}
		}
		//입력 끝
		
		//아기 상어의 크기는 2
		//자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
		//자신의 크기보다 작은 물고기만 먹을 수 있다
		
		//더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
		//먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
		//먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
		//  거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
		//  거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기
		//    그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다
		
		//아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
		
		//아이디어 1.
		//입력을 받을 떄 물고기 사이즈별로 배열을 만들어서 각 물고기 숫자 저장하기
		
		//탐색
		//아기 상어가 자기보다 크기가 작은 물고기가 있는지 물고기 사이즈 배열에 물어봄
		//있으면 먹으러 이동시작, 없으면 엄마 호출
		
		//이동
		//장애물이 없다면 물고기 좌표-상어좌표하면 이동거리 나옴
		//장애물이 있다면? BFS나 DFS로 거리를 찾는다?
		
		//식사 후
		//fishSize에서 한마리 제거
		//크기가 커지는지 판정
		//다시 탐색 단계로
		
		//====================================================================
		
		//탐색
		//아기 상어가 자기보다 크기가 작은 물고기가 있는지 물고기 사이즈 배열에 물어봄
		//있으면 먹으러 이동시작, 없으면 엄마 호출
		int sharkSize = 2;
		int sharkSizeCount = 0;
		int time = 0;
		
		boolean endFlag = false;
		while (true) {
			endFlag = true;
			//자기보다 작은 물고기만 먹을 수 있으니까 -1
			for (int k = sharkSize - 1; k >= 0; k--) {
				if(k > 6) k = 6; //ArrayIndexOutOfBoundsException
				if(fishSize[k] > 0) {
					endFlag = false; //한마리라도 먹을게 있으면 종료 ㄴㄴ
					break;
				}
			}
			if(endFlag) break; //단 한마리도 먹을게 없다.

			//전역변수 초기화
			canEat = false;
			shortest = Integer.MAX_VALUE;
			fishX = 0;
			fishY = 0;

			//visited 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = 0;
				}
				
			}
			
			//이동
			//장애물이 있다면? BFS나 DFS로 거리를 찾는다?
			findFish(map, visited, sharkSize, sharkX, sharkY);
			
			//가는 길이 장애물에 모조리 막혀있으면 엄마 호출.
			if(!canEat) break;
			
			//식사
//    		for(int[] kk : map)System.out.println(Arrays.toString(kk));
//			System.out.println("위에가 식사전 상태");
//			System.out.println(fishX+", "+fishY+": "+shortest+" size:"+sharkSize);
			time += shortest;
			//크기가 커지는지 판정
			sharkSizeCount++;
			if(sharkSize == sharkSizeCount) {
				sharkSize++;
				sharkSizeCount = 0;
			}
			//fishSize에서 한마리 제거
			fishSize[map[fishX][fishY]]--;
			//map에서 해당 물고기 제거
			map[fishX][fishY] = 0;
			//원래 상어있던 자리 0으로 바꿔주기
			map[sharkX][sharkY] = 0;
			//shark위치 이동
			sharkX = fishX;
			sharkY = fishY;
			map[sharkX][sharkY] = 9;
			//다시 탐색 단계로
		}
		
		
		System.out.println(time);
	
		br.close();
	}

	//북동남서
	static int[] delX = {-1, 0, 1, 0};
	static int[] delY = {0, 1, 0, -1};
	
	//현재까지의 최소 거리, 그리고 그 물고기의 위치
	static int shortest = Integer.MAX_VALUE;
	static int fishX = 0;
	static int fishY = 0;
	
	//물고기를 어떻게든 먹을 수 있는가
	static boolean canEat = false;
	
	//bfs용 큐
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	
	private static void findFish(int[][] map, int[][] visited, int sharkSize, int sharkX, int sharkY) {
		//q초기화
		q.clear();
		q.add(sharkX);
		q.add(sharkY);
		visited[sharkX][sharkY] = 0;
		while(!q.isEmpty()) {
			sharkX = q.poll();
			sharkY = q.poll();
			for (int i = 0; i < 4; i++) {
				int movX = sharkX + delX[i];
				int movY = sharkY + delY[i];
				
				//이동가능한지 체크(이동은 물고기랑 크기 같아도 가능)
				if(movX < 0 || movX >= map.length || movY < 0 || movY >= map.length || map[movX][movY] > sharkSize) continue;
				//방문했는지 체크
				if(visited[movX][movY] >= 1) continue;
				q.add(movX);
				q.add(movY);
				visited[movX][movY] = visited[sharkX][sharkY] + 1;
			}
			
			//가지치기: 현재까지의 최소 거리보다 count가 길면 컷
			if(visited[sharkX][sharkY] > shortest) return;
	
			//상어가 10보다 커지는 경우 자기를 먹으려고 함	!= 9	
			//기저조건: 먹을 수 있는 물고기 만났다.
			if(map[sharkX][sharkY] > 0 && map[sharkX][sharkY] < sharkSize && map[sharkX][sharkY] != 9) {
				canEat = true;
				//거리가 가장 가까운지
				if(visited[sharkX][sharkY] < shortest) {
					shortest = visited[sharkX][sharkY];
					fishX = sharkX;
					fishY = sharkY;
				}else if(visited[sharkX][sharkY] == shortest) {
					//  거리가 같다면 가장 위에 있는지
					if(sharkX < fishX) {
						fishX = sharkX;
						fishY = sharkY;
					}else if(sharkX == fishX) {
						//    가장 위라면 가장 왼쪽에 있는지 판정
						if(sharkY < fishY) {
							fishX = sharkX;
							fishY = sharkY;
						}
					}
				}
			}
			for(int[] kk : visited)System.out.println(Arrays.toString(kk));
			System.out.println();
		}
		
		/* dfs code
		 
		
		//가지치기: 현재까지의 최소 거리보다 count가 길면 컷
		if(count > shortest) return;
		
		//상어가 10보다 커지는 경우 자기를 먹으려고 함		
		//기저조건: 먹을 수 있는 물고기 만났다.
		if(map[sharkX][sharkY] > 0 && map[sharkX][sharkY] < sharkSize && map[sharkX][sharkY] != 9) {
			canEat = true;
			//거리가 가장 가까운지
			if(count < shortest) {
				shortest = count;
				fishX = sharkX;
				fishY = sharkY;
			}else if(count == shortest) {
				//  거리가 같다면 가장 위에 있는지
				if(sharkX < fishX) {
					fishX = sharkX;
					fishY = sharkY;
				}else if(sharkX == fishX) {
					//    가장 위라면 가장 왼쪽에 있는지 판정
					if(sharkY < fishY) {
						fishX = sharkX;
						fishY = sharkY;
					}
				}
			}
			return;
		}
		
		
		int movX = 0, movY = 0;
		
		for (int i = 0; i < 4; i++) {
			movX = sharkX + delX[i];
			movY = sharkY + delY[i];
			
			//이동가능한지 체크(이동은 물고기랑 크기 같아도 가능)
			if(movX < 0 || movX >= map.length || movY < 0 || movY >= map.length || map[movX][movY] > sharkSize) continue;
			//방문했는지 체크
			if(visited[movX][movY] == 1) continue;
			
			//방문 확인
			visited[movX][movY] = 1;
			//재귀
			findFish(map, visited, sharkSize, movX, movY, count+1);
			//방문 취소
			visited[movX][movY] = 0;
		}
		
		 */
	}
}

//1. DFS 시간초과
//2. BFS 메모리초과
//3. BFS 가지치기: 통과