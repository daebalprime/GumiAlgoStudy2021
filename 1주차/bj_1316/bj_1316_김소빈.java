package bj_1316;

import java.util.Scanner;

public class bj_1316_김소빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			String tmp = sc.nextLine();
			String check = "";
			boolean flag = true;
			for(int j = 0; j < tmp.length(); j++) {
				if(!check.contains(Character.toString(tmp.charAt(j)))) check += tmp.charAt(j);
				else if(tmp.charAt(j-1) == tmp.charAt(j)) continue;
				else {
					flag = false;
					break;
				}
			}
//			System.out.println(flag);
			if(flag) ans++;
		}
		System.out.println(ans);
		sc.close();
	}
}
