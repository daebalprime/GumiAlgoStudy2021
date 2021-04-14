package bj_16920;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int remained = 0;
		int[] playersDepth = new int[P];
		int[] playersScore = new int[P];
		List<ArrayList<int[]>> outline = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i < P; i++) {
			outline.add(new ArrayList<>());
		}
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < P; i++) {
			playersDepth[i] = Integer.parseInt(st.nextToken());
		}
		for(int j = 0; j < N; j++) {
			String a = br.readLine();
			for(int i = 0; i < M; i++) {
				if(a.charAt(i) == '#') map[j][i] = 100;
				else if(a.charAt(i) == '.') {
					++remained;
					continue;
				}
				else {
					int p = a.charAt(i) - '0';
					map[j][i] = p;
					outline.get(p-1).add(new int[] {i,j});
					++playersScore[p-1];
				}
			}
		}
		
		
		Queue<int[]> q = new ArrayDeque<>();
		int prevRemained = remained;
		while(remained > 0) {
			for(int i = 0; i < P; i++) {
				ArrayList<int[]> tmp =  outline.get(i);
				while(!outline.get(i).isEmpty()) {
					for(int k = tmp.size()-1; k >= 0; k--) {
						int[] coord = tmp.get(k);
						tmp.remove(k);
						q.offer(new int[] {coord[0], coord[1], 0});
					}
				}
				while(!q.isEmpty()) {
					int[] curr = q.poll();
					int x = curr[0];
					int y = curr[1];
					int depth = curr[2];
					for(int k = 0; k < 4; k++) {
						int nx = x + di[k];
						int ny = y + dj[k];
						if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0) {
							map[ny][nx] = i+1;
							++playersScore[i];
							--remained;
							if(depth+1 == playersDepth[i]) {
								outline.get(i).add(new int[] {nx,ny});
							}else {
								q.offer(new int[] {nx,ny,depth+1});
							}
						}
					}
				}
			}
			if(remained == prevRemained) break;
			prevRemained = remained;
		}
		for(int i = 0; i < P; i++) {
			sb.append(playersScore[i]+" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}

/*
6 5 2
8 1
1....
.###.
..##.
#....
###.#
###2#
-----
15 1
--------------------
// General case
2 3 1
2
1..
...
답 6
2 5 3
2 2 1
1....
..3.2
답 5 4 1
3 9 9
1 1 1 1 1 1 1 1 1
123456789
.#......#
#######..
답 2 1 2 2 2 2 2 4 1
4 10 1
1000000000
1.........
1.........
1.........
1.........
답 40
4 10 4
1000000000 1 100 99999
1#........
#.........
2#.......#
3#......#4
답 1 1 1 1
// 반례1
3 4 4
1 1 1 1
.#..
#..#
1234
답 1 2 4 1
// 반례2
3 4 2
2 1
1...
1..2
....
답 9 3
5 10 4
1 2 1 2
1........2
.....44...
......4...
2.........
....3.....
답 5 21 4 20
5 7 2
4 1
...1...
.......
.......
.......
1....2..
답 32 3
 * */
 