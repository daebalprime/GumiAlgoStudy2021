package bj_7568;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer T = Integer.parseInt(sc.nextLine());
		Integer[][] people = new Integer[T][5]; // [0] h [1] w 
		// [2] how many people are bigger than? [3] id [4] rank
		
		for (int tc = 0; tc < T; tc++) {
			String[] tmp = sc.nextLine().split(" ");
			people[tc][0] = Integer.parseInt(tmp[0]);
			people[tc][1] = Integer.parseInt(tmp[1]);
			people[tc][2] = 0;
			people[tc][3] = tc;
		}
		for (int i = 0; i < T; i++) {
			Integer[] curr = people[i];
			for (int j = 0; j < T; j++) {
				if(curr[0] < people[j][0] &&
					curr[1] < people[j][1]) {
					curr[2] += 1;
				}
			}
		}
		Arrays.sort(people, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a1, Integer[] a2) {
				return a1[3].compareTo(a2[3]);
			}
		});
		for (int i = 0; i < people.length; i++) {
			System.out.print(people[i][2]+1);
			if (i != people.length-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}
}
