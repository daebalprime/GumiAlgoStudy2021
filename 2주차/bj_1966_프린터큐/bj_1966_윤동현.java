import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BOJ_1966_프린터큐 {
	static class PriorityQueue {
		int index;
		int priority;
		PriorityQueue(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<PriorityQueue> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				q.add(new PriorityQueue(i, Integer.parseInt(st.nextToken())));
			}

			int cnt = 0;
			while(!q.isEmpty()) {
				boolean isCheck = true;
				for(int i=1; i<q.size(); i++) {
					if(q.peekFirst().priority < q.get(i).priority) {
						isCheck = false;
						break;
					}
				}
				if(!isCheck) {
					q.offerLast(q.pollFirst());
				} else {
					cnt++;
					int index = q.pollFirst().index;
					if(index == M) {
						break;
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
	}// end main
}// end class