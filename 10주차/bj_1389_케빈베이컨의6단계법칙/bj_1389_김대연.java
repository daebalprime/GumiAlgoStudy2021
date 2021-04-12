import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adjMatrix = new int[N][N];
		for(int[] ia : adjMatrix) {
			Arrays.fill(ia, 987654321);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;	
		}
		for(int m = 0; m < N; m++) {
			for(int j = 0; j  < N; j++) {
				if(m==j) continue;
				for(int i = 0; i < N; i++) {
					if(m==i || j==i) continue;
					adjMatrix[j][i] = Math.min(adjMatrix[j][i], adjMatrix[j][m] + adjMatrix[m][i]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int minVertex = 0;
		for(int j = 0; j < N; j++) {
			int kbn = 0;
			for(int i = 0; i < N; i++) {
				if(adjMatrix[j][i] != 987654321) {
					kbn += adjMatrix[j][i];
				}
			}
//			System.out.println(kbn);
			if(kbn < min) {
				min = kbn;
				minVertex = j;
			}else if(kbn == min) {
				minVertex = Math.min(minVertex, j);
			}
		}
		System.out.println(minVertex+1);
		br.close();
	}

}
