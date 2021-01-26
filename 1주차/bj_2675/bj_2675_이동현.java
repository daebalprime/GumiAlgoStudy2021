import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_2675.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < n; k++) {
					sb.append(arr[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}

}