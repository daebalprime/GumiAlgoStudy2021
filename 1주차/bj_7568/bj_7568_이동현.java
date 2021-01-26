import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_7568.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr = new int[T][2];
		
		for (int t = 0; t < T; t++) {
			arr[t][0] = sc.nextInt();
			arr[t][1] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
 			}
			System.out.println(count);
		}
	}
}