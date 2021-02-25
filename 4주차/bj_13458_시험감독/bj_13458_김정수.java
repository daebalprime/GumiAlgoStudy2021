package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b13458 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] exam = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			exam[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());

		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long inspector = 0;
		for(int A: exam) {

			if(A <= B) {
				inspector++;
			}else {
				inspector += 1+getInspector(A-B, C);
			}
		}
		
		System.out.println(inspector);
	}
	
	static int getInspector(int a, int b) {
		if(a <= 0) return 0;
		if(a <= b) return 1;
		int result = a/b;
		if(a%b > 0) {
			result+= 1;
		}
		return result;
	}
}
