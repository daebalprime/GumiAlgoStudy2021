import java.io.*;
import java.util.*;
//덱:숫자가 보이지 않게 카드를 뒤집어 쌓아 놓은 카드 더미
//그라운드:자신이 가진 덱에서 가장 위에 있는 카드를 내려놓게 되는 땅. 그라운더에 카드 더미가 존재할 경우
//		  기존에 만들어진 카드 더미 위로 카드를 내려놓는 방식으로 진행
//종을 먼저 치는 사람이 그라운드에 나와 있는 카드 더미 모두 가져갈 수 있음.
//그라운드에 나와 있는 각각의 카드 더미에서 가장 위에 위치한 숫자 합이 5 > 수연이가 종을 침(그라운드 카드 모두 가져감)
//그라운드에 나와 있는 각각의 카드 더미에서 가장 위에 위치한 숫자 5 > 도도가 종을 침(그라운드 카드 모두 가져감)
public class Main_bj_20923_숫자할리갈리게임 {
	static Deque<Integer> deque_do=new ArrayDeque<>();
	static Deque<Integer> deque_su=new ArrayDeque<>();
	static Deque<Integer> ground_do=new ArrayDeque<>();
	static Deque<Integer> ground_su=new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_20923.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());//도도와 수연이가 가지고 있는 카드 개수
		int M=Integer.parseInt(st.nextToken());//게임 진행 횟수

		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			deque_do.add(Integer.parseInt(st.nextToken()));
			deque_su.add(Integer.parseInt(st.nextToken()));
		}
		
		while(M>0) {//게임의 진행
			if(isEmpty()) return;
			
			int tmp_do=deque_do.pollLast();
			ground_do.add(tmp_do);//도도 차례
			if(deque_do.isEmpty()) {
				System.out.print("su");
				return;
			}
			if(tmp_do==5) {
				dodo();
			}else if(!ground_su.isEmpty() && tmp_do+ground_su.peekLast()==5) {
				su();
			}
			M--;
			if(M==0) break;
			int tmp_su=deque_su.pollLast();
			ground_su.add(tmp_su);//수연 차례
			if(deque_su.isEmpty()) {
				System.out.print("do");
				return;
			}
//			System.out.println(M+" "+ground_do.peekLast());
			if(tmp_su==5) {
				dodo();
			}else if(!ground_do.isEmpty() && tmp_su+ground_do.peekLast()==5) {
				su();
			}
			M--;
		}
		
		if(deque_do.size()==deque_su.size()) {
			System.out.print("dosu");
		}else if(deque_do.size()<deque_su.size()) {
			System.out.print("su");
		}else {
			System.out.print("do");
		}
	}
	
	static boolean isEmpty() {
		if(deque_do.isEmpty() || deque_su.isEmpty()) return true;
		return false;
	}
	
	static void dodo() {
		while(!ground_su.isEmpty()) {
//			System.out.println(ground_su.peek());
			deque_do.addFirst(ground_su.pollFirst());
		}
		while(!ground_do.isEmpty()) {
			deque_do.addFirst(ground_do.pollFirst());
		}	
	}
	
	static void su() {
		while(!ground_do.isEmpty()) {
			deque_su.addFirst(ground_do.pollFirst());
		}
		while(!ground_su.isEmpty()) {
//			System.out.println(ground_su.peek());
			deque_su.addFirst(ground_su.pollFirst());
		}
	}
}
