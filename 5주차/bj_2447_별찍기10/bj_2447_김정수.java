// 0:20
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b2442 {

	static StringBuilder sb[];
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(in.readLine());
		sb = new StringBuilder[N];
		for(int i=0;i<N;i++) sb[i] = new StringBuilder();
		printStars(0, N, N);
		for(int i=0;i<N;i++) System.out.println(sb[i]);

	}
	
	static void printStars(int start, int end, int width) {

		if(width == 3) {
			sb[start].append("***");
			sb[start+1].append("* *");
			sb[start+2].append("***");
			return;
		}
		
		int n = width/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(j == 1 && i==1) {
					for(int k=0;k<width/3;k++) {
						for(int l=0;l<n;l++) {
							sb[start+(n*i)+l].append(" ");
						}
					}
					continue;
				}
				printStars(start+(n*i), start+(n*j)+3, width/3);
			}
		}
	}

}
