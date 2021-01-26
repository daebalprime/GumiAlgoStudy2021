import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_2346.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		ArrayList<Integer[]> arr = new ArrayList<Integer[]>();
		for (int t = 0; t < T; t++) {
			arr.add(new Integer[] {t+1,sc.nextInt()});
		}
		int i = 0;
		for (int j = 0; j < T; j++) {
			System.out.println(arr.get(i)[0]);
			int num;
			num = arr.get(i)[1];
			arr.remove(i);
			if (arr.size() == 0) break;
			if (num > 0) {
				i += 1;
				i += num - 1;
				i = (i % arr.size()) - 1;
			} else {
				i -= 1;
				i += num + 1;
				i = (i % arr.size());
			}
			if (i < 0) {
				i = arr.size() + i;
			}
		}
	}
}