package wk2.bj3954;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String[] tmpinp = br.readLine().split(" ");
			int memsz = Integer.parseInt(tmpinp[0]); // memory size = mem*sizeof(int)
			int psz = Integer.parseInt(tmpinp[1]); // program length
			int inpsz = Integer.parseInt(tmpinp[2]); // length of input
			
			int[] mem = new int[memsz]; // total memory.
			String prog = br.readLine(); // program code
			String inp = br.readLine(); // input string
			
			int answer = Integer.MAX_VALUE;
			
			int ptr = 0; // current pointer
			int progptr = 0; // program pointer
			int iptr = 0; // input cycle
			int cycle = 0; // total cycle
			
			HashMap<Integer, Integer> bpairs = new HashMap<>();
			Stack<Integer> brackettmp = new Stack<>();
			for(int i = 0; i < psz; i++) {
				if(prog.charAt(i)=='[') brackettmp.push(i);
				else if(prog.charAt(i)==']') {
					int ob = brackettmp.pop();
					int cb = i;
					bpairs.put(ob,cb);
					bpairs.put(cb,ob);
				}
			}
			brackettmp.clear();
			brackettmp = null;
			boolean infflag = false;
			Stack<Integer> openb = new Stack<>(); // addresses of open bracket
			Stack<Integer> closeb = new Stack<>(); // addresses of closed bracket								
			boolean infloop = false;
			while(true) {
				if (cycle == 100000000) {
					infloop = true;
					break;
				}
				if (progptr == psz) break;
				
				switch (prog.charAt(progptr)) {
				case '+':
					mem[ptr] = (mem[ptr]+1)%256;
					progptr++;
					break;
				case '-':
					mem[ptr] = (mem[ptr]-1) == -1 ? 255 : mem[ptr]-1;
					progptr++;
					break;
				case '<':
					ptr = (ptr-1)==-1 ? memsz-1 : ptr-1;
					progptr++;
					break;
				case '>':
					ptr = (ptr+1)==memsz? 0 : ptr+1;
					progptr++;
					break;
				case '[':
					if(infflag) {
						answer = Math.min(progptr+1, answer);
						infflag = false;
					}
					if(openb.size() ==0 || openb.peek() != progptr) {
						openb.add(progptr);
						closeb.add(bpairs.get(progptr));
					}
					if(mem[ptr] == 0) { //jump to close bracket
						//pop both stack.
						if(openb.peek() == progptr) {							
							openb.pop();
							progptr = closeb.pop()+1;
						}
						else progptr = bpairs.get(progptr)+1;
						
						if(infloop) {
							infflag = true;
						}
					}
					else { // escape
						progptr++;
						
					}
					break;
				case ']':
					if(infflag) {
						answer = Math.min(bpairs.get(progptr)+1, answer);
						infflag = false;
					}
					if(mem[ptr] != 0) {
						//jump to previous open bracket
						progptr = openb.peek()+1;
					}
					else {
						//pop both stack
						if(closeb.peek() == progptr) {							
							openb.pop();
							closeb.pop();
						}
						if(infloop) {
							infflag = true;
						}
						progptr++;
					}
					break;
				case '.': // do nothing
					progptr++;
					break;
				case ',':
					if(iptr == inpsz) mem[ptr] = 255; 
					else mem[ptr] = (int) inp.charAt(iptr++);
					progptr++;
					break;
				}
				cycle++;
				if(cycle == 50000000) {
					if(openb.size() != 0) {						
						infloop = true;
						answer = openb.peek()+1;
					}
					else break;
				}
			} // end of execution
			
			//print result
			if(infloop == true) {
				System.out.println("Loops "+(answer-1)+" "+bpairs.get(answer-1));
			}
			else System.out.println("Terminates");
		}
	}
}


/*
Input :
2
65359 16 3
+[>+],...[[-],+]
999
65359 16 3
+[>+],[[-],+]+[]
999

Answer :
Terminates
Loops 14 15

Input:
1
3 209 1
+[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+],[-].+[-[[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+]----------------------------------[+]]++]
1

Output
Loops 86 208

Input:
2
3 124 1
+[-[[>+[>----------------------------------[+++]<+]++++++++++++++++++++++++++[+]<+]----------------------------------[+]]++]
.
1 8 1
+[-[]++]
.

Output
Loops 1 123 ☆☆☆
Loops 3 4

===== 입력 =====
2
10 5 1
+[[]]
a
1 9 1
++[[++]+]
a

===== 출력 =====
Loops 2 3
Loops 3 6

input:
1
10 9 3
+[-[><]-]
qwe

output:
Loops 3 6

input:
1
1000 10 1
+[,[+-]-].
a

output:
Loops 3 6
 */
