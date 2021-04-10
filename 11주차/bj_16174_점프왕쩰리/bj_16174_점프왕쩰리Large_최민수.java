package baekjoon_10001_20000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//[골드 5] 점프왕 쩰리 (Large)
//https://www.acmicpc.net/problem/16174
//제출전에 Main으로 바꾸기, file input 지우기, package 지우기
public class bj_16174_점프왕쩰리Large_최민수 {
	public static void main(String[] args) throws Exception {
		//테스트 입력
		System.setIn(new FileInputStream("res/baekjoon/bj_input_16174"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//아이디어 1: 도착점에서부터 도착점에 도달할 수 있는 애들을 역으로 q에 넣으면서 추적.
		//방문했던 곳은 제외
		
		//게임 구역의 크기 N: 2~64
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		//도착점 저장.
		q.offer(n-1);
		q.offer(n-1);
		boolean can = false;
		
		while(!q.isEmpty()) {
			int nowx = q.poll();
			int nowy = q.poll();
			if(nowx == 0 && nowy == 0) {
				can = true;
				break;
			}
			//현재 좌표로 이동할 수 있는 애들 체크.
			check(map, nowx, nowy, q);
		}
		if(can) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
		br.close();
	}

	private static void check(int[][] map, int nowx, int nowy, ArrayDeque<Integer> q) {
		//현재좌표에서 왼쪽에 있는 친구들 확인
		for (int i = 0; i < nowy; i++) {
			//0 ... i ... nowy
			//자기 위치 + 자기 위치에 있는 값으로 nowy에 도달할 수 있는가
			if(map[nowx][i] + i == nowy) {
				q.offer(nowx);
				q.offer(i);
			}
		}
		for (int i = 0; i < nowx; i++) {
			//0 ... i ... nowx
			//자기 위치 + 자기 위치에 있는 값으로 nowx에 도달할 수 있는가
			if(map[i][nowy] + i == nowx) {
				q.offer(i);
				q.offer(nowy);
			}
		}
		
	}
}
