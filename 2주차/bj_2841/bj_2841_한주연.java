/*
2841번 - 외계인의 기타 연주
https://www.acmicpc.net/problem/2841
*/

import java.util.*;
import java.io.*;

public class bj_2841_한주연 {
	
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st; 
    	st = new StringTokenizer(br.readLine());
    	
    	int n = stoi(st.nextToken());
    	int p = stoi(st.nextToken());
    	int result = 0;
    	ArrayList<Stack<Integer>> line = new ArrayList<Stack<Integer>>();
    	for(int i = 1; i <= 7; i++) {
    		line.add(new Stack<Integer>());
    	}
    	while(n-- != 0) {
    		st = new StringTokenizer(br.readLine());
    		int l = stoi(st.nextToken());
    		int num = stoi(st.nextToken());
    		if(line.get(l).empty() || line.get(l).peek() < num) {
    			line.get(l).push(num);
    			result++;
    		}
    		else if(line.get(l).peek() == num) {
    			continue;
    		}
    		else {
    			while(!line.get(l).empty() && line.get(l).peek() > num) {
    				line.get(l).pop();
    				result++;
    			}
    			if(!line.get(l).empty() && line.get(l).peek() == num) {
    				continue;
    			}
    			line.get(l).push(num);
    			result++;
    		}
    	}
    	System.out.println(result);
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}