/*
 * 
24 o
39 m
309 m
909 m
9999 m
 */
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b5904 {

	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		moo(0, false);
		//countMoo(0, 0);
	}
	static int counter = 0;
	// 정점찍기 - 이전거 찍기 - 다음걸로 넘어가기
	// k: 차수, goback: 정점 찍고 돌아가는길인지 여부
	static void moo(int k, boolean goback) {
		// 정점 찍고 이전꺼 다시찍는 경우
		if(goback && counter < N)
			if(k-1>=0)
				moo(k-1, true);
		// 
		// 현재 정점 찍기
		counter+=1;
		if(counter == N) {
			System.out.println("m");
			return;
		}
		
		counter += k+2;
		if(counter >= N && N > counter - (k+2)) {
			System.out.println("o");
			return;
		}
		// 정점 찍으면 정점 이전 수열 출력하기
		if(k-1>=0 && counter < N)
			moo(k-1, true);
		// 해당 차수 수열 다 출력하면 다음 차수 정점 찍으러 넘어가기
		if(!goback && counter < N)
			moo(k+1, false);
	}
	
}
