package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2841_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_2841.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 음의 개수와 프렛의 개수를 입력받는다.
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		// 스택 배열을 만든다. 1번음 스택, 2번음 스택, 3번음 스택,,,,,n번음스택
		Stack<Integer>[] guitar = new Stack[N];
		for(int i=0; i<N;++i) {
			guitar[i] = new Stack<>();
		}
		// 처리를 수행한다.
		int cnt = 0;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//음
			int p = Integer.parseInt(st.nextToken());//프렛
			
			// 아무것도 안누려져 있는 상태면 그냥 바로 업
			if(guitar[n].isEmpty()) {
				guitar[n].push(p-1);
				++cnt;
			}
			
			// 이미 있는 수가 더 크면 떼야함(반복)
			while(guitar[n].peek() > p-1) {
				guitar[n].pop();
				++cnt;
				if(guitar[n].size()==0) break; // 아무것도 안들어있으면 탈출
			}
			
			// 똑같은 걸 눌렸을 경우 & 이미 채워넣었을 경우
			if(!guitar[n].isEmpty() && guitar[n].peek()==p-1) continue; //뛰어넘기
			

			// 이미 있는 수 보다 더 크면 그냥 넣기 or 큰수들을 다 비우고 채워준다.
			guitar[n].push(p-1);
			++cnt;
		}
		System.out.println(cnt);
	}
}
