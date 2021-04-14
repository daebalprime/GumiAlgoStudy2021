package bj_20923;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dodo = new LinkedList<>();
		Deque<Integer> susu = new LinkedList<>();
		Deque<Integer> dodoG = new LinkedList<>();
		Deque<Integer> susuG = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			dodo.offerLast(d);
			susu.offerLast(s);
			//Last->맨 위 FIRST->맨 아래 
		}
		if(dodo.size() == 0 && susu.size() == 0) {
			System.out.println("dosu");
			return;
		}
		int game = 0;
		while(true) {
			if(!dodo.isEmpty()) {
				dodoG.offerLast(dodo.pollLast());
				if(dodo.isEmpty()) {
					System.out.println("su");
					return;
				}
			}
			int sTop = susuG.isEmpty() ? 0 : susuG.peekLast();
			int dTop = dodoG.isEmpty() ? 0 : dodoG.peekLast();
			if((sTop == 5 || dTop == 5) ) {
				while(!susuG.isEmpty()) {
					dodo.offerFirst(susuG.pollFirst());
				}
				while(!dodoG.isEmpty()) {
					dodo.offerFirst(dodoG.pollFirst());
				}
			}
			else if(sTop + dTop == 5 && !susuG.isEmpty() && !dodoG.isEmpty()) {
				//su win
				while(!dodoG.isEmpty()) {
					susu.offerFirst(dodoG.pollFirst());
				}
				while(!susuG.isEmpty()) {
					susu.offerFirst(susuG.pollFirst());
				}
			}
			if(++game == M) break;
			if(!susu.isEmpty()) {
				susuG.offerLast(susu.pollLast());
				// LAST->맨 위
				if(susu.size() == 0) {
					System.out.println("do");
					return;
				}
			}
			sTop = susuG.isEmpty() ? 0 : susuG.peekLast();
			dTop = dodoG.isEmpty() ? 0 : dodoG.peekLast();
			if((sTop == 5 || dTop == 5) ) {
				while(!susuG.isEmpty()) {
					dodo.offerFirst(susuG.pollFirst());
				}
				while(!dodoG.isEmpty()) {
					dodo.offerFirst(dodoG.pollFirst());
				}
			}
			else if(sTop + dTop == 5 && !susuG.isEmpty() && !dodoG.isEmpty()) {
				//su win
				while(!dodoG.isEmpty()) {
					susu.offerFirst(dodoG.pollFirst());
				}
				while(!susuG.isEmpty()) {
					susu.offerFirst(susuG.pollFirst());
				}
			}
			if(++game == M) break;
		}
		if(dodo.size()>susu.size()) {
			System.out.println("do");
		}
		else if(dodo.size()<susu.size()) {
			System.out.println("su");
		}else {
			System.out.println("dosu");
		}
		br.close();
	}

}
