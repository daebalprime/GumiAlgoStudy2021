/*
텀 프로젝트
https://www.acmicpc.net/problem/9466
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static int[] stud;
	static int[] state;	// 0은 방문하지 않은 상태, 1은 성공, 2는 실패, 3은 현재 탐색 중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	int tcN = stoi(br.readLine());
    	for(int idx = 0; idx < tcN; idx++) {
    		n = stoi(br.readLine());
    		result = 0;
    		stud = new int[n+1];
    		state = new int[n+1];
    		
    		stk = new StringTokenizer(br.readLine());
    		for(int i = 1; i <= n; i++) {
    			stud[i] = stoi(stk.nextToken());
    		}
    		
    		for(int i = 1; i <= n; i++) {
    			if(state[i] == 0) {		// 아직 방문하지 않았으면
    				DFS(i);
    			}
    		}
    		
    		for(int i = 1; i <= n; i++) {
    			if(state[i] == 2)	// 실패한 경우를 센다
    				result++;
    		}
    		
    		System.out.println(result);
    	}
    	  	
    	br.close();
	}
	static int startN;
  	
	static int DFS(int curN) {
		if(curN == stud[curN]) {	// 자기 자신을 선택한 경우
			state[curN] = 1;		// 성공
			return 2;	// 현재 N을 가리켰던 모든 체인은 다 실패함
		}
		
		if(state[curN] == 3) {	// 사이클이 형성된 경우
			startN = curN;		// 사이클의 시작점을 저장한다
			return 1;
		}
		else if(state[curN] != 0) {		// 이미 한번 방문한 경우
			return 2;
		}
		
		state[curN] = 3;		// 현재 노드는 탐색 중
		
		int rst = DFS(stud[curN]);	
		
		if(rst == 1) {		// 사이클이 형성 되었다는 경우
			state[curN] = 1;
			
			if(curN == startN)	// 현재 노드가 사이클의 시작점이면, 현재 노드를 가리키던 다른 노드들은 실패한다.
				return 2;
			
			return 1;
		}
		else {		// 실패한 경우
			state[curN] = 2;
			return 2;
		}
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}