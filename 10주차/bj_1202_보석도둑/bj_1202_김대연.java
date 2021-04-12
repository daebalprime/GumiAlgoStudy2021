import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Double.compare((double)o2[1]/o2[0], (double)o1[1]/o1[0]) == 0 ? Integer.compare(o2[0], o1[0]) : Double.compare((double)o2[1]/o2[0], (double)o1[1]/o1[0])); 
//		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2[0], o1[0])==0? Double.compare((double)o2[1]/o2[0], (double)o1[1]/o1[0]) :Integer.compare(o2[0], o1[0])); 
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0], o2[0])); 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {M,V});
		}
		Queue<Integer> packs = new LinkedList<Integer>();
		for(int i = 0; i < K; i++) {
			packs.offer(Integer.parseInt(br.readLine()));
		}
		Collections.sort((LinkedList<Integer>)packs, (o1,o2)->Integer.compare(o1, o2));
		long answer = 0;
		PriorityQueue<int[]> bosuk = new PriorityQueue<>((o1,o2)->Integer.compare(o2[1], o1[1])); 
		for(int wMax : packs) {
			while(!pq.isEmpty()) {
				int[] curr = pq.peek();
				int M = curr[0];
				int V = curr[1];
				if(wMax < M) {
					break;
				}
				bosuk.offer(pq.poll());
			}
			if(bosuk.size() == 0) continue;
			answer += bosuk.poll()[1];
		}
		System.out.println(answer);
	}

}
