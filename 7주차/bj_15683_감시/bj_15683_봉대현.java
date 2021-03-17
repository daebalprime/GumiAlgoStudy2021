package a_7weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_15683_감시 {
	static int[][] map;
	static int n, m, ans;
	static ArrayList<int[]> cctv;
	// 우 상 하 좌
	static int dx[] = { 0, -1, 1, 0 };
	static int dy[] = { 1, 0, 0, -1 };
	static int[] rotatetype;

	// 1. 17퍼 아웃->감시구역이 많은것부터 ex 5->4->3->2->1
	// 2. 1->2->3->4->5 우선순위 0퍼?
	// 3. 순열로 최소 찾기
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = stoi(st.nextToken()); // 세로
		m = stoi(st.nextToken()); // 가로
		map = new int[n][m];
		cctv = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		// 맵 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] < 6)// cctv위치
					cctv.add(new int[] { i, j, map[i][j] });
			}
		}
		// 방향을 돌려야되는 갯수 1->4번 2->2번 3->4번 4->4번 5->1번
		rotatetype = new int[] { 0, 4, 2, 4, 4, 1 };
		dfs(0);
		System.out.println(ans);
		in.close();
	}

	static void dfs(int cnt) {
		if (cnt == cctv.size()) {
//			for(int []m:map)System.out.println(Arrays.toString(m));
//			System.out.println();
			ans = Math.min(ans, getzero());
			return;
		}
		int[] cnt_cctv = cctv.get(cnt);
		int copy[][] = new int[n][m];
		//0 동 1 남 2 서 3북
		for (int i = 0; i < rotatetype[cnt_cctv[2]]; i++) {
			for(int a=0;a<n;a++)
				for(int b=0;b<m;b++) {
					copy[a][b]=map[a][b];
				}
			if (cnt_cctv[2] == 1) {
				call(i,cnt_cctv[0],cnt_cctv[1]);
			} else if (cnt_cctv[2] == 2) {
				// ㅡ ㅣ 
				call(i,cnt_cctv[0],cnt_cctv[1]);
				call(i+2,cnt_cctv[0],cnt_cctv[1]);
			} else if (cnt_cctv[2] == 3) {
				call(i,cnt_cctv[0],cnt_cctv[1]);
				call(i+1,cnt_cctv[0],cnt_cctv[1]);
			} else if (cnt_cctv[2] == 4) {
				call(i,cnt_cctv[0],cnt_cctv[1]);
				call(i+1,cnt_cctv[0],cnt_cctv[1]);
				call(i+2,cnt_cctv[0],cnt_cctv[1]);
			} else {//5번은 4방향
				call(i,cnt_cctv[0],cnt_cctv[1]);
				call(i+1,cnt_cctv[0],cnt_cctv[1]);
				call(i+2,cnt_cctv[0],cnt_cctv[1]);
				call(i+3,cnt_cctv[0],cnt_cctv[1]);
			}
			dfs(cnt + 1);
			for(int a=0;a<n;a++)
				for(int b=0;b<m;b++) {
					map[a][b]=copy[a][b];
				}
		}

	}
	static void call(int d,int x,int y) {
		d%=4;
		//동
		if(d==0) {
			for(int i=y+1;i<m;i++) {
				if(map[x][i]==6)
					break;
				else if(map[x][i]==0)
					map[x][i]=-1;
			}
		}else if(d==1) {//남
			for(int i=x+1;i<n;i++) {
				if(map[i][y]==6)
					break;
				else if(map[i][y]==0)
					map[i][y]=-1;
			}
		}else if(d==2) {//서
			for(int i=y-1;i>=0;i--) {
				if(map[x][i]==6)
					break;
				else if(map[x][i]==0)
					map[x][i]=-1;
			}
		}else {//북
			for(int i=x-1;i>=0;i--) {
				if(map[i][y]==6)
					break;
				else if(map[i][y]==0)
					map[i][y]=-1;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int getzero() {
		int sum = 0;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				if (map[a][b] == 0)
					sum++;
			}
		}
		return sum;
	}

}
