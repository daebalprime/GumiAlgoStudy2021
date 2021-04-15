import java.io.*;
import java.util.*;

public class Main_bj_20208_진우의민트초코우유 {
	static int N, M, H, home_x, home_y, mint_cnt, answer;
	static int[][] map, selected;
	static int[] dx= {0,0,-1,1};//상하좌우
	static int[] dy= {1,-1,0,0};
	static boolean[] visited;
	static ArrayList<Node> mint = new ArrayList<>();
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_20208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());//마을의 크기
		M=Integer.parseInt(st.nextToken());//초기체력
		H=Integer.parseInt(st.nextToken());//민초우유 마실때마다 증가하는 체력의 양
		map=new int[N][N];
		mint_cnt=0;//총 민트초코 우유의 개수
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home_x=i;
					home_y=j;//출발점. 집의 위치
				}
				if(map[i][j]==2) {
					mint.add(new Node(i,j));//민트초코의 위치
					mint_cnt++;
				}
			}
		}
		answer=0;
		visited=new boolean[mint_cnt];
		for(int i=1;i<mint_cnt+1;i++) {
			selected=new int[i+1][2];//마지막 집의 위치
			perm(mint_cnt,i,0);
		}
		br.close();
		System.out.print(answer);
	}
	
	static void perm(int n, int r, int idx) {
		if(idx==r) {
			answer=Math.max(answer, move(r));
			return;
		}

		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[idx][0]=mint.get(i).x;
				selected[idx][1]=mint.get(i).y;
				perm(n,r,idx+1);
				visited[i]=false;
			}
		}
	}
	
	static int move(int r) {
		int hp=M;//체력
		int cnt=0;//마신 민트 초코 우유의 갯수
		int before_x=home_x;
		int before_y=home_y;
		selected[r][0]=home_x;
		selected[r][1]=home_y;
		for(int i=0;i<=r;i++) {
			int use_hp=distance(before_x,before_y,selected[i][0],selected[i][1]);
			if(use_hp<=hp) {
				hp=hp-use_hp+H;
				before_x=selected[i][0];
				before_y=selected[i][1];
				if(i!=r) cnt++;
			}else {
				return 0;
			}
			if(r-i+cnt<answer) return 0;
		}
		return cnt;
	}
	
	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
