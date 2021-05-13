package level2;

import java.util.*;

public class Solution_72411_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		List<String> answer = new ArrayList<>();
		
		for(int cur: course) {
			Map<String, Integer> map = new HashMap<>();
			for(String str: orders) {
				if(str.length() >= cur) {
					char[] tmp = str.toCharArray();
					Arrays.sort(tmp);
					
					comb(map, new StringBuilder(new String(tmp)).toString(), "", cur, 0, 0);
				}
			}
			if(!map.isEmpty()) {
				int max = Collections.max(map.values());
				if(max >= 2) {
					for(Map.Entry<String, Integer> tmp: map.entrySet()) {
						if(tmp.getValue() == max) answer.add(tmp.getKey());
					}
				}
			}
		}
		answer.sort(null);
		System.out.println(answer);
	}
	private static void comb(Map<String, Integer> m, String order, String str, int cur, int cnt, int start) {
		if(cur == cnt) {
			if(m.get(str) == null) m.put(str, 1);
			else {
				int val = m.get(str);
				m.put(str, val+1);
			}
			return;
		}
		for(int i = start; i < order.length(); i++) {
			comb(m, order, str+order.charAt(i), cur, cnt+1, i+1);
		}
	}
}
