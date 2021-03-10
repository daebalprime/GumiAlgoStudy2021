package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_17779_게리멘더링2 {

	static int[][] people;
	static int minv, n;

	// 선거구가 5개 ,구역은 모두 연결, 인접한 구역은 0개이상의 통로
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		people = new int[n+1][n+1];
		minv=Integer.MAX_VALUE;
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= n; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				for(int d1=1;d1<=n;d1++) {
					for(int d2=1;d2<=n;d2++) {
						if(x<x+d1+d2&&x+d1+d2<=n&&1<=y-d1&&y+d2<=n)
							call(x,y,d1,d2);
					}
				}
			}
		}
		System.out.println(minv);
		in.close();
	}

	static void call(int x, int y, int d1, int d2) {
		// 5선거구 체크
		boolean[][] check = new boolean[n+1][n+1];
		// 5선거구
		for(int i=0;i<=d1;i++) {
			check[x+i][y-i]=true;
			check[x+d2+i][y+d2-i]=true;
		}
		for(int i=0;i<=d2;i++) {
			check[x+i][y+i]=true;
			check[x+d1+i][y-d1+i]=true;
		}
		//경계선 안쪽 체크
		for(int i=x+1;i<x+d1+d2;i++) {
			for(int j=1;j<=n;j++) {
				if(check[i][j]) {
					while(++j<=n&&!check[i][j])
					{
						check[i][j]=true;
					}
				}
			}
		}
		int []area=new int[5];
		//1구역 
		for(int i=1;i<x+d1;i++) {
			for(int j=1;j<=y;j++) {
				if(!check[i][j])
				area[0]+=people[i][j];
			}
		}
		//2구역
		for(int i=1;i<=x+d2;i++) {
			for(int j=y+1;j<=n;j++) {
				if(!check[i][j])
				area[1]+=people[i][j];
			}
		}
	
		//3구역
		for(int i=x+d1;i<=n;i++) {
			for(int j=1;j<y-d1+d2;j++) {
				if(!check[i][j])
				area[2]+=people[i][j];
			}
		}

		//4구역
		for(int i=x+d2+1;i<=n;i++) {
			for(int j=y-d1+d2;j<=n;j++) {
				if(check[i][j])continue;
				area[3]+=people[i][j];
			}
		}
		//5구역
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(check[i][j])area[4]+=people[i][j];
		}

		Arrays.sort(area);
		minv=Math.min(minv, area[4]-area[0]);
	}
	
}
