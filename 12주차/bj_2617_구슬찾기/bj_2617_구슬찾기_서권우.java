import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2617_구슬찾기_서권우 {
	static int N, M; // 구슬의 개수, 저울에 올려본 쌍의 개수
	static ArrayList<Integer>[] Alist;
	static ArrayList<Integer>[] Blist;
	static int[] high;
	static int[] low;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Alist = new ArrayList[N+1];
		Blist = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			Alist[i] = new ArrayList<>();
			Blist[i] = new ArrayList<>();
		}
		high = new int[N+1];
		low = new int[N+1];
		
		for (int i = 0; i < M; i++) {// x > y
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Alist[x].add(y);
			Blist[y].add(x);
		}
		int cnt = 0;
		int half = (N+1)/2; // 무게가 전체의 중간인 (무게 순서로 (N+1)/2번째) 구슬
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			low[i] = dfs(Alist,i);
			visited = new boolean[N+1];
			high[i] = dfs(Blist,i);
			
			if(low[i] >= half || high[i] >= half) cnt++;
		}
		
		System.out.println(cnt);
		//단순 연산은 런타임에러가 났음.
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
////				System.out.print(Hlink[i][j] + " ");
//				if(Hlink[i][j]>0) check[i]++;
//			}
////			System.out.println();
//		}
////		System.out.println("------------------------");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
////				System.out.print(Llink[i][j] + " ");
//				if(Llink[i][j]>0) check[i]++;
//			}
////			System.out.println();
//		}
//		int res = 0;
//		for (int i = 1; i <= N; i++) {
////			System.out.println(check[i]);
//			if(check[i]<2) res++;
//		}
//		System.out.println(res);
		
		br.close();
	}
	private static int dfs(ArrayList<Integer>[] list, int idx) {
		int sum = 0;
		visited[idx] = true;
		for (int num : list[idx]) {
			if(!visited[num]) {
				visited[num] = true;
				sum += dfs(list,num)+1;
			}
		}
		return sum;
	}

}
