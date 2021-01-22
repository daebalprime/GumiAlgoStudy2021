package bj_2346;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int smashed = 1;
		int curr = 0;
		int[] balloons = new int[size];
		
		for (int s = 0; s < size; s++) {
			
			balloons[s] = sc.nextInt();			
		}
		
		System.out.print("1 ");
		while(smashed != size) {
			int hp = Math.abs(balloons[curr]);
//			System.out.println("curr ["+ curr + " = " + hp);
			int direc = balloons[curr] > 0 ? 1 : -1; // direction.
			balloons[curr] = 0;
			while(hp > 0) {
				int tmp = curr + direc;
				curr = (tmp >= size) ? tmp % size :
					tmp < 0 ? size + tmp : tmp; 
//				System.out.println("hp " + hp + " tmp " + tmp);
//				System.out.println("===================");
				if(balloons[curr] == 0) {
					continue;
				}
				hp -= 1;
			}
			smashed += 1;
			System.out.print(curr+1);
			if (smashed != size) {
				System.out.print(" ");
			}
		}
	}
}
