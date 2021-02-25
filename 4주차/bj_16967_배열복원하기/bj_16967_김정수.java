package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b16967 {

	static int H, W, X, Y;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
	
		int[][] A = new int[H][W];
 		int[][] B = new int[H+X][W+Y];
 		for(int i=0;i<H+X;i++) {
 			st = new StringTokenizer(in.readLine());
 			for(int j=0;j<W+Y;j++) {
 				B[i][j] = Integer.parseInt(st.nextToken());
 			}
 		}
 		
 		for(int i=0;i<H;i++) {
 			for(int j=0;j<W;j++) {
 				A[i][j] = B[i][j];
 			}
 		}
 		
 		// 겹치는 부분
 		for(int i=0;i<H+X;i++) {
 			for(int j=0;j<W+Y;j++) {
 				if(checkInA(i, j) && checkInMovedA(i, j)) {
 					// 겹치면
 					A[i][j] -= A[i-X][j-Y];
 				}
 			}
 		}
 		
 		StringBuilder sb = new StringBuilder();
 		for(int i=0;i<H;i++) {
 			for(int j=0;j<W;j++) {
 				sb.append(A[i][j] + " ");
 			}
 			sb.append("\n");
 		}
 		
 		System.out.println(sb);
	}
	static boolean checkInA(int i, int j) {
		if(i<H && j<W) {
			return true;
		}
		return false;
	}
	static boolean checkInMovedA(int i, int j) {
		if(X<=i && i<H+X && Y<=j && j<W+Y) {
			return true;
		}
		return false;
	}
	

}
