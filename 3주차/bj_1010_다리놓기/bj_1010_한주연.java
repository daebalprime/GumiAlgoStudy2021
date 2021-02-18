import java.util.*;
import java.io.*;

public class Main {
	static int n,m,tc, sel[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	
    	tc = stoi(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	while(tc-- != 0) {
    		long result = 1;
    		long divide = 1;
    		stk = new StringTokenizer(br.readLine());
    		n = stoi(stk.nextToken());
    		m = stoi(stk.nextToken());
  
    		if(n > m / 2) {
    			n = m - n;
    		}
    		for(int i = n; i >= 1; i--) {
    			divide *= i;
    		}
    		for(int i = m; i > m - n; i--) {
    			result *= i;
    			if(result >= divide && result % divide == 0) {
    				result /= divide;
    				divide = 1;
    			}
    		}
    		
    		sb.append(result).append("\n");
    	}
    	System.out.println(sb);	
    	br.close();
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}