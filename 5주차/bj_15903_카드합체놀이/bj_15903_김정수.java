// 0:10
package CodingTest.baekjoon;
import java.util.*;
import java.io.*;

public class b15903 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		PriorityQueue <Long> queue = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			queue.offer((long)stoi(st.nextToken()));
		}
		
		for(int i=0;i<m;i++) {
			// 제일 작은 수 2개 뽑고 더한 값 새로 큐에 넣기
			long num = queue.poll() + queue.poll();
			
			queue.offer(num);
			queue.offer(num);
		}
		
		long result = 0;
		while(!queue.isEmpty()) {
			result += queue.poll();
		}
		
		System.out.println(result);
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
