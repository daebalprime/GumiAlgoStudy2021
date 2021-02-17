package BJ;
import java.util.*;
import java.io.*;
public class bj_10972 {
	static int N;		//순열 N
	static int[] input; // 입력 값 -> 입력 값의 다음에 오는 것을 찾아야함
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());//순열을 입력받는다.
		input = new int[N];//입력 배열 할당
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) input[i] =Integer.parseInt(st.nextToken());
		if(nextinpututation()) {
			for(int i : input)
				sb.append(i).append(" ");
		}else sb.append("-1");
		System.out.println(sb);
	}
	static boolean nextinpututation() {
		//1. 꼭대기 찾기(뒤에서부터)
		int i=N-1;
		while(i>0 && input[i - 1]>=input[i]) --i;
		//2. 더 이상 앞자리가 없는 경우는 리턴
		if(i==0) return false;
		//3. 앞자리 찾기
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		//4. 교환
		swap(i-1,j);
		//5. 오름차순 정렬
		int k = N-1;
		while(i < k) swap(i++,k--);
		return true;
	}
	static void swap(int i, int j) {
		int tmp=input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
