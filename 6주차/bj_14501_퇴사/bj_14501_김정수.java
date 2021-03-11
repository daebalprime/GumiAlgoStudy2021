package baekjoon;

import java.util.Scanner;

public class b14501 {
	public int maxP = 0;
	
	public void solution(int n, int[]T, int[]P, int day, int earnP) {
		if(day == n) {
			//종료
			maxP = Math.max(earnP, maxP);
			return;
		}
		
		//현재 날짜 선택
		if(n-day >= T[day]) {
			solution(n, T, P, day+T[day], earnP+P[day]);
		}
		
		//선택x
		solution(n, T, P, day+1, earnP);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[]T = new int[n];
		int[]P = new int[n];
		for(int i=0;i<n;i++) {
			T[i] = s.nextInt();
			P[i] = s.nextInt();
		}
		
		b14501 b = new b14501();
		b.solution(n, T, P, 0, 0);
		System.out.println(b.maxP);
	}

}
