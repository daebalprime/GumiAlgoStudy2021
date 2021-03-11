import java.util.*;
import java.io.*;

public class Main {
	static int n, m, orderN;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	map = new int[n][m];
    	Dice dice = new Dice(stoi(stk.nextToken()), stoi(stk.nextToken()));
    	orderN = stoi(stk.nextToken());
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = stoi(stk.nextToken());
    		}
    	}
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < orderN; i++) {
    		switch(stoi(stk.nextToken())) {
    			case 1:
    				dice.east();
    				break;
    			case 2:
    				dice.west();
    				break;
    			case 3:
    				dice.north();
    				break;
    			case 4:
    				dice.south();
    				break;
    		}
    	}
    	
    	br.close();
	}
	public static class Dice{
		int x, y;
		int u, d, f, b, r, l, tmp;	// 옆에서 부터 상, 하, 앞, 뒤, 우, 좌
		Dice(int y, int x){
			this.y = y;
			this.x = x;
			u = 0; d = 0; f = 0; b = 0; r = 0; l = 0;
		}
		void east() {
			if(!isInMap(0,1))
				return;
			x += 1;
			tmp = r;
			r = u;
			u = l;
			l = d;
			d = tmp;
			chkZero();
		}
		void west() {
			if(!isInMap(0,-1))
				return;
			x += -1;
			tmp = l;
			l = u;
			u = r;
			r = d;
			d = tmp;
			chkZero();
		}
		void north() {
			if(!isInMap(-1,0))
				return;
			y += -1;
			tmp = u;
			u = f;
			f = d;
			d = b;
			b = tmp;
			chkZero();
		}
		void south() {
			if(!isInMap(1,0))
				return;
			y += 1;
			tmp = u;
			u = b;
			b = d;
			d = f;
			f = tmp;
			chkZero();
		}
		void chkZero() {
			System.out.println(u);
			// 칸에 쓰여 있는 수가 0
			if(map[y][x] == 0) {
				map[y][x] = d;
			}
			// 0이 아닌 경우
			else {
				d = map[y][x];
				map[y][x] = 0;
			}
		}
		// 칸 범위 밖으로 나가지 않는지 확인
		boolean isInMap(int yy, int xx) {
			if(y + yy < 0 || y + yy == n || x + xx < 0 || x + xx == m)
				return false;
			return true;
		}
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}