package BJ;

import java.io.*;
import java.util.*;

/*
 * 아이디어
 * 1. 처음에 문제를 잘못 이해해서 서류기준 오름차순 정렬 후 1-2, 2-3, 3-4, ,,, 로 비교해서 틀림.
 * 2. 한 명이라도 나보다 서류&면접 순위가 높은사람이 있으면 그냥 탈락임.(포인트)
 */

public class bj_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Int(br.readLine());				// 테케 입력
		for (int tc = 1; tc <= t; ++tc) {		// 테케 만큼 반복
			int n = Int(br.readLine());			// 인원 수
			int[] rank = new int[n+1];			// 랭크는 1~N (동점없으므로 배열활용)
			for (int i = 0; i < n; ++i) { 		// 성적 "순위"를 입력받는다.(낮을수록합격률높)
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				rank[Int(st.nextToken())] = Int(st.nextToken());
			}
			int fail = 0;						// 탈락자 수를 카운팅 한다.
			int interview = rank[1];			// 서류 1순위의 면접 순위를 넣어준다.
			for(int i=2;i<n+1;++i) {			// 1위는 서류 순위 젤 높아서 합격이므로 2위부터 검사
				if(rank[i] > interview) fail++; // 면접 순위가 더높으면 탈락.
				else interview = rank[i];		// 면접 순위가 더 낮으면 갱신(이게 포인트였음.)
			}
			System.out.println(n-fail);			// 1-탈락자 수 = 합격자 수
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
