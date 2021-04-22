import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_g4_20040_사이클게임 {

	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
		int res = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(union(a, b)) {res = i+1; break;}
		}
		System.out.println(res);
		br.close();
	}

	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if(aRoot == bRoot) return true;

		parents[bRoot] = aRoot;
		return false;
	}

}