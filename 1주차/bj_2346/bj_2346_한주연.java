package bj_2346;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {        
    	//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	Deque<Pair> deq = new ArrayDeque<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++)
    		deq.add(new Pair(Integer.parseInt(st.nextToken()),i));

    	int curN = 0;		//처음 터뜨릴 풍선은 제일 앞이므로 0이다.
    	for(int i = 0; i < n; i++) {
    		if(curN >=0) {	//다음 터뜨릴 풍선이 오른쪽에 있는 경우
    			for(int j = 0; j < curN - 1; j++) {
    				deq.add(deq.pollFirst());		// 앞을 pop하여 뒤에 넣는다.
    			}
    			curN = deq.getFirst().key;
    			System.out.print(deq.getFirst().value + " ");
    			deq.pollFirst();					//이후 제일 앞의 풍선을 pop한다.
    		}
    		else {			//다음 터뜨릴 풍선이 왼쪽에 있는 경우
    			for(int j = 0; j < Math.abs(curN + 1); j++) {
    				deq.addFirst(deq.pollLast());	// 역으로 뒤의 풍선을 pop하여 앞으로 보낸다.
    			}
    			curN = deq.getLast().key;
    			System.out.print(deq.getLast().value + " ");
    			deq.pollLast();
    		}
    	}
    	
    	br.close();
    }
    public static class Pair{ 	// Pair 구현
    	int key;
    	int value;
    	Pair(int k,int v){
    		key = k;
    		value = v;
    	}
    	int getKey() {
    		return key;
    	}
    	int getValue() {
    		return value;
    	}
		// Pair를 사용하는 구조체가 제대로 입력 되었는지 확인하기 위함
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pair [key=").append(key).append(", value=").append(value).append("]");
			return builder.toString();
		}
    	
    }
}
