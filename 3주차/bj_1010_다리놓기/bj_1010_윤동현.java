import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class bj_1010_윤동현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] dp = new int[30][30];
		for(int i=0; i<30; i++) {
			//nCr에서 nCn or nC0는 =1
			dp[i][i] = 1;
			dp[i][0] = 1;
		}

		for(int i=2; i<30; i++) {
			for(int j=1; j<30; j++) {
				// n+1_C_r+1 = nCr + nC_r+1
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}

		int T = Integer.parseInt(br.readLine());

		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}