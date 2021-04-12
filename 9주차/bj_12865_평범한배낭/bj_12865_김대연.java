import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K+1];
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		for(int i = 1 ; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());			
			int V = Integer.parseInt(st.nextToken());
			weight[i] = W;
			value[i] = V;
		}
		
		for(int j = 1; j < N+1; j++) { // v : stuffs
			for(int i = 1; i < K+1; i++) { // i: weight
				int w = weight[j];
				int v = value[j];
				if(i < w) dp[j][i] = dp[j-1][i];
				else dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-w]+v);
			}
		}
		bw.write(Integer.toString(dp[N][K]));
		bw.flush();
		br.close();
		bw.close();
	}

}
