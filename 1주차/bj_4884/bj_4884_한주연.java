package bj_4884;

import java.util.*;
import java.io.*;

public class Main {
	static long at = 0;
	static long g,a,t,d;
	static long x,y;
    public static void main(String []args) throws IOException {        
    	System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    		StringTokenizer stk = new StringTokenizer(br.readLine());
    		g = Integer.parseInt(stk.nextToken()); 
    		t = Integer.parseInt(stk.nextToken());
    		a = Integer.parseInt(stk.nextToken());
    		d = Integer.parseInt(stk.nextToken());
    		if(g == -1) 
    			break;
    		//토너먼트 진출 팀 수 구하기
    		long trmnt = g * a + d; // 그룹 수 x 진출 수 + 바로 진출 수
    		long idx = 0;
    		long chkN1, chkN2;
    		//2의 제곱꼴이 아닐때, 가까운 2의 제곱으로 진출하는 팀의 수를 찾기
    		while(true) {
    			chkN1 = (long) Math.pow(2, idx - 1);
    			chkN2 = (long) Math.pow(2, idx);
    			if(chkN1 < trmnt && trmnt <= chkN2) {
    				y = chkN2 - trmnt;		// 추가해야하는 팀의 수
    				trmnt = chkN2;
    				break;
    			}
    			idx++;
    		}
    		at = (t * (t - 1)) / 2;		// 한 그룹 스테이지에서 팀 토너먼트로 갈때 걸리는 총 경기 수
    		x = at * g + trmnt - 1;		// (at * 그룹 수) + (토너먼트에 진출 후 결승까지 총 경기 수)
    		System.out.println(g + "*" + a + "/"  + t + "+" + d + "=" + x + "+" + y);
    		at = 0;
    	}
    	br.close();
    }
}