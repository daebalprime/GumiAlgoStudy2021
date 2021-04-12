import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static int[][] map;
	static int N, M;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 100;
		int rx, ry = rx = 0;
		int bx, by = bx = 0;
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = tmp.charAt(j);
				if(c == '#') {
					map[i][j] = 1;
				}
				else if (c=='O') {
					map[i][j] = -1;
				}
				else if (c=='R') {
					rx = j; 
					ry = i;
				}else if(c=='B') {
					bx = j;
					by = i;
				}
			}
		}
		br.close();
		recur(0,-1, new int[] {rx, ry}, new int[] {bx, by} );
		System.out.println(answer == 100? -1 : answer+1);
	}
	static void recur(int cnt, int previous, int[] rp, int[] bp) {
		if(cnt == 10) return;
		for(int i = 0; i < 4; i++) {
			if(cnt >= answer) return;
			if(previous == i) continue;
			int[] nr = new int[] {rp[0],rp[1]};
			int[] nb = new int[] {bp[0],bp[1]};
			boolean hr = false;
			boolean hb = false;
			
			if(i == 0) {
				if(nr[0] >= nb[0]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 1) {
				if(nr[0] <= nb[0]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 2) {
				if(nr[1] >= nb[1]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}
			else if(i == 3) {
				if(nr[1] <= nb[1]) {
					hr = move(nr,nb,i,cnt);
					hb = move(nb,nr,i,cnt);
				}
				else {					
					hb = move(nb,nr,i,cnt);
					hr = move(nr,nb,i,cnt);
				}
			}

			if(hb) continue; // blue hole
			if(hr) {
				answer = Math.min(answer, cnt);
				return;
			}
			recur(cnt+1, i, nr, nb);			
		}
	}
	static boolean move(int[] moving, int[] stop, int ori, int cnt) {
		int nx = moving[0];
		int ny = moving[1];
		int px = stop[0];
		int py = stop[1];
		
		while(true) {
			nx += di[ori];
			ny += dj[ori];
			if(map[ny][nx] == 1 || (ny == py && nx == px)) { // 벽이나 공에 의해 블락
				moving[0] = nx-di[ori];
				moving[1] = ny-dj[ori];
				return false;
			}
			if(map[ny][nx]==-1) { //홀인
				moving[0] = -1;
				moving[1] = -1;
				return true;
			}
		}
	}
}
