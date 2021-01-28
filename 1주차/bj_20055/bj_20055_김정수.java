import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void moveBelt(int [] belt) {
		
		int temp = belt[0];
		belt[0] = belt[belt.length-1];
		for(int i=belt.length-2; i>0;i--) {
			belt[i+1] = belt[i];
		}
		belt[1] = temp;
		
	}

	public static void moveRobot(int [] belt) {
		for(int i=belt.length-2; i>=0;i--) {
			belt[i+1] = belt[i];
		}
		belt[0] = 0;
		
		belt[belt.length-1] = 0;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() * 2;
		int K = sc.nextInt();
		
		int [] belt = new int[N];
		int [] robot = new int[N/2];
		int beltLive = N;
		int step = 0;
		
		for(int i=0;i<N;i++) {
			belt[i] = sc.nextInt();
		}
		
		
		while(N - beltLive < K) {
			step++;
			// 1. 벨트 음직이기
			moveBelt(belt);
			moveRobot(robot);
			
			for(int i=(N/2)-2;i>=0;i--) {
				if(robot[i] != 0) {
					// 해당 위치에 로봇이 있을 경우 움직인다.
					if(robot[i+1] == 0 && belt[i+1] > 0) {
						robot[i+1] = robot[i];
						robot[i] = 0;
						
						belt[i+1] --;
						if(belt[i+1] == 0) {
							beltLive --;
						}
						
						//내려가는 곳이면 로봇 사라지게 하기
						if(i+1 == N-1) {
							robot[i+1] = 0;
						}
					}
				}
			}
			
			if(robot[0] == 0 && belt[0] > 0) {
				robot[0] = 1;
				belt[0]--;
				if(belt[0] == 0) {
					beltLive --;
				}
			}
			
		}
		
		System.out.println(step);
		
	}

}
