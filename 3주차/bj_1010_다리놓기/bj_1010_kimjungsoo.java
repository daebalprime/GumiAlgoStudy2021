package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1010 {
	
	static long facto(int n, int limit) {
		if(n == limit || n == 1)
			return n;
		return n * facto(n-1, limit);
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			
			// 오버플로우 방지: nCr == nCn-r
			if(N-M < M && N != M) {
				M = N-M;
			}
			
			// 오버플로우 방지 2: n!/r!(n-r)! == n*...*(n-r+1)/r!
			long result = facto(N, N-M+1)/facto(M, 1);
			System.out.println(result);
		}
	}

}
