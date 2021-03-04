// 0:30
// int 오버플로우 조심하자!
// 부등호 만족하는 모든 경우의수 찾기
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b2529 {

	static int k;
	static char[] equality;
	static long minVal = Long.MAX_VALUE;
	static long maxVal = Long.MIN_VALUE;
	static String minValStr;
	static String maxValStr;
	
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		equality = new char[k];
		for(int i=0;i<k;i++) equality[i] = st.nextToken().charAt(0);
		
		numbers = new int[k+1];
		for(int i=0;i<10;i++) {
			numbers[k] = i;
			permutation(i, k, 1<<i);
		}
		System.out.println(maxValStr);
		System.out.println(minValStr);
	}
	
	// 이전 수, 포인터(비교할 부등호 위치), 플래그
	static void permutation(int pre, int pointer, int flag) {
		if(pointer == 0) {
			StringBuilder sb = new StringBuilder();
			for(int i=k;i>=0;i--) {
				sb.append(numbers[k-i]+"");
			}
			
			long num = Long.parseLong(sb.toString());
			if(maxVal < num) {
				maxVal = num;
				maxValStr = sb.toString();
			}
			if(minVal > num) {
				minVal = num;
				minValStr = sb.toString();
			}
			return;
		}
		
		
		for(int i=0;i<10;i++) {
			if((flag & 1<<i) != 0) continue;
			
			// 이전 값과 부등호 성립하면 ok
			if(isValid(i, pre, equality[pointer-1])) {
				numbers[pointer-1] = i;
				permutation(i, pointer-1, flag|1<<i);
			}
		}
		
	}
	
	static boolean isValid(int num1, int num2, char sign) {
		if(sign == '<') {
			if(num1 < num2) return true;
		}
		else if(sign == '>') {
			if(num1 > num2) return true;
		}
		
		return false;
	}

	
}
