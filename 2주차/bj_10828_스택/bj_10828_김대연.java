package wk2.bj10828;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Stack<Integer> s = new Stack<>();
			int T = Integer.parseInt(br.readLine());
			int size = 0;
			for(int tc = 0; tc < T; tc++) {
				String key = br.readLine();
				switch (key) {
				default:
					s.add(Integer.parseInt(key.split(" ")[1]));
					size++;
					break;
				case "pop":
					if(size == 0) {
						System.out.println("-1");
					}
					else {
						System.out.println(s.pop());
						size--;
					}
					break;
				case "size":
					System.out.println(size);
					break;
				case "empty":
					System.out.println(size==0 ? 1 : 0);
					break;
				case "top":				
					System.out.println(size==0 ? -1 : s.peek());
					break;
					
				}
			}
		}catch (IOException e){
			
		}
	}

}
