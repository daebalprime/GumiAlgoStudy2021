import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16967_배열복원하기 {
	
	static int H,W,X,Y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[H+X][W+Y];
		for(int i=0; i<H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		(i, j)가 두 배열 모두에 포함되면, Bi,j = Ai,j + Ai-X,j-Y이다. -> A(i,j) = B(i,j)-A(i-X,j-Y)
		(i, j)가 두 배열 중 하나에 포함되면, Bi,j = Ai,j 또는 Ai-X,j-Y이다. ->하나에 포함될때 A(i,j)와 B(i,j)가 같음을 알수 있다.
		 */
		int[][] A = new int[H][W];
		for(int i=0; i<H+X; i++) {
			for(int j=0; j<W+Y; j++) {
				if(i<X && j<W) { // 배열 하나 포함
					A[i][j] = B[i][j];
				}else if(j<Y && i<H) { // 배열 하나 포함
					A[i][j] = B[i][j];
				}else if(i>=X && j>=Y && i<H && j<W) { //배열 모두 포함
					A[i][j] = B[i][j]-A[i-X][j-Y];
				}
			}
		}
		
		for(int[] vv:A) {
			for(int v:vv) {
				System.out.print(v+" ");				
			}
			System.out.println();
		}
		br.close();
	}
}
