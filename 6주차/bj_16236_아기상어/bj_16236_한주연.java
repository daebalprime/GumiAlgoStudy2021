/*
16236번 - 아기상어
https://www.acmicpc.net/problem/16236
1. 상어의 초기 크기는 2
2. 자신의 크기와 같은 물고기 개수를 먹으면 크기 증가 2 : 2마리  -> 3
3. 자신보다 더 작은 제일 가까운 물고기를 먹으러간다
4. 가까운게 여러마리면 가장 [위,왼쪽]을 먹는다
5. 자신보다 큰 물고기가 있는 칸은 지나갈수 없다
6. 더 이상 먹을 수 있는 물고기가 없으면 종료한다.
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result, size = 2;
	static int[][] map;
	static boolean[][] mapInfish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	map = new int[n][n];
    	mapInfish = new boolean[n][n];
    	ArrayList<Pair> fish = new ArrayList<Pair>();
    	int y = -1,x = -1;
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = stoi(stk.nextToken());
    		
    			if(map[i][j] == 9) {	// 상어의 위치
    				y = i;
    				x = j;
    			}
    			if(map[i][j] != 0 && map[i][j] < size) {	// 현재 상어 크기보다 작은 물고기를 저장
    				fish.add(new Pair(i,j));
    				mapInfish[i][j] = true;				// 앞으로 잡아 먹을 물고기 표시
    			}
    		}
    	}
    	int dis = Integer.MAX_VALUE, eatCnt = 0, idx = -1;
    	boolean isCatch = false;
    	Pair eatF = new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
    	// 자신보다 더 작은 물고기들의 개수를 하나씩 잡아먹는다
    	while(!fish.isEmpty()) {
    		dis = Integer.MAX_VALUE;
    		isCatch = false;
    		
    		for(int i = 0; i < fish.size(); i++) {
    			int bfsRst = BFS(fish.get(i), y, x, new boolean[n][n]);
    			if(bfsRst == -1) {		// 먹을 수 없는 물고기의 위치(더 큰 물고기에 막혀서 못가는 경우)
    				mapInfish[fish.get(i).y][fish.get(i).x] = false;	// 이 물고기는 못먹으므로 표시에서 지운다
    				fish.remove(i);				// 잡아먹을 물고기 대기열에서 제외
    				i--;
    			}
    			else {
    				if(bfsRst < dis) {		// 현재 상어 위치에서 더 가까운 물고기 발견
    					eatF = fish.get(i);
    					dis = bfsRst;
    					idx = i;
    					isCatch = true;
    				}
    				// 거리가 같다면 더 위에 있는 물고기
    				else if(bfsRst == dis && fish.get(i).y < eatF.y) {
    					eatF = fish.get(i);
    					idx = i;
    				}
    				// 거리가 같고, 높이가 같으면 제일 왼쪽에 있는 물고기
    				else if(bfsRst == dis && fish.get(i).y == eatF.y && fish.get(i).x < eatF.x) {
    					eatF = fish.get(i);
    					idx = i;
    				}
    			}
    		}
    		if(isCatch) {	// 물고기를 먹었으면
	    		map[y][x] = 0;	// 상어 위치를 옮긴다.
	    		y = eatF.y;
	    		x = eatF.x;
	    		eatCnt++;
	    		result += dis;
	    		map[y][x] = 9;		// 상어를 옮긴다.
	    		mapInfish[y][x] = false;	// 물고기를 먹음
	    		if(!fish.isEmpty())			// 물고기를 먹음
	    			fish.remove(idx);
    		}
    		if(eatCnt == size) {		// 상어 크기 만큼 물고기를 잡아 먹었으면
    			size++;
    			eatCnt = 0;
    			// 사이즈가 커졌으므로 또 자기보다 작은 물고기들을 추가한다.
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < n; j++) {
    					if(map[i][j] != 0 && map[i][j] < size && !mapInfish[y][x]) {	// 이미 먹으려고 표시한 물고기 외에, 새로운 작은 물고기 발견
    	    				fish.add(new Pair(i,j));
    	    			}
    				}
    			}
    		}
    	}
    	System.out.println(result);
    	br.close();
	}
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	// 아기상어와 생선의 거리를 구한다
	static int BFS(Pair p, int y, int x, boolean[][] vis) {
		int dis = 0, cnt = 0, newCnt = 0, ny, nx;
		boolean isFind = false;
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i < 4; i++) {	// 처음 상어 위치에서 상,하,좌,우 갈수 있는 곳 등록
			if(Isin(y + dy[i],x + dx[i]) && map[y + dy[i]][x + dx[i]] <= size) {
				q.add(new Pair(y + dy[i], x + dx[i]));
				vis[y + dy[i]][x + dx[i]] = true;
				cnt++;
			}
		}
		vis[y][x] = true;
		end : while(!q.isEmpty()) {
			dis++;
			newCnt = 0;
			for(int idx = 0; idx < cnt; idx++) {
				Pair nq = q.poll();				// 갈 수 있는 위치를 하나 가져온다.
				ny = nq.y;
				nx = nq.x;
				// 물고기를 찾았을 때
				if(ny == p.y && nx == p.x) {
					isFind = true;
					break end;
				}
				for(int i = 0; i < 4; i++) {	// 방문 안한 곳 중 상,하,좌,우 탐색
					if(Isin(ny + dy[i],nx + dx[i]) && map[ny + dy[i]][nx + dx[i]] <= size && !vis[ny + dy[i]][nx + dx[i]]) {
						vis[ny + dy[i]][nx + dx[i]] = true;
						q.add(new Pair(ny + dy[i], nx + dx[i]));
						newCnt++;
					}
				}
			}
			cnt = newCnt;
		}
		if(isFind)
			return dis;
		else {
			return -1;
		}
	}
	static boolean Isin(int y, int x) {
		if(y < 0 || y == n || x < 0 || x == n) {
			return false;
		}
		return true;
	}
	static class Pair{
		int y,x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(y).append(", ").append(x).append("]");
			return builder.toString();
		}
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}