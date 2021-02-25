package wk2.bj3078;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		long answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		try(BufferedReader bw=new BufferedReader(new InputStreamReader(System.in))){
			String in = bw.readLine();
			int N = Integer.parseInt(in.split(" ")[0]);
			int K = Integer.parseInt(in.split(" ")[1]);
			int[] lens = new int[21];
//			System.out.println(N + "  " + K);
			for(int tc = 0; tc < N; tc ++) {
//				System.out.println("_--------------");
//				System.out.println(q.size());
				int cl = bw.readLine().length(); // current name len
				if(q.size()>K) {
//					System.out.println("OUT");
					int tmp = q.poll();
					lens[tmp]--;
				}
//				System.out.println("****"+cl);
//				for(Integer t : lens) {
//					System.out.print(t+ " ");
//				}
//				System.out.println();
				answer += lens[cl];
				q.add(cl);
				lens[cl]++;
				
			}
		} catch(IOException e){
			
		}
		System.out.println(answer);
	}
}


//ArrayList-> 맨 앞의 elem remove-> O(NK)
