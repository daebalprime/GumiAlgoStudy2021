package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b1780 {
	static int[] arr = new int[3];
	static int[][] paper;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		for(int i:arr) System.out.println(i);
	}
	
	static void divide(int row, int col, int n) {
		// n이 1이면 바로 반환
		if(n==1) {
			arr[paper[row][col]+1]++;
			return;
		}
		// 종이가 같은 수로 되어 있는지 확인
		int check = checkPaper(row, col, n);
		if(check!=-100) {
			arr[check+1]++;
			return;
		}
		
		// 9개로 나누기
		for(int i=0;i<n;i+=n/3) {
			for(int j=0;j<n;j+=n/3) {
				divide(row+i, col+j, n/3);
			}
		}
	}
	
	static int checkPaper(int row, int col, int n) {
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(paper[i][j] != paper[row][col]) return -100;
			}
		}
		
		return paper[row][col];
	}

}
