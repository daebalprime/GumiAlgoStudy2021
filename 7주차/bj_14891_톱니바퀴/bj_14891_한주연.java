/*
1. 톱니 바퀴를 돌린다.  
이는 중첩 List를 통하여 구현하였다.  

> * 시계 방향으로 돌리면
> 제일 뒤의 원소를 제일 앞으로 옮긴다.
> * 반 시계 방향으로 돌리면
> 제일 앞의 원소를 제일 뒤로 옮긴다.  
를 통하여 구현해야하기 때문에 이를 가장 잘 표현할 수 있는 자료구조인 List를 이용하였다.  
이 List가 4개 있고 Index로 0,1,2,3로 접근해야 하므로 `List<List<>>`의 형태로 나타내었다.  
제네릭 배열으로도 사용할 수 있었지만, `List<>[]` 이는 JDK에서 권장하지 않으므로 사용하지 않았다.  

2. 하나의 톱니 바퀴를 돌릴 때 양 옆의 톱니 바퀴도 돈다.  
1번째 톱니바퀴면 오른쪽, 4번재 톱니 바퀴면 왼쪽만 보고, 2,3번째는 양옆의 톱니바퀴를 본다.  
`List<List<>>`의 인덱스로 접근하여 3시, 9시가 서로 다르면 다른 방향으로 돌아가도록 하였다.  

3. 연쇄적으로 바퀴가 돈다.  
하나의 바퀴가 돌고, 나머지 바퀴도 돌 수있다면 연쇄적으로 바퀴가 돌아야한다.  
이는 재귀 함수를 통하여 구현하였다.  
[m번재 톱니바퀴, 방향, 톱니바퀴 회전여부]를 매개변수로 하여, 2번의 조건에 만족하면 인자로 바퀴의 순서, 반대 방향, 회전여부를 전달하여 계속하여 탐색하도록 하였다.  

만약 2번이 돌고 1번 톱니바퀴에 왔을 때, 2번이 이미 돌았다는 것은 어떻게 알까?  
이는 회전 여부를 나타내는 boolean 배열을 두어, 재귀 함수를 호출하기 전 m번째 바퀴는 이미 돌았다는 것을 나타낸다.

그리고 마지막에 자기 자신을 돌린다. 
*/

import java.util.*;
import java.io.*;

public class Main {
	static int n, result = 0;
	static List<List<Integer>> gear;		// 4개의 톱니바퀴를 중첩 List를 통하여 구현하였다. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	
    	gear = new ArrayList<>();
    	for(int i = 0; i < 4; i++) {
    		gear.add(new ArrayList<Integer>());
    		String str = br.readLine();
    		for(int j = 0; j < 8; j++) {
    			gear.get(i).add(str.charAt(j) - '0');
    		}
    	}
    	n = stoi(br.readLine());
    	int gearN, dir;
    	while(n > 0) {
    		stk = new StringTokenizer(br.readLine());
    		gearN = stoi(stk.nextToken());
    		dir = stoi(stk.nextToken());
    		turn(gearN - 1, dir, new boolean[4]);
    		n--;
    	}
    	int[] score = {1,2,4,8};
    	for(int i = 0; i < 4; i++) {
    		if(gear.get(i).get(0) == 1) {
    			result += score[i];
    		}
    	}
    	System.out.println(result);
    	br.close();
	}
	// 매개변수는 왼쪽부터, [m번재 톱니바퀴, 방향, 톱니바퀴 회전여부]
	static void turn(int m, int dir, boolean[] vis) {
		vis[m] = true;
		// 제일 왼쪽 기어일 때
		if(m == 0) {
			if(!vis[m + 1] && gear.get(m).get(2) != gear.get(m+1).get(6)) {
				turn(m + 1, CngDir(dir), vis);
			}
		}
		// 제일 오른쪽 기어일 때
		else if(m == 3) {
			if(!vis[m - 1] && gear.get(m).get(6) != gear.get(m-1).get(2)) {
				turn(m - 1, CngDir(dir), vis);
			}
		}
		else {
			// 자신보다 오른쪽 기어를 확인
			if(!vis[m + 1] && gear.get(m).get(2) != gear.get(m+1).get(6)) {
				turn(m + 1, CngDir(dir), vis);
			}
			// 자신보다 왼쪽 기어를 확인
			if(!vis[m - 1] && gear.get(m).get(6) != gear.get(m-1).get(2)) {
				turn(m - 1, CngDir(dir), vis);
			}
		}
		// 이제 자기 자신을 돌린다.
		TurnGear(m,dir);
	}
	// 바퀴를 돌리는 메서드
	static void TurnGear(int m, int dir) {
		int num;
		// 시계방향
		if(dir == 1) {
			num = gear.get(m).get(7);
			gear.get(m).remove(7);
			gear.get(m).add(0,num);
		}
		// 반시계방향
		else {
			num = gear.get(m).get(0);
			gear.get(m).remove(0);
			gear.get(m).add(num);
		}
	}
	// 방향을 바꾸는 메서드
	static int CngDir(int dir){
		if(dir == -1)
			return 1;
		return -1;
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}