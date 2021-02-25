import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_17225_세훈이의선물가게 {
	static class Order implements Comparable<Order>{
		int t;
		char color;
		Order(int t, char color) {
			this.t = t;
			this.color = color;
		}

        @Override
        public int compareTo(BOJ_17225_세훈이의선물가게.Order o) {
            if(this.t == o.t) {
				//B의 아스키코드값이 더 작기때문에 오름차순으로 정렬
				return this.color-o.color;
			}
			//오름차순
			return this.t-o.t;
        }
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); //상민이의 스피드
		int B = Integer.parseInt(st.nextToken()); //지수의 스피드
		int N = Integer.parseInt(st.nextToken()); //손님의 수

		PriorityQueue<Order> order = new PriorityQueue<>();
		int maxA = 0; int maxB = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int amount = Integer.parseInt(st.nextToken());

			if(c == 'B') {
				//값이 한번 들어갔다가 끝난 지점에서 부터 시작하기 위해
				if(maxA > t) t = maxA;
				//물건의 갯수만큼 더해주고 시간+걸리는 시간
				for(int j=0; j<amount; j++) {
					order.offer(new Order(t, c));
					t += A;
				}
				//다음 값의 시간과 비교하기위해
				maxA = t;
			} else {
				//값이 한번 들어갔다가 끝난 지점에서 부터 시작하기 위해
				if(maxB > t) t = maxB;
				for(int j=0; j<amount; j++) {
					order.offer(new Order(t, c));
					t += B;
				}
				maxB = t;
			}
		}
		//cmopareTo 오버로딩을 통해 시간 오름차순으로 정렬하고 시간이 같을때는 B가 앞으로 오도록 설정
		Queue<Integer> a = new LinkedList<>();
		Queue<Integer> b = new LinkedList<>();
		int cnt = 1;
		while (!order.isEmpty()) {
			Order o = order.poll();
			if (o.color == 'B') {
				a.add(cnt++);
			} else {
				b.add(cnt++);
			}
		}

		//t가 86400이므로 bw 선택
		bw.write(a.size() + "\n");
		for(int k:a) bw.write(k+" ");
		bw.write("\n");
		bw.write(b.size() + "\n");
		for(int k:b) bw.write(k+" ");
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}// end main
}// end class