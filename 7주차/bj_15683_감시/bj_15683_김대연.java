import java.io.*;
import java.util.*;

public class Main {
	static int[][][][] cctvWatching = {
			{{{}},{{}}},
			{{{1},{0},{-1},{0}}, {{0},{1},{0},{-1}}},
			{{{1,-1},{0, 0}}, {{0, 0},{1, -1}}},
			{{{1,0},{-1,0},{-1,0},{1,0}},{{0,-1},{0,-1},{0,1},{0,1}}},
			{{{1,0,-1},{0,-1,0},{-1,0,1},{0,1,0}},{{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}}},
			{{{1,0,-1,0}},{{0,1,0,-1}}}
	};
	
	//[type][x or y][ranges]

	
	static int mark = 7;
	static int blank, cctvCounts = 0;
	static int answer = Integer.MAX_VALUE;
	static int N, M;
	static int[][] cctv, map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blank = N*M;
		cctv = new int[8][3]; // 0 x 1 y 2 type
		cctvCounts = 0;
		
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[j][i]= tmp;
				if(tmp >= 1 && tmp <= 5) {
					cctv[cctvCounts++] = new int[] {i,j,tmp};
				}
				if(tmp != 0) --blank;
			}
		}
		
		recursive(0, new int[cctvCounts]);
		System.out.println(answer);
		
		
		br.close();
	}
	
	static void recursive(int idx, int[] picks) {
		if(idx == cctvCounts) {
			answer = Math.min(remained(picks),answer);
			return;
		}
		int type = cctv[idx][2];
		int comb = cctvWatching[type][0].length;
		for(int i = 0; i < comb; i++) {
			picks[idx] = i;
			recursive(idx+1, picks);
		}
		
	}
	
	static int remained(int[] picks) {
		int ret = blank;
		for(int i = 0; i < cctvCounts; i++) {
			int ori = picks[i];
			int type = cctv[i][2];
			int[] di = cctvWatching[type][0][ori];
			int[] dj = cctvWatching[type][1][ori];
			for(int j = 0; j < di.length; j++) {
				int nx = cctv[i][0], ny = cctv[i][1];
				while(true) {
					ny += dj[j];
					nx += di[j];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx]==6) break;
					if(map[ny][nx] < 1 || map[ny][nx] > 6 && map[ny][nx] != mark) {
						map[ny][nx] = mark;
						ret--;
					}
				}
			}
		}
		
		mark++;
		return ret;
	}

}
