package bj_silver;

import java.util.*;

public class Main_bj_2529_부등호 {
	static List<String> list;
	static boolean[] visit;
	static String[] s;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		s = new String[k];
		for(int i = 0; i < k; i++) {
			s[i] = sc.next();
		}
//		입력완료
//		for(String a: s) System.out.println(a);
		visit = new boolean[10];
		list = new ArrayList<>();
		check(0, "");
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		sc.close();
	}
	private static void check(int cnt, String str) {
		if(cnt == k+1) {
			if(isAvailable(str)) list.add(str);
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			check(cnt+1, str+i);
			visit[i] = false;
		}
	}
	private static boolean isAvailable(String str) {
		boolean flag = true;
		for(int i = 0; i < k; i++) {
			int a = str.charAt(i)-'0';
			int b = str.charAt(i+1)-'0';
			if(s[i].equals("<") && a>b) {
				flag = false;
				break;
			}
			else if(s[i].equals(">") && a<b) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
