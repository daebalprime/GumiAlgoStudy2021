import java.io.*;
import java.util.*;

public class Main {
	static int[][] map, steps;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		steps = new int[M][N];
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
				steps[j][i] = -1;
			}
		}
		steps[M-1][N-1] = 1; 
		dfs(0,0);
		System.out.println(steps[0][0]);
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int dfs(int x, int y) {
//		for(int j = 0; j < M; j++) {
//			for(int i = 0; i < N; i++) {
//				if(j==y && i==x) System.out.print("*\t");
//				else System.out.print(steps[j][i]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------");
		if(x < 0 || x >= N || y < 0 || y >= M)return 0;
		if(steps[y][x] != -1) {
			return steps[y][x];
		}
		
		int sum = 0;
		for(int k = 0; k < 4; k++) {
			int nx = x + di[k];
			int ny = y + dj[k];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || 
					map[y][x] <= map[ny][nx])continue;
			int result = dfs(nx,ny);
			sum += result;
			if(steps[y][x]==-1) steps[y][x] = 0;
			steps[y][x] += result; 
		}
		return sum;
	}

}
