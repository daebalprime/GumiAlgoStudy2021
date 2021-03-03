package a_5weeks;

import java.util.Scanner;

public class Main_bj_2447_별찍기10 {
	static char [][]map;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		map=new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				map[i][j]='*';
		}
		call(0,0,n);
		//star(0,0,n,false);
		for(char m[]:map)System.out.println(m);
	}
	static void call(int x,int y,int num) {
		int mid=num/3;
		if(mid==1) {
			map[x+mid][y+mid]=' ';
			return;
		}
		
		for(int i=x+mid;i<x+mid*2;i++) {
			for(int j=y+mid;j<y+mid*2;j++)
				map[i][j]=' ';
		}
		//위쪽
		call(x,y,mid);
		call(x,y+mid,mid);
		call(x,y+mid*2,mid);
		//중간
		call(x+mid,y,mid);
		call(x+mid,y+mid,mid);
		call(x+mid,y+mid*2,mid);
		//아래쪽
		call(x+mid*2,y,mid);
		call(x+mid*2,y+mid,mid);
		call(x+mid*2,y+mid*2,mid);
		
	}
	//남의 코드 내꺼보다 많이 빠름. 약 2배 차이
	static void star(int x, int y, int N, boolean blank) {
		// 공백칸일 경우
		if(blank) {	
			for(int i = x; i < x + N; i++) {
				for(int j = y; j < y + N; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
	 
		// 더이상 쪼갤 수 없는 블록일 때
		if(N == 1) {
			map[x][y] = '*';
			return;
		}
		/* 
		N=27 일 경우 한 블록의 사이즈는 9이고,
		N=9 일 경우 한 블록의 사이즈는 3이듯
		해당 블록의 한 칸을 담을 변수를 의미 size
	    
		count 는 별 출력 누적 합을 의미하는 변수다.
		*/
	    
		int size = N/3;
		int count = 0;
		for(int i = x; i < x + N; i += size) {
			for(int j = y; j < y + N; j += size) {
				count++;
				if(count == 5) {	// 공백 칸일 경우
					star(i, j, size, true);
				}
				else {
					star(i, j, size, false);
				}
			}
		}
	}
}
