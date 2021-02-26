package BJ;

import java.io.*;
import java.util.*;
public class bj_13458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());				// 시험장의 개수
		int[] participant = new int[N];							// 각 시험장 응시자 수
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; ++i) participant[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int mainObserver = Integer.parseInt(st.nextToken());	// 총감독관이 감독가능한 수
		int subObserver =  Integer.parseInt(st.nextToken()); 	// 부감동관이 감독가능한 수
		long observerCnt = 0;									// 감독관 수, 백만*백만
		for(int i=0;i<N;++i) {
			participant[i] -= mainObserver;						// 총감독은 무조건 1명
			observerCnt++;										// 카운팅
			if(participant[i] > 0) {							// 유효한 검사만
				observerCnt += participant[i] / subObserver;	// 몫만큼 더해주기
				if(participant[i] % subObserver != 0) 			// 나누어 떨어지지 않으면 +1
					observerCnt++;
			}
		}
		System.out.println(observerCnt);						// 출력
	}
}
