package bj_20055;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int exit = sc.nextInt()-1;
		int enter = 0;
		int size = exit*2+2;
		int zeroblocks = 0;
		int stepCount = 0;
		int K = sc.nextInt();
		int[] belt = new int[size];
		ArrayList<Integer> robots = new ArrayList<>();
		
		// get belt variables.
		for(int i=0; i<size; i++) {
			belt[i] = sc.nextInt();
			if(belt[i] == 0) zeroblocks++;
		}
		
		
		while(true) {	
			stepCount += 1;
			//step 1
			enter = enter-1 < 0 ? size-1 : enter-1;
			exit = exit-1 < 0 ? size-1 : exit-1;
			// robot exit
			for (int i = 0; i < robots.size(); i++) {
				int robotPos = robots.get(i);
				if (robotPos == exit) {
					robots.remove(i--);
					belt[robotPos] *= -1;
				}
			}
			// step 2
			for (int i = 0; i < robots.size(); i++) {
				int robotPos = robots.get(i);
				if(robotPos == -1) {
					continue;// revise it with linked list.
				}
				int next = robotPos + 1 >= size ? 0 : robotPos + 1;
				// robot exit
				if(belt[next] > 0) {
					belt[robotPos] *= -1;
					belt[next] -= 1;
					
					if(next == exit) {
						robots.remove(i--);
					}
					else {						
						robots.set(i, next);
						belt[next] *= -1;
					}
					
					if(belt[next] == 0) {
						zeroblocks += 1;
					}
				}
			}
			// step 3
			if (belt[enter] > 0) {
				robots.add(enter);
				belt[enter] -= 1;
				belt[enter] *= -1;
				if(belt[enter] == 0) {
					zeroblocks += 1;
				}
			}	
			//step4
			if(zeroblocks >= K) break;
		}
		System.out.println(stepCount);
		sc.close();
	}
}

//print status
//for (int i=0; i<size; i++) {
//	if (i == enter) {
//		System.out.print("↓\t");
//	}
//	else if(i == exit) {
//		System.out.print("↑\t");
//	}
//	else {
//		System.out.print(".\t");
//	}
//}
//System.out.println();
//for(int i = 0; i < size; i++) {
//	boolean flag = true;
//	for (int j=0; j < robots.size(); j++) {
//		
//		int robotPos = robots.get(j);
//		if(robotPos == -1) {
//			continue;
//		}
//		else if(robotPos == i) {
//			System.out.print("R"+j+"\t");
//			flag = false;
//		}
//	}
//	if(flag == true)
//		System.out.print("__"+"\t");		
//}
//System.out.println();
//for(int i = 0; i < size; i++) {
//	System.out.print(belt[i]+"\t");
//}
//System.out.println("\n----------------------");
//print end
