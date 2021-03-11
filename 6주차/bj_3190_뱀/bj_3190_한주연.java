import java.util.*;
import java.io.*;

public class Main {
	static int n, appleN, orderN, time;
	static int[][] map;
	static int[] orderT;
	static char[] order;
	// 우, 하, 좌, 상
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	map = new int[n][n];
    	appleN = stoi(br.readLine());
    	for(int i = 0; i < appleN; i++) {
    		stk = new StringTokenizer(br.readLine());
    		map[stoi(stk.nextToken()) - 1][stoi(stk.nextToken()) - 1] = 2;	// apple
    	}
    	orderN = stoi(br.readLine());
    	order = new char[orderN];
    	orderT = new int[orderN];
    	for(int i = 0; i < orderN; i++) {
    		stk = new StringTokenizer(br.readLine());
    		orderT[i] = stoi(stk.nextToken());
    		order[i] = stk.nextToken().charAt(0);
    	}
    	int y = 0, x = 0, dir = 0, idx = 0;
    	Queue<Pair> snake = new LinkedList<>();
    	map[y][x] = 1;
    	snake.add(new Pair(y,x));
    	while(true) {
    		time++;
    		// 맵 밖으로 나가거나, 자기 자신을 잡아 먹으면 종료
    		if(y + dy[dir] < 0 || y + dy[dir] == n || x + dx[dir] < 0 || x + dx[dir] == n || map[y + dy[dir]][x + dx[dir]] == 1) {
    			break;
    		}
    		y += dy[dir];	// 이동
    		x += dx[dir];
    		snake.add(new Pair(y,x));	// 뱀 머리 추가
    		if(map[y][x] != 2) {		// 만약 사과를 먹지 않았다면, 꼬리를 자른다
    			Pair tail = snake.poll();
    			map[tail.y][tail.x] = 0;
    		}
    		map[y][x] = 1;
    		if(idx < orderN && orderT[idx] == time) {	// 방향 변경
    			if(order[idx] == 'D') {
    				dir = (dir + 1) % 4;
    			}
    			else {
    				dir = (dir - 1 + 4) % 4;
    			}
    			idx++;
    		}
    	}
    	System.out.println(time);
    	br.close();
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