package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b5582 {
	static String S, T;
	static int maxLen = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = in.readLine();
		T = in.readLine();
				
		int minLen = S.length() < T.length() ? S.length(): T.length();
		String shorter = S.length() < T.length() ? S : T;
		String longer = S.length() < T.length() ? T : S;
		int left = 0;
		int right = 1;
		while(right <= minLen && left <= right) {
			if(longer.contains(shorter.substring(left, right))){
				maxLen = Math.max(maxLen, right - left);
				right ++;
			}
			else {
				left ++;
			}
		}
		
		System.out.println(maxLen);
	}
	

}
