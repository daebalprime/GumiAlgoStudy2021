import java.io.*;
import java.util.*;

public class Main{
	static int N, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		answer = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int j = 0; j < N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0,0,new boolean[N]);
		System.out.println(answer);
		
	}
	static void combi(int start, int cnt, boolean[] pick) {
		if(cnt == N/2) {
			calc(pick);
			return;
		}
		for(int i = start; i < N; i++) {
			pick[i] = true;
			combi(i+1, cnt+1, pick);
			pick[i] = false;
		}
	}
	
	static void calc(boolean[] picks) {
		int[] A = new int[N/2];
		int[] B = new int[N/2];
		int iA = 0;
		int iB = 0;
		int scoreA = 0;
		int scoreB = 0;
		
		for(int i = 0; i < N; i++) {
			if(picks[i]) {
				A[iA++] = i;
			}
			else {
				B[iB++] = i;
			}
		}
		for(int i = 0; i < N/2-1; i++) {
			for(int j = i; j < N/2; j++) {
				int a1 = A[i], a2 = A[j], b1 = B[i], b2 = B[j];
				scoreA +=(map[a1][a2] + map[a2][a1]);
				scoreB +=(map[b1][b2] + map[b2][b1]);
			}
		}
		answer = Math.min(answer, Math.abs(scoreA-scoreB));
	}
}
