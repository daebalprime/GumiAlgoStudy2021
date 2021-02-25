package bj_17140;

import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0;
	static int R,C,K;
	static int[][] map;
	static int[] counting;
	static int rMax, cMax;
	static PriorityQueue<int[]> q = new PriorityQueue<>(
			(o1,o2)->(o1[1]==o2[1]?
							Integer.compare(o1[0], o2[0])
							:Integer.compare(o1[1], o2[1])));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()) - 1;
		C = Integer.parseInt(st.nextToken()) - 1;
		K = Integer.parseInt(st.nextToken());
		
		map = new int[100][100];
		rMax = cMax = 3;
		for(int i = 0; i < 3; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for(int x = 0; x < 3; x++) {
//			cOperator();
//		}
		while(answer != 101) {
			if(map[R][C] == K) break;
			if(rMax >= cMax) {
				rOperator();
			}else {
				cOperator();
			}
//			for(int j = 0; j < rMax; j++) {
//				for(int i = 0; i < cMax; i++) {
//					System.out.print(map[j][i]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("--------------");
			answer++;
		}
		
		
		System.out.println(answer == 101 ? -1 : answer);
		br.close();
	}
	
	static void rOperator() {
		int cTmp = cMax;
		cMax = 0;
		for(int j = 0; j < rMax; j++) {
			counting = new int[101];
			int tot = 0;
			for(int i = 0; i < cTmp; i++ ) {
				if(map[j][i] == -1 || map[j][i] == 0) {
					continue;
				}
				counting[map[j][i]]++;
				tot++;
				map[j][i] = 0;
			}
			for(int i = 0; i <= 100; i++) {
				if(tot == 0) break;
				if(counting[i] == 0) continue;
				q.offer(new int[] {i,counting[i]});
			}
			int cnt = 0;
			for(int i = 0; i <= 100; i++) {
				if(q.isEmpty()) break;
				int[] tmp = q.poll();
				map[j][2*cnt] = tmp[0];
				map[j][2*cnt+1] = tmp[1];
				cnt++;
				cMax = Math.max(cMax, cnt*2);
				
				if(cnt == 50) break;
			}
		}
	}
	static void cOperator() {
		int rTmp = rMax;
		rMax = 0;
		for(int j = 0; j < cMax; j++) {
			counting = new int[101];
			int tot = 0;
			for(int i = 0; i < rTmp; i++ ) {
				if(map[i][j] == -1 || map[i][j] == 0) {
					continue;
				}
				counting[map[i][j]]++;
				tot++;
				map[i][j] = 0;
			}
			for(int i = 0; i <= 100; i++) {
				if(tot == 0) break;
				if(counting[i] == 0) continue;
				q.offer(new int[] {i,counting[i]});
			}
			int cnt = 0;
			for(int i = 0; i <= 100; i++) {
				if(q.isEmpty()) break;
				int[] tmp = q.poll();
				map[2*cnt][j] = tmp[0];
				map[2*cnt+1][j] = tmp[1];
				cnt++;
				rMax = Math.max(rMax, cnt*2);
				if(cnt == 50) break;
			}
			
		}
//		for(int i = cnt*2; i < cTmp; i++) {
//			map[j][i] = 0;
//		}
	}
}
