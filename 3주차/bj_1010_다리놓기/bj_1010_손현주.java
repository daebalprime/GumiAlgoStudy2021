package BJ;
import java.util.*;
public class bj_1010 {
	static int[][] isVisited = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();							// 테케 입력
		for(int tc=1; tc<=T; tc++) { 
			int R = sc.nextInt(); 						// 서쪽 N => nPr 편의를 위해 변수명 수정  
			int N = sc.nextInt(); 						// 동쪽 M
			sb.append(Combination(N,R)).append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
	
	public static int Combination(int n, int r) {
		if(isVisited[n][r]>0) return isVisited[n][r]; 	// 이미 방문한(저장되어있는)경우 리턴
		if(n==r || r ==0) return isVisited[n][r] = 1; 	// nPn, nP1 경우 1이니까 리턴
		else return isVisited[n][r] = Combination(n-1, r-1)+Combination(n-1,r);
	}

}
