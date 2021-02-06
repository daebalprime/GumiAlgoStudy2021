package bj_2504;

import java.io.*;
import java.util.*;

public class Main {
	static char[] open = {'(','['};
//	static char[] close = {')',']'};
	static int[] bpairs;
	static int[] bmul;
	
	static int recursive(int s, int e) {
//		System.out.println(s+ "  " + e);
		if(Math.abs(e-s) == 1) {
//			System.out.println("end");
			return bmul[e];
		}		
		int ret = 0;
		int pos = s+1;
//		if(s == 4 || s == 6) return 0;
//		sysout
		while(pos < e){
//			System.out.println(s+" " +e+"--"+pos+" "+bpairs[pos]+"--");
//			if(bpairs[pos] >= e) {
//				System.out.println(0);
//				System.exit(0);
//			}
			ret += (s == -1 ? 1: bmul[s])*recursive(pos, bpairs[pos]);
			pos = Math.max(pos+1,bpairs[pos]+1);
		}
		return ret;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while(true) {
			int answer = 0;
			String str = br.readLine();
			Stack<Integer> st = new Stack<>();
			Stack<Character> st2 = new Stack<>();
			bpairs = new int[str.length()];
			bmul = new int[str.length()];
			for(int i = 0; i < str.length(); i++) {
				if(st.size() == 0 || str.charAt(i)== '(' || str.charAt(i) == '[') {
					st.push(i);
					st2.push(str.charAt(i));
				}
				else if(str.charAt(i)== ')' || str.charAt(i) == ']'){
//					System.out.println("!"+st2.peek());
//					System.out.println(st2.toString());
					char c = st.isEmpty() ? ' ' : st2.pop();
					if((st.size() == 0 
							||!(c == str.charAt(i)-1 ||
							c == str.charAt(i)-2))
							) { 
//					System.out.println("empty size");
						System.out.println(0);
						return;
					}
					int tmp = st.pop();
//				System.out.println("MARKED : "+i+" "+tmp);
					bpairs[i] = tmp;
					bpairs[tmp] = i;
					int m = str.charAt(i) == ')' ? 2 : 3;
					bmul[i] = m;
					bmul[tmp] = m;
				}
				else {
					System.out.println(0);
					return;
				}
			}
			if(st.size() != 0) {
				System.out.println(0);
//			System.out.println("non-empty");
				return;
			}
			
//		System.out.println((char)('(' + 1));
//		System.out.println((char)('(' + 2));
//		System.out.println((char)('[' + 1));
//		System.out.println((char)('[' + 2));
			
			System.out.println(recursive(-1,str.length()-1));
//		for(int i : bpairs) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println(answer);
//		}
	}
}



/*
 * special inputs
(()[])

답 10

((()[]))

답 20

((()[]))[]

답 23

((()[])[])

답 26

()[()]

일반 + 중첩

답 8

(()[[]])

답 22

(()[[]])[]

답 25

[()[()[()]]]

일반+중첩 여러개

답 78

()[()]()[()]

답 16

(()[()]()[()])

32

(()[()]()[()])(()[()]()[()])

64

[](()[()]()[()])(()[()]()[()])

67

[](()[()]()[()])()(()[()]()[()])

69

[](()[()]()[()])()(()[()]()[()])[]

72

((()[()]()[()])()(()[()]()[()])[])

138
 */