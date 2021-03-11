import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static int[] T, P;
	static int N,max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(max);
		br.close();
	}

	static void dfs(int cnt, int p) {
		if(cnt > N) return;

		if(cnt == N) {
			max = Math.max(max, p);
			return;
		}
		dfs(cnt+T[cnt], p+P[cnt]);
		dfs(cnt+1, p);
	}

}//end class