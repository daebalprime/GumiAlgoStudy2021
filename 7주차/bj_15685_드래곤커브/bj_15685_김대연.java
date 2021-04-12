import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cmd = new int[1024];
		boolean[][] map = new boolean[101][101];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			map[cy][cx] = true;
			int d = Integer.parseInt(st.nextToken());
			int maxGen = Integer.parseInt(st.nextToken());
			int cmdPt = 0;
			cmd[0] = d;
			for(int gen = 0; gen <= maxGen; gen++) {
				for(int c = cmdPt; c >= 0; c--) {
					int nextC = (cmd[c]+1)%4;
					if(gen!=0) {
						cmd[++cmdPt] = nextC;
					}else {
						nextC = cmd[c];
					}
					cx += di[nextC];
					cy += dj[nextC];
					map[cy][cx] = true;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
