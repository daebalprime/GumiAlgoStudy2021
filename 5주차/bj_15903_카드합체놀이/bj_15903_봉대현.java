package a_5weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_15903_카드합체놀이 {

	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(in.readLine());
		//매번 카드합체후 정렬안해도 된다. 최소힙
		PriorityQueue<Long>minheap=new PriorityQueue<>();
		for(int i=0;i<n;i++)
			minheap.add(Long.parseLong(st.nextToken()));
		
		for(int i=0;i<m;i++) {//카드 합체 
			//최소인것 2개 빼기
			long sum=minheap.poll()+minheap.poll();
			minheap.add(sum);
			minheap.add(sum);
		}
		long ans=0;
		while(!minheap.isEmpty()) {
			ans+=minheap.poll();
		}
		System.out.println(ans);
		in.close();
	}

}
