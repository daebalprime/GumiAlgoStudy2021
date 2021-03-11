import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static int[] T, P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	T = new int[n + 1];
    	P = new int[n + 1];
    	
    	for(int i = 1; i <= n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		T[i] = stoi(stk.nextToken());
    		P[i] = stoi(stk.nextToken());
    	}
    	Work(1,0);
    	System.out.println(result);
    	br.close();
	}

	static public void Work(int d, int sum) {
		// 현재 상담을 선택하고, 해당 상담을 완수 하였을 때 n + 1 이전인 경우
		if(d + T[d] < n + 1) {
			Work(d + T[d], sum + P[d]);
		}
		// 현재 상담 날짜를 선택하지 않는 경우
		if(d + 1 < n + 1)
			Work(d + 1, sum);
		
		// 현재 상담을 이수하면 마지막 일인 경우
		if(d + T[d] == n + 1) {
			result = Math.max(sum + P[d], result);
		}
		
		
		result = Math.max(sum, result);
		return;
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}