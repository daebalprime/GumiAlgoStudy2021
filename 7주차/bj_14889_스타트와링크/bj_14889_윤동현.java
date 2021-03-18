import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_14889_스타트와링크 {

	static int[][] stats;
	static boolean[] visited;
	static int[] start,link;
	static int N,min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		stats = new int[N][N];
		visited = new boolean[N];
		start = new int[N];
		link = new int[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0,0);
		System.out.println(min);

		br.close();
	}

	static void perm(int cnt, int com) {
		if(cnt == N/2) {
			int sIdx = 0, lIdx=0;
			for(int i=0; i<N; i++) {
				if(visited[i]) start[sIdx++] = i;
				else link[lIdx++] = i;
			}

			int sSum=0, lSum=0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					sSum += stats[start[i]][start[j]] + stats[start[j]][start[i]];
					lSum += stats[link[i]][link[j]] + stats[link[j]][link[i]];
				}
			}

			min = Math.min(min, Math.abs(sSum-lSum));

			return;
		}
		
		for(int i=com; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm(cnt+1,i+1);
			visited[i] = false;
		}
	}
}