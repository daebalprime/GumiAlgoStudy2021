import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_15903_카드합체놀이 {

	static PriorityQueue<Long> pq;
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) pq.offer(stoi(st.nextToken()));

		for(int i=0; i<M; i++) {
			long sum = pq.poll() + pq.poll();
			pq.offer(sum); pq.offer(sum);
		}

		long min = 0;
		while(!pq.isEmpty()) min += pq.poll();
		System.out.println(min);

		br.close();
	}

	static Long stoi(String s) {
		return Long.parseLong(s);
	}
}//end class