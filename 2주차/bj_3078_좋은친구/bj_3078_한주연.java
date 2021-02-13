/*
3954번 - Brainf**k 인터프리터
https://www.acmicpc.net/problem/3954
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	//int tc = stoi(br.readLine());
    	stk = new StringTokenizer(br.readLine());
    	int n = stoi(stk.nextToken());
    	int k = stoi(stk.nextToken());
    	
    	Queue<Long>[] nameLen = new LinkedList[21]; 
    	for(int i = 1; i <= 20; i++) {
    		nameLen[i] = new LinkedList<Long>();
    	}
    	
    	long cnt = 0;
    	for(long i = 1; i <= n; i++) {
    		int len = br.readLine().length();
    		
    		while(!nameLen[len].isEmpty() && i - nameLen[len].peek() > k) {
    			nameLen[len].poll();
    		}
    		cnt += nameLen[len].size();
    		nameLen[len].offer(i);
    	}
    	System.out.println(cnt);
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}