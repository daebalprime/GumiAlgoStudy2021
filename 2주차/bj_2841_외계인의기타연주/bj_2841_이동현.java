package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Solution_bj_2841_외계인의기타연주_구미_4_이동현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] T = br.readLine().split(" ");
		Stack<Integer>[] gt = new Stack[7]; 
		int cnt = 0;
		for (int i = 0; i < gt.length; i++) {
			gt[i] = new Stack<>();
		}
		for (int i = 0; i < Integer.parseInt(T[0]); i++) {
			String[] inp = br.readLine().split(" ");
			int num = Integer.parseInt(inp[0]);
			int pret = Integer.parseInt(inp[1]);
			
			if (gt[num].empty()) {
				gt[num].add(pret);
				cnt++;
				continue;
			}
			if (gt[num].peek() < pret) {
				gt[num].add(pret);
				cnt++;
				continue;
			}
			while (!gt[num].empty() && gt[num].peek() > pret) {
				
				gt[num].pop();
				cnt++;
			}
			if (gt[num].empty() || gt[num].peek() < pret) {
				gt[num].add(pret);
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}

}
