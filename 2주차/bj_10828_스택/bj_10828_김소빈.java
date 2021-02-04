package bj_silver;

import java.util.ArrayList;
import java.io.*;

public class bj_10828_스택 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> li = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String [] in = br.readLine().split(" ");
			switch(in[0]) {
				case "push":{
					li.add(Integer.parseInt(in[1]));
					break;
				}
				case "pop":{
					if(li.size() == 0) System.out.println("-1");
					else {
						int target = li.size()-1;
						System.out.println(li.get(target));
						li.remove(target);
					}
					break;
				}
				case "size":{
					System.out.println(li.size());
					break;
				}
				case "empty":{
					if(li.size() == 0) System.out.println("1");
					else System.out.println("0");
					break;
				}
				case "top":{
					if(li.size() == 0) System.out.println("-1");
					else System.out.println(li.get(li.size()-1));
					break;
				}
				default: break;
			}
		}
	}
}
/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

*/