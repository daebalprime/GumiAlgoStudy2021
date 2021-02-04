package wk2.bj4949;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			String str;
			while(true) {
				Stack<Character> a = new Stack<>();
				boolean answer = true;
				str = br.readLine();
				if (str.equals(".")) {
					break;
				}
				
				for(int i = 0; i < str.length(); i++) {					
					Character tmp = str.charAt(i);
					if(tmp.equals('[')) {
						a.add(tmp);
					}
					else if(tmp.equals('(')) {
						a.add(tmp);
					}
					else if(tmp.equals(']')) {
						if(a.size() == 0 || !a.pop().equals('[')) {
							answer = false;
							break;
						}
					}
					else if(tmp.equals(')')) {
						if(a.size() == 0 || !a.pop().equals('(')) {
							answer = false;
							break;
						}
					}
				}
				if(a.size() != 0) {
					answer = false;
				}
				bw.append(answer ? "yes" : "no");
				bw.newLine();
			}
			bw.flush();
		} catch(IOException e) {
			
		}
	}

}
