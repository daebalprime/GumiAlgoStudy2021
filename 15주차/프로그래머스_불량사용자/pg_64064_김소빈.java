package level3;

import java.util.*;
public class Solution_64064_불량사용자2 {
	static Set<String> set;
	static String[] regex;
	static String[] user;
	static boolean[] visit;
	static int size;
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

		size = banned_id.length;
		set = new HashSet<>();
		user = user_id;
		regex = new String[size];
		for(int i = 0; i < size; i++) {
			regex[i] = banned_id[i].replace("*", ".");
		}
		visit = new boolean[user.length];
		dfs(0, "");
		System.out.println(set.size());
	}
	private static void dfs(int idx, String result) {
		if(idx == size) {
			String[] str = result.split(" ");
			Arrays.sort(str);
			
			StringBuilder newstr = new StringBuilder();
			for(int i = 0; i < str.length; i++) {
				newstr.append(str[i]);
			}
			set.add(newstr.toString());
			return;
		}
		
		for(int i = 0; i < user.length; i++) {
			if(!visit[i] && user[i].matches(regex[idx])) {
				visit[i] = true;
				dfs(idx+1, result+" "+user[i]);
				visit[i] = false;
			}
		}
	}
}
