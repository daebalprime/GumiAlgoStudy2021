
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int groupNum = 0;
		
		for(int i=0;i<N;i++) {
			String s = sc.next();
			HashMap<Character, Integer> hash = new HashMap();
			boolean isGroupNum = true;
			for(int j=0;j<s.length();j++) {
				if(hash.containsKey(s.charAt(j))) {
					// 이미 등장한 문자일 경우 연속하는지 확인
					if(s.charAt(j-1) != s.charAt(j)) {
						// 연속하지 않는 경우
						isGroupNum = false;
					}
				}else {
					hash.put(s.charAt(j), 1);
				}
			}
			
			if(isGroupNum) {
				groupNum ++;
			}
		}
		
		System.out.println(groupNum);
	}

}
