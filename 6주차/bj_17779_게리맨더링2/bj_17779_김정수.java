// 0:56
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b17779 {

	static int[][] population;
	static int N;
	static int minDiff;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		population = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//기준점 x, y잡기
				makeBorderLen(i, j);
			}
		}
		
		System.out.println(minDiff);
	}
	
	// x, y기준으로 만들 수 있는 모든 경우의 수 구하기
	static void makeBorderLen(int x, int y) {
		for(int d1=1; d1<N;d1++) {
			for(int d2=1;d2<N;d2++) {
				if(x+d1+d2<N && 0<=y-d1 && y+d2<N) {
					countPopul(x, y, d1, d2);
				}
			}
		}
	}
	
	// 선거구별 인구 구하기
	static void countPopul(int x, int y, int d1, int d2) {
		int maxPopul = Integer.MIN_VALUE;
		int minPopul = Integer.MAX_VALUE;
		
		// 5번 선거구 경계선 마킹
		int[][] marked = new int[N][N];
		int pop = 0;

		for(int i=0;i<=d1;i++) {
			marked[x+i][y-i] = 5;
			marked[x+d2+i][y+d2-i] = 5;
		}
		
		for(int i=0;i<=d2;i++) {
			marked[x+i][y+i] = 5;
			marked[x+d1+i][y-d1+i] = 5;
		}
		pop += population[x][y];
		pop += population[x+d2+d1][y-d1+d2];
		for(int i=x+1;i<x+d2+d1;i++) {
			boolean start = false;
			for(int j=0;j<N;j++) {
				if(!start && marked[i][j] == 5) {
					start = true;
					pop += population[i][j];
				}
				else if(start && marked[i][j] == 5) {
					start = false;
					pop += population[i][j];
				}
				else if(start && marked[i][j] != 5) {
					marked[i][j] = 5;
					pop += population[i][j];
				}
			}
		}
		maxPopul = Math.max(maxPopul, pop);
		minPopul = Math.min(minPopul, pop);
		
		// 1선거구
		pop = 0;
		for(int i=0;i<x+d1;i++) {
			for(int j=0;j<=y;j++) {
				if(marked[i][j] == 5) continue;
				marked[i][j] = 1;
				pop+=population[i][j];
			}
		}
		maxPopul = Math.max(maxPopul, pop);
		minPopul = Math.min(minPopul, pop);
		
		// 2선거구
		pop = 0;
		for(int i=0;i<=x+d2;i++) {
			for(int j=y+1;j<N;j++) {
				if(marked[i][j] == 5) continue;
				marked[i][j] = 2;
				pop+=population[i][j];
			}
		}
		maxPopul = Math.max(maxPopul, pop);
		minPopul = Math.min(minPopul, pop);
		
		// 3선거구
		pop = 0;
		for(int i=x+d1;i<N;i++) {
			for(int j=0;j<y-d1+d2;j++) {
				if(marked[i][j] == 5) continue;
				marked[i][j] = 3;
				pop+=population[i][j];
			}
		}
		maxPopul = Math.max(maxPopul, pop);
		minPopul = Math.min(minPopul, pop);
		
		// 4선거구
		pop = 0;
		for(int i=x+d2+1;i<N;i++) {
			for(int j=y-d1+d2;j<N;j++) {
				if(marked[i][j] == 5) continue;
				marked[i][j] = 4;
				pop+=population[i][j];
			}
		}
		maxPopul = Math.max(maxPopul, pop);
		minPopul = Math.min(minPopul, pop);
		
		//for(int i=0;i<N;i++)System.out.println(Arrays.toString(marked[i]));
		//System.out.println(maxPopul +" "+minPopul);
		// 선거구별 인구 max-min 최솟값 갱신
		minDiff = Math.min(minDiff, maxPopul - minPopul);
	}

}
