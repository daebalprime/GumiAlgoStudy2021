import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_20309.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[T];
		int[] s_arr = new int[T];
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
			s_arr[i] = tmp;
		}
		Arrays.sort(s_arr);
		
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == s_arr[j]) continue;
			else {
				int n = arr[j] % 2;
				if (s_arr[j] % 2 == n) continue;
				else {
					check = false;
					break;
				}
			}
		}
		if (check) System.out.println("YES");
		else System.out.println("NO");
	}
}