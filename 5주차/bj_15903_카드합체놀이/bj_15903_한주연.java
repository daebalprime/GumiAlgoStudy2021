import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	// 타입을 long으로 선언한다.  
	static long sum, result;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	n = stoi(stk.nextToken());
    	m = stoi(stk.nextToken());
    	arr = new long[n];
    	stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = stoi(stk.nextToken());
    	}
		// 정렬을 하여 제일 작은 2개의 수의 합을 구하고 갱신한다.  
    	for(int i = 0; i < m; i++) {
    		Arrays.sort(arr);
    		sum = arr[0] + arr[1];
    		arr[0] = sum;
    		arr[1] = sum;    		
    	}
    	for(long v : arr) {
    		result += v;
    	}
    	System.out.println(result);
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}