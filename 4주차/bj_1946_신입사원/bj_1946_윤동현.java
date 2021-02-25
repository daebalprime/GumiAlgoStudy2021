import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class BOJ_1946_신입사원 {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.x, n.x);
		}
	}

	static ArrayList<Node> applicant;
	static int T,N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());

			applicant = new ArrayList<>();
			while(N-->0) {
				st = new StringTokenizer(br.readLine());
				applicant.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			Collections.sort(applicant);
			int cnt = 1; // 정렬된 1번은 무조건 통과
			int pass = applicant.get(0).y;
			for(int i=1; i<applicant.size(); i++) {
				if(pass > applicant.get(i).y) {
					cnt++;
					pass = applicant.get(i).y;
				}
			}
			System.out.println(cnt);
		}
		br.close();
	}
}//end class