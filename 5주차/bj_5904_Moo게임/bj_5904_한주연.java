import java.util.*;
import java.io.*;

public class Main {
	static int n, result;
	static ArrayList<Integer> mooCnt = new ArrayList<>();
	static ArrayList<String> moos	= new ArrayList<>();
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/mainInput.txt"));	//제출 할 때 주석해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//StringTokenizer stk;
    	n = stoi(br.readLine());
    	
    	mooCnt.add(3);
    	moos.add("moo");
    	int num;
    	while(mooCnt.get(mooCnt.size() - 1) < n) {
    		moos.add(moos.get(moos.size() - 1) + "o");
    		num = mooCnt.get(mooCnt.size() - 1);
    		mooCnt.add(num + moos.get(moos.size() - 1).length() + num);
    	}
    	Mooo(n - 1, mooCnt.size() - 1);
    	br.close();
	}
	static void Mooo(int num, int idx) {
		// "moo"만 남은 경우
		if(num < 3) {
			System.out.println(moos.get(0).charAt(num));
			return;
		}
		// 왼쪽 S(k-1) 인 경우
		if(num < mooCnt.get(idx - 1)) {
			Mooo(num, idx - 1);
		}
		// 사이의 "mooooo" 인 경우
		else if(mooCnt.get(idx-1) <= num && num < mooCnt.get(idx-1) + moos.get(idx).length()) {
			System.out.println(moos.get(idx).charAt(num - mooCnt.get(idx-1)));
			return;
		}
		// 오른쪽 S(k-1) 인 경우
		else {
			Mooo(num - mooCnt.get(idx - 1) - moos.get(idx).length(), idx - 1);
		}
		return;
	}
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}