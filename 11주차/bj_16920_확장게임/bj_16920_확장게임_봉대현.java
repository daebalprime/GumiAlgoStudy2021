package a_11weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_16920_확장게임 {
	static int n, m, p;
	static char[][] map;
	static boolean visited[][];
	static int[] player;
	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		player = new int[p + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= p; i++) {
			player[i] = Integer.parseInt(st.nextToken());
		}
		map = new char[n][m];
		// 플레이어 성의 위치를 저장
		
		ArrayDeque<int[]> q[] = new ArrayDeque[10];
		for (int i = 1; i < 10; i++) {
			q[i] = new ArrayDeque<>();
		}

		for (int i = 0; i < n; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] - '0' >= 1) {
					q[map[i][j] - '0'].add(new int[] { i, j });
				}
			}
		}

		//logic
		while(true) {
			
			int cnt=0;
			for(int i=1;i<=p;i++) {
				if(q[i].size()==0)cnt++;
			}
			
			if(cnt==p) {
				break;
			}
			//플레이어 1의 성부터 확장
			for(int i=1;i<=p;i++) {
				for(int move=0;move<player[i];move++) {
					//플레이어가 가지고 있는 성의 개수
					int qsize=q[i].size();
					//성의 개수가 0이면 break
					if(qsize==0)break;
					
					//성의 개수 만큼 반복
					while (qsize>0) {
						int temp[] = q[i].poll();
							for (int k = 0; k < 4; k++) {
								int nx = temp[0] + dx[k];
								int ny = temp[1] + dy[k];
								if (0 <= nx && 0 <= ny && nx < n && ny < m) {
									if (map[nx][ny] == '.') {
										q[i].add(new int[] { nx, ny });
										map[nx][ny] = map[temp[0]][temp[1]];
									}
								}
						}
						qsize--;
					}
				}
			}
		}
		

		//for (char[] m : map)
		//	System.out.println(Arrays.toString(m));
		
		//출력
		int result[]=new int[p+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]-'0'>=1) {
					result[map[i][j]-'0']++;
				}
			}
		}
		
		for(int i=1;i<=p;i++)
			System.out.print(result[i]+" ");
		
		in.close();
	}
}
