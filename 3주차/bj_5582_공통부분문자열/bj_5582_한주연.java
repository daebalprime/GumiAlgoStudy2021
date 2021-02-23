import java.util.*;
import java.io.*;

public class Main {
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	String a = br.readLine();
    	String b = br.readLine();
    	
    	int alen = a.length(), blen = b.length(); 
    	int[][] dp = new int[alen][blen];		// 각 문자열의 길이만큼 2차원 배열을 만든다.
    	
    	for(int i = 0; i < alen; i++) {
    		for(int j = 0; j < blen; j++) {
    			if(a.charAt(i) == b.charAt(j)) {
    				if(i == 0 || j == 0) {		// i, j 중 둘 중 하나라도 0이라면, i-1 or j-1이 -1이 되므로 IndexExecption이 되므로 방지
    					dp[i][j] = 1;
    				}
    				else {
    					dp[i][j] = dp[i-1][j-1] + 1;	// 현재 문자가 같으면, 직전 문자까지 동일한 두 부분 문자열 길이에 대해 1을 증가한다
    				}
    				result = Math.max(result, dp[i][j]);	// 문자열 길이 최대값
    			}
    		}
    	}
    	
    	System.out.println(result);
    	br.close();
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}