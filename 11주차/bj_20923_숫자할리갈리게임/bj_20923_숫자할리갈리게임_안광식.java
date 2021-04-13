package bj.silver;

import java.io.*;
import java.util.*;

public class bj_20923_숫자할리갈리게임 {
	static Deque<Integer> dodo = new ArrayDeque<Integer>();
	static Deque<Integer> sujin = new ArrayDeque<Integer>();
	static Deque<Integer> doGround = new ArrayDeque<Integer>();
	static Deque<Integer> suGround = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // new StringTokenizer(br.readLine(), " ");
		//StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 카드 수
		int M = Integer.parseInt(st.nextToken()); // 게임 횟수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dodo.offer(Integer.parseInt(st.nextToken()));
			sujin.offer(Integer.parseInt(st.nextToken()));
		}


		while (M > 0) {
			// 도도 턴****
			doGround.offer(dodo.pollLast());
			if (dodo.isEmpty()) {
				break;
			}
			// 도도 종
			if (doGround.peekLast() == 5) {
				doGet();
			}
			// 수진 종
			if (suGround.size() > 0 && doGround.peekLast() + suGround.peekLast() == 5) {
				suGet();
			}
			if (--M == 0) break;
			
			// 수진 턴****
			suGround.offer(sujin.pollLast());
			if (sujin.isEmpty()) {
				break;
			}
			// 도도 종
			if (suGround.peekLast() == 5) {
				doGet();
			}
			// 수진 종
			if (doGround.size() > 0 && doGround.peekLast() + suGround.peekLast() == 5) {
				suGet();
			}
			if (--M == 0) break;
		}
		
		if (dodo.size() > sujin.size()) System.out.println("do");
		else if (sujin.size() > dodo.size()) System.out.println("su");
		else System.out.println("dosu");
		
		br.close();
	}
	
	static void doGet() {
		// 수진 그라운드 덱 흡수
		while (!suGround.isEmpty()) 
			dodo.offerFirst(suGround.pollFirst());
		// 본인 그라운드 덱 흡수
		while (!doGround.isEmpty()) {
			dodo.offerFirst(doGround.pollFirst());
		}
	}
	
	static void suGet() {
		// 도도 그라운드 덱 흡수
		while (!doGround.isEmpty()) 
			sujin.offerFirst(doGround.pollFirst());
		// 본인 그라운드 덱 흡수
		while (!suGround.isEmpty()) { 
			sujin.offerFirst(suGround.pollFirst());
		}
	} 
}
 
// 두 사람은 각 N장 카드로 이루어진 덱을 받음
// 덱 : 내용 모르게 뒤집어 쌓아 놓은 카드 더미
// 그라운드 : 두 사람이 본인 덱의 가장 위 카드를 내려놓는 땅.. 본인 그라운드에 카드 쭉 쌓게됨
// 도도 먼저 시작, 본인 덱 가장 위 카드를 숫자가 보이도록 그라운드에 내려놓음
// 종 치면 나와있는 카드 모두 가져감
// 종 치는 조건 1 : 각 그라운드 숫자 합 5 수연
// 2 : 그라운드 가장 위 카드 숫자 5 도도
// 종 쳤으면 상대 그라운드 카드 더미를 뒤집어 자신의 덱 아래로 그대로 합침
// 그 후 자신의 그라운드 카드 더미를 뒤집어 또 자신 덱 아래에 합침
// M번 진행 후 더 많은 카드를 지닌 사람이 승리, 같다면 비김
// 게임 도중 카드 수가 0이 되면 즉시 패배