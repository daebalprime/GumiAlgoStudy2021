import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static long result = 0;		// *주의* 결과는 long으로!
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	arr = new int[n];
    	
    	for(int i = 0 ; i < n; i++) {
    		arr[i] = stoi(stk.nextToken());
    	}
    	int b,c;
    	stk = new StringTokenizer(br.readLine());
    	b = stoi(stk.nextToken());
    	c = stoi(stk.nextToken());
    	
		// 총 감독관은 반드시 한명씩 필요하므로, 총 감독관의 감시 인원 수를 감소한다.
    	for(int i = 0; i < n; i++) {
    		arr[i] -= b;
    		result++;	// 총 감독관의 수를 늘린다.
    	}
    	long temp;
    	for(int i = 0; i < n; i++) {
			// 시험장의 인원이 0보다 작거나 같으면 부 감독관이 필요 없다.
    		if(arr[i] <= 0)
    			continue;
			// 부 감독관의 감시 수의 나머지를 구한다.
    		temp = arr[i] % c;
			// 만약 딱 떨어지면, 그 부 감독관의 수를 더하고, 나머지가 남으면 한명 추가한다.
    		if(temp == 0)
    			result += arr[i] / c;
    		else
    			result += arr[i] / c + 1;
    	}
    	System.out.println(result);
    	br.close();
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}