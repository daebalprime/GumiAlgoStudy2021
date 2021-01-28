package bj_1316;
/*
1316번 - 그룹 단어 체커
https://www.acmicpc.net/problem/1316
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int cnt = n;
    	int visited[];
    	boolean isGroup = true;
    	for(int i = 0; i < n; i++) {
    		visited = new int[26];
    		String str = br.readLine();
    		char lastC = str.charAt(0);
    		visited[lastC - 'a'] = 1;
    		for(int j = 1; j < str.length(); j++) {
    			char curC = str.charAt(j);
    			if(lastC != curC && visited[curC - 'a'] != 0) {
    				isGroup = false;
                    break;
    			}
    			else {
    				visited[curC - 'a']++;
    			}
    			lastC = curC;
    		}
    		if(!isGroup) {
    			cnt--;
    			isGroup = true;
    		}
    	}
    	
    	System.out.println(cnt);
    	br.close();
    }
}

