import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_17471_게리맨더링 {

	private static int N, ans;
	private static int[] nums;
	private static int[][] graph;
	static boolean issel[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ans=Integer.MAX_VALUE;
		N = stoi(in.readLine());// 구역 수
		graph = new int[N + 1][];// 인접한 구역 저장
		issel = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		nums = new int[N + 1];// 인덱스에 맞게 구역 인구수저장
		for (int i = 1; i <= N; i++)
			nums[i] = stoi(st.nextToken());
		for (int i = 1; i < N + 1; i++) {// 구역 인접한 것 입력
			String s[] = in.readLine().split(" ");
			graph[i] = new int[stoi(s[0]) + 1];
			for (int j = 1; j <= stoi(s[0]); j++) {
				graph[i][j] = stoi(s[j]);
			}
		}
		// for(int []g:graph)System.out.println(Arrays.toString(g));
		for (int i = 1; i <= N; i++)
			combi(0, 1, i);//왼쪽만 선택한다.
		if(ans==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void combi(int cnt, int start, int end) {
		if (cnt == end) {
			// System.out.println(Arrays.toString(issel));
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (issel[i])
					left.add(i);
				else
					right.add(i);
			}
			
			if(left.size()>1&&!bfs(left))//왼쪽이 2개이상 일때 왼쪽 연결 검사
				return;
			if(right.size()>1&&!(bfs(right)))//오른쪽이 2개이상 일때오른쪽 연결 검사
				return;
			
			//왼쪽 인구수 
			int left_sum=0;
			for(int i=0;i<left.size();i++)
				left_sum+=nums[left.get(i)];
			//오른쪽 인구수
			int right_sum=0;
			for(int i=0;i<right.size();i++)
				right_sum+=nums[right.get(i)];
			
			ans=Math.min(ans, Math.abs(left_sum-right_sum));
			return;
		}
		for (int i = start; i <= N; i++) {
			issel[i] = true;
			combi(cnt + 1, i + 1, end);
			issel[i] = false;
		}
	}

	private static boolean bfs(ArrayList<Integer> list) {
		boolean []visited=new boolean[N+1];//방문 표시
		for (int i = 0; i <list.size(); i++) {
				visited[list.get(i)]=true;
		}
		ArrayDeque<Integer>q=new ArrayDeque<>();
		q.add(list.get(0));
		visited[list.get(0)]=false;
		int d=1;
		while(!q.isEmpty()) {
			int cnt=q.pollFirst();
			for(int c:graph[cnt]) {
				if(visited[c]) {
					d+=1;
					q.add(c);
					visited[c]=false;
				}
			}
		}
		//연결되었다면 총 길이랑 같아야된다.
		if(d==list.size())
			return true;
		return false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
