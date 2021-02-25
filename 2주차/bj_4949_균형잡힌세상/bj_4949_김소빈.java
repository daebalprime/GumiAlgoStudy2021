package bj_silver;

import java.io.*;
import java.util.ArrayList;

public class bj_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			char [] tmp = br.readLine().toCharArray();
			if(tmp[0] == '.') break;
			
			ArrayList<Character> li = new ArrayList<>();
			boolean flag = true;
			for(char t: tmp) {
				if(t == '(' ||t == '[') {
					li.add(t);
				}
				else if(t == ')') {
					int cur = li.size()-1;
					if(cur == -1 || li.get(cur)=='[') {
						flag = false;
						break;
					}
					li.remove(cur);
				}
				else if(t == ']') {
					int cur = li.size()-1;
					if(cur == -1 || li.get(cur) == '(') {
						flag = false;
						break;
					}
					else {
						li.remove(cur);
					}
				}
				else continue;
//				System.out.println(li);
			}
			
			if(li.size() == 0 && flag) System.out.println("yes");
			else System.out.println("no");
		}
		br.close();
	}
}
/*
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.

*/