// 0: 53
// 구현 문제
package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b20923 {
	
	static int N, M; // 카드 개수, 게임 진행 횟수

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//1. 카드 배분 받기
		Deque<Integer> dodo = new ArrayDeque<>();
		Deque<Integer> su = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			dodo.addFirst(Integer.parseInt(st.nextToken()));
			su.addFirst(Integer.parseInt(st.nextToken()));
		}
		
		int result = doHaligaly(dodo, su);
		
		switch(result) {
		case 0:
			System.out.println("dosu");
			break;
		case 1:
			System.out.println("do");
			break;
		case 2:
			System.out.println("su");
			break;
		}
	}
	
	public static int doHaligaly(Deque<Integer> player1, Deque<Integer>player2) {
		Deque<Integer> ground1 = new ArrayDeque<>();
		Deque<Integer> ground2 = new ArrayDeque<>(); // getfirst가 보여지는 카드
		int result = 0;
		int game = 0;
		while(game<M){
			// 2. 도도 카드 내려놓기
			ground1.addFirst(player1.pollFirst());
			if(checkInstantFinish(player1, player2)) {
				break;
			}
			// 3. 도도가 종 치는 조건인지 확인(카드 내려놓을 때 5가 있는 순간)
			checkDodo(player1, ground1, ground2);
			
			// 3. 수연이 종 치는 조건인지 확인(카드 내려놓을 때 합이 5가 되는 순간)
			checkSu(player2, ground1, ground2);
			
			if(++game >= M) {
				break;
			}
			
			// 2. 수연 카드 내려놓기
			ground2.addFirst(player2.pollFirst());

			if(checkInstantFinish(player1, player2)) {
				break;
			}
			// 3. 도도가 종 치는 조건인지 확인(카드 내려놓을 때 5가 있는 순간)
			checkDodo(player1, ground1, ground2);
			
			// 3. 수연이 종 치는 조건인지 확인(카드 내려놓을 때 합이 5가 되는 순간)
			checkSu(player2, ground1, ground2);
			
			if(++game >= M) {
				break;
			}
		}
		
		if(result == 0) {
			if(player1.size() > player2.size()) {
				result = 1;
			}
			else if(player1.size() < player2.size()) {
				result = 2;
			}
		}
		
		
		return result;
	}
	
	public static boolean checkInstantFinish(Deque<Integer> player1, Deque<Integer> player2) {
		// 승리 조건 : 카드 수 0개
		boolean result = false;
		if(player1.size() == 0 && player2.size() != 0) {
			result = true;
		}
		else if(player1.size() != 0 && player2.size() == 0) {
			result = true;

		}
		
		else if(player1.size() == 0 && player2.size() == 0) {
			result = true;
		}
		
		return result;
	}
	
	public static void checkSu(Deque<Integer> player, Deque<Integer> ground1, Deque<Integer> ground2) {
		if((!ground1.isEmpty()&&!ground2.isEmpty()) && (ground1.getFirst()+ground2.getFirst() == 5)) {
			// 4. 카드 수연 덱으로 합치기
			mergeCard(player, ground1, ground2);
		}
	}
	
	public static void checkDodo(Deque<Integer> player, Deque<Integer> ground1, Deque<Integer> ground2) {
		int g1 = !ground1.isEmpty() ? ground1.getFirst() : 0;
		int g2 = !ground2.isEmpty() ? ground2.getFirst() : 0;
		if(g1==5 || g2 ==5) {
			// 4. 카드 도도 덱으로 합치기
			mergeCard(player, ground2, ground1);
		}
	}
	
	public static void mergeCard(Deque<Integer> player, Deque<Integer> deck1, Deque<Integer> deck2) {
		while(!deck1.isEmpty()) {
			player.addLast(deck1.pollLast());
		}
		
		while(!deck2.isEmpty()) {
			player.addLast(deck2.pollLast());
		}
	}

}
