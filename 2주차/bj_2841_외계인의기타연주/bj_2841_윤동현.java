import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ_2841_외계인의기타연주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Stack<Integer>[] s = new Stack[7];
		for(int i=0; i<7; i++) {
			s[i] = new Stack<>();
		}

		int res=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());

			//비어있다면 넣어주기
			if(s[line].isEmpty()) {
				s[line].push(fret);
				res++;
				continue;
			} 
			//스택값보다 작다면 fret보다 큰값들은 모두 pop해주기
			while(s[line].peek() > fret) {
				s[line].pop();
				res++;
				if(s[line].isEmpty()) break;
			}
			//위 while문이 돈다면 peek값이 fret이 된다.
			if(!s[line].isEmpty() && s[line].peek() == fret) continue;
			//큰 값들을 모두 pop하였더니 스택이 비었거나, peek값이 fret보다 작으면 넣어주기
			s[line].push(fret);
			res++;
		}
		System.out.println(res);
		br.close();
	}// end main
}// end class