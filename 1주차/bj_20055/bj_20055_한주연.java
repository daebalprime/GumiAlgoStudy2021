package bj_20055;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n =	stoi(st.nextToken());
    	int k = stoi(st.nextToken());
    	
    	ArrayList<Integer> conv = new ArrayList<Integer>();		// 컨베이어 벨트
    	ArrayList<Integer> robot = new ArrayList<Integer>();	// 로봇의 위친
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n*2; i++) {
    		conv.add(stoi(st.nextToken()));
    		robot.add(0);
    	}
    	
    	int cnt = 0;
    	int idx = 0;
    	while(cnt < k) {
    		idx++;
    		// 1번	- 컨베이어 밸트가 이동
    		int p = conv.get(n*2 - 1);
    		conv.remove(n*2 - 1);
    		conv.add(0,p);
    		// 로봇도 따라서 이동한다
    		robot.add(0,0);
    		robot.remove(n*2 - 1);
    		robot.set(n, 0);
    		
    		//2번 - 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
    		robot.set(n - 1, 0);	//내려가는 위치, 로봇이 사라짐
    		for(int i = n - 2; i >= 0; i--) {
    			// 현재 위치에 로봇이 있고, 다음 위치에 로봇이 없고 && 컨베이어 밸트의 내구도가 0이 아니면
    			if(robot.get(i) == 1 && conv.get(i + 1) != 0 && robot.get(i + 1) != 1) {
    				robot.set(i + 1 , 1);			// 다음에 로봇을 위치한다
    				int temp = conv.get(i+1) - 1;	// 로봇이 이동한 곳의 내구도 감소 
        			conv.set(i + 1, temp);			
        			robot.set(i, 0);				// 원래 위치에 로봇을 제거
        			
        			if(temp == 0)					// 4번
        				cnt++;
        		}
    		}
    		
    		//3번 - 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
    		if(robot.get(0) == 0 && conv.get(0) != 0) {
    			robot.set(0, 1);
    			int temp = conv.get(0) - 1;
    			conv.set(0, temp);
    			
    			if(temp == 0)						// 4번
    				cnt++;
    		}
    		
    	}
    	System.out.println(idx);
    	br.close();
    }
    static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}
