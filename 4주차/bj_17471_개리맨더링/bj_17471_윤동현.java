import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_17471_개리맨더링 {
	
	static int[][] adjMatrix;
	static int[] population, district;
	static int N,res=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		N = Integer.parseInt(br.readLine());

		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) population[i] = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j=1; j<=n; j++) {
				int k = Integer.parseInt(st.nextToken());
				adjMatrix[i][k] = adjMatrix[k][i] = 1;
			}
		}
		district = new int[N+1];
		dfs(1, district);
		System.out.println((res==Integer.MAX_VALUE)?-1:res);
		br.close();
	}

	private static void dfs(int depth, int[] district) {
		if(depth == N+1) {
			int d1 = 0, d2 = 0;
			for(int i=1; i<=N; i++) {
				if(district[i] == 1) d1 += population[i];
				else d2 += population[i];
			}

			boolean[] visited = new boolean[N+1];
			int cnt=0;
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				divideDistrict(i, district, visited);
				cnt++;
			}

			if(cnt == 2) res = Math.min(res, Math.abs(d1-d2));

			return;
		}
		district[depth]=1;
		dfs(depth+1, district);
		district[depth]=2;
		dfs(depth+1, district);
	}

	private static void divideDistrict(int i, int[] district, boolean[] visited) {
		visited[i] = true;
		for(int k=1; k<=N; k++) {
			if(adjMatrix[i][k] != 1 || visited[k] || district[k] != district[i]) continue;
			divideDistrict(k, district, visited);
		}
	}
}