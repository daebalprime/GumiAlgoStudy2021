package a_11weeks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_bj_20923_할리갈리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayDeque<Integer> dolist = new ArrayDeque<>();
		ArrayDeque<Integer> sulist = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			dolist.add(sc.nextInt());
			sulist.add(sc.nextInt());
		}
		ArrayDeque<Integer> doground = new ArrayDeque<>();
		ArrayDeque<Integer> suground = new ArrayDeque<>();

		boolean flag = false;
		for (int i = 0; i < m; i++) {
			
			// 도도부터 시작
			if (!flag) {
				flag = true;
				doground.add(dolist.pollLast());
				if (dolist.size() == 0 || sulist.size() == 0)
					break;
			} else {
				flag = false;
				suground.add(sulist.pollLast());
				if (dolist.size() == 0 || sulist.size() == 0)
					break;
			}
			// 가장위에 위치한 카드의 숫자가 5인경우 ->do의 승리
			if (doground.size()>0&&doground.peekLast() == 5) {
				while (!suground.isEmpty()) {
					dolist.addFirst(suground.poll());
				}
				while (!doground.isEmpty()) {
					dolist.addFirst(doground.poll());
				}

			} else if(suground.size()>0&&suground.peekLast() == 5) {
				while (!suground.isEmpty()) {
					dolist.addFirst(suground.poll());
				}
				while (!doground.isEmpty()) {
					dolist.addFirst(doground.poll());
				}
			}
			else if (doground.size() > 0 && suground.size() > 0) {// 비어있지않는 경우 ->su의 승리
				if (doground.peekLast() + suground.peekLast() == 5) {// 각각의 숫자의 합이 5인경우
					while (!doground.isEmpty()) {
						sulist.addFirst(doground.poll());
					}
					while (!suground.isEmpty()) {
						sulist.addFirst(suground.poll());
					}
				}
			}
		}

		String result = "";
		if (dolist.size() > sulist.size())
			result = "do";
		else if (dolist.size() < sulist.size())
			result = "su";
		else
			result = "dosu";

		System.out.println(result);
	}
}
