/*
17839번 - Baba is Rabbit
https://www.acmicpc.net/problem/17839

A is B는
A를 B로 바꾸고, 결과인 B를 저장한다.
만약 A is C가 있었더라면,
B is C가 된다.
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static Set<String> result;
	static Map<String, List<String>> baba;
	static Map<String, Integer> vis;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());
    	
    	baba = new HashMap<>();
    	vis = new HashMap<>();
    	String p,q;
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine());
    		p = stk.nextToken();
    		stk.nextToken();
    		q = stk.nextToken();
    		if(!baba.containsKey(p)) {
    			List<String> qq = new ArrayList<>();
    			qq.add(q);
    			baba.put(p, qq);
    			vis.put(p, 0);
    		}
    		else {
    			baba.get(p).add(q);
    		}
    	}
    	
    	result = new HashSet<String>();
    	
    	Recur("Baba");
    	
    	List<String> sortStr = new ArrayList<String>(result);
    	Collections.sort(sortStr);
    	
    	for(String qq : sortStr)
    		System.out.println(qq);
    	
    	br.close();
	}

	static void Recur(String p) {
		if(!baba.containsKey(p))
			return;
		if(vis.get(p) != 0)
			return;
		
		vis.put(p, vis.get(p) + 1);
		
		for(String qq : baba.get(p)) {
			result.add(qq);
			Recur(qq);
		}
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}