package bj_silver;

import java.io.*;
import java.util.ArrayDeque;

public class bj_18258_큐2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayDeque<Integer> li = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String [] in = br.readLine().split(" ");
			switch(in[0]) {
				case "push":{
					li.add(Integer.parseInt(in[1]));
					break;
				}
				case "pop":{
					if(li.size() == 0) bw.write("-1\n");//sb.append("-1");////System.out.println("-1");
					else {
//						sb.append(li.get(0));
						bw.write(li.poll()+"\n");
						//System.out.println(li.get(0));
						
					}
					break;
				}
				case "size":{
//					sb.append(li.size());
					bw.write(li.size()+"\n");
//					System.out.println(li.size());
					break;
				}
				case "empty":{
//					sb.append(li.size()==0?"1":"0");
					bw.write(li.size()==0?"1\n":"0\n");
//					System.out.println(li.size() == 0?"1":"0");
					break;
				}
				case "front":{
//					sb.append(li.size()==0?"-1":li.get(0));
					bw.write(li.size()==0?"-1\n":li.peek()+"\n");
//					System.out.println(li.size() == 0?"-1":li.get(0));
					break;
				}
				case "back":{
//					sb.append(li.size()==0?"-1":li.get(li.size()-1));
					bw.write(li.size()==0?"-1\n":li.getLast()+"\n");
//					System.out.println(li.size() == 0?"-1":li.get(li.size()-1));
					break;
				}
				default: {
					bw.flush();break;
				}
				
			}
		}
		bw.close();
	}
}
/*
15
push 1
push 2
front
back
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
front
*/

/*1
2
2
0
1
2
-1
0
1
-1
0
3*/
