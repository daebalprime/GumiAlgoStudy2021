import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static long biggest = 0, smallest = Long.MAX_VALUE;     //최대 수인 9876543210은 int로 담을 수 없다.
	static char[] sign;
	static int[] sel, vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = stoi(br.readLine());
    	sign = new char[n];
    	sel = new int[n + 1];
    	vis = new int[10];
    	
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		sign[i] = stk.nextToken().charAt(0);
    	
    	DFS(0);
    	String str;
    	str = String.valueOf(biggest);
    	System.out.println(str);
    	
    	str = String.valueOf(smallest);
    	if(String.valueOf(smallest).length() == n) {
    		str = "0" + str;
    	}
    	System.out.println(str);
    	
    	br.close();
    	return;
	}
	
	public static void DFS(int lv) {
		if(lv == n + 1) {
			if(!Chk())
				return;
			
			long comp = 0;
			int idx = 0;
			for(int i = n; i >= 0; i--) {
				comp += sel[idx++] * Math.pow(10, i);
			}
			
			biggest = Math.max(comp, biggest);
			smallest = Math.min(comp, smallest);
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(vis[i] == 0) {
				vis[i] = 1;
				sel[lv] = i;
				DFS(lv + 1);
				vis[i] = 0;
			}
		}
	}
	
	public static boolean Chk() {
		
		for(int i = 0; i < n; i++) {
			if(sign[i] == '<') {
				if(sel[i] > sel[i + 1])
					return false;
			}
			else {
				if(sel[i] < sel[i + 1])
					return false;
			}
		}
		
		return true;
	}
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}