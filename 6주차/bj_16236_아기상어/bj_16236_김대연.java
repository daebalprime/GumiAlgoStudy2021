package bj_16236;

import java.io.*;
import java.util.*;


public class Main {
	static int[] di = {0,-1,1,0};
	static int[] dj = {-1,0,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		int remained = 0;
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = j; y = i;
					map[i][j] = 0;
					continue;
				} else if(map[i][j] > 0) {
					++remained;
				}
			}
		}
//		System.out.println(remained);
		int answer = 0; // 경과시간
		int size = 2; // 현재 사이즈
		int requiredExp = 2; // 레벨업 하기 위한 필요한 경험치
		int mark = 1;
		visited[y][x] = mark;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y,0});
		boolean flag = false;
		int cd = 0;
		int fx = Integer.MAX_VALUE;
		int fy = Integer.MAX_VALUE;
		while(true) {
			if(remained == 0) break;
			if(!q.isEmpty()) {
				int[] tmp = q.poll();
				int cx = tmp[0], cy = tmp[1], depth = tmp[2];
				int currValue = map[cy][cx];
				
				if(flag && depth > cd) {
//					System.out.println(fx+ " " + fy + " distance : " + cd + " level : " + size);
//					for(int j = 0; j < N; j++) {
//						for(int i = 0; i < N; i++) {
//							if(j == fy && i == fx) System.out.print("* "); 
//							else System.out.print(map[j][i]+" ");
//						}
//						System.out.println();
//					}
					q.clear();
					q.offer(new int[] {fx,fy,0});
					answer += cd;
					--remained;
					visited[fy][fx] = ++mark;
					map[fy][fx] = 0;
					--requiredExp;
					if(requiredExp == 0) {
						requiredExp = ++size;
//						System.out.println("levelup!");
					}
					x = fx; y = fy;
					fx = Integer.MAX_VALUE;
					fy = Integer.MAX_VALUE;
					flag = false;
					cd = 0;
					continue;
				}
				
				if(currValue < size && currValue > 0) {// 먹기후보선정
//				System.out.println();
					if(cy == fy && cx < fx) {
						fy = cy;
						fx = cx;
					} else if(cy < fy) {
						fy = cy;
						fx = cx;
					}
					visited[cy][cx] = mark;
					if(flag==false) {
						cd = depth; 
					}
					flag = true;
//				continue;
				}
				for(int k = 0; k < 4; k++) {
					int nx = cx + di[k], ny = cy + dj[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					int nxtValue = map[ny][nx];
					if(nxtValue > size || visited[ny][nx] == mark) continue;
					else {
						q.offer(new int[] {nx,ny,depth+1});
						visited[ny][nx] = mark;
					}
				}
			}
			else {
				if(flag) {
//					System.out.println(fx+ " " + fy + " distance : " + cd + " level : " + size);
//					for(int j = 0; j < N; j++) {
//						for(int i = 0; i < N; i++) {
//							if(j == fy && i == fx) System.out.print("* "); 
//							else System.out.print(map[j][i]+" ");
//						}
//						System.out.println();
//					}
					q.clear();
					q.offer(new int[] {fx,fy,0});
					answer += cd;
					--remained;
					visited[fy][fx] = ++mark;
					map[fy][fx] = 0;
					--requiredExp;
					if(requiredExp == 0) {
						requiredExp = ++size;
//						System.out.println("levelup!");
					}
					x = fx; y = fy;
					fx = Integer.MAX_VALUE;
					fy = Integer.MAX_VALUE;
					flag = false;
					cd = 0;
					continue;
				}
				else break;
			}
		}
		System.out.println(answer);
		
		
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
		

	}

}
