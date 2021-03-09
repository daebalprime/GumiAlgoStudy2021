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
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
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
    		
    			if(map[i][j] == 9) {
    				y = i;
    				x = j;
    			}
    			if(map[i][j] != 0 && map[i][j] < size) {
    				fish.add(new Pair(i,j));
    				mapInfish[i][j] = true;
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
    			if(bfsRst == -1) {
    				mapInfish[fish.get(i).y][fish.get(i).x] = false;
    				fish.remove(i);
    				i--;
    			}
    			else {
    				if(bfsRst < dis) {
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
    		if(isCatch) {
	    		map[y][x] = 0;
	    		y = eatF.y;
	    		x = eatF.x;
	    		eatCnt++;
	    		result += dis;
	    		map[y][x] = 9;		// 물고기를 옮긴다.
	    		mapInfish[y][x] = false;
	    		if(!fish.isEmpty())
	    			fish.remove(idx);
    		}
    		if(eatCnt == size) {
    			size++;
    			eatCnt = 0;
    			// 사이즈가 커졌으므로 또 자기보다 작은 물고기들을 추가한다.
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < n; j++) {
    					if(map[i][j] != 0 && map[i][j] < size && !mapInfish[y][x]) {
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
		for(int i = 0; i < 4; i++) {
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
				Pair nq = q.poll();
				ny = nq.y;
				nx = nq.x;
				// 물고기를 찾았을 때
				if(ny == p.y && nx == p.x) {
					isFind = true;
					break end;
				}
				for(int i = 0; i < 4; i++) {
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