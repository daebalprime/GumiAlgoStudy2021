package BJ;
import java.util.*;
public class bj_1010 {
	static int[][] isVisited = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int R = sc.nextInt();
			int N = sc.nextInt();
			sb.append(Combination(N,R)).append('\n');
		}
		System.out.println(sb);
		sc.close();
	}
	
	public static int Combination(int n, int r) {
		if(isVisited[n][r]>0) return isVisited[n][r];
		if(n==r || r ==0) return isVisited[n][r] = 1;
		else return isVisited[n][r] = Combination(n-1, r-1)+Combination(n-1,r);
	}

}
