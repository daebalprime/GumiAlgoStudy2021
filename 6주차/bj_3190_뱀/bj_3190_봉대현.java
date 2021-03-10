package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_3190_뱀 {
	static int [][]map;
	static int n,k;
	static ArrayList<String []>move;
	static ArrayDeque<int []>snake;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		n=stoi(in.readLine());
		k=stoi(in.readLine());
		map=new int[n][n];
		StringTokenizer st;
		//사과있는 부분 1
		for(int i=0;i<k;i++)
		{
			st=new StringTokenizer(in.readLine());
			map[stoi(st.nextToken())-1][stoi(st.nextToken())-1]=1;
		}
		int L=stoi(in.readLine());
		move=new ArrayList<>();
		for(int i=0;i<L;i++) {
			st=new StringTokenizer(in.readLine());
			move.add(new String[] {st.nextToken(),st.nextToken()});
		}
		snake=new ArrayDeque<>();
		snake.add(new int[] {0,0});
		int []d=new int[] {0,1};
		int time=0;
		int x=0,y=0;
		map[x][y]=2;//자기가 지나간 흔적
		while(true) {
			time+=1;
			int nx=x+d[0];
			int ny=y+d[1];
			if(0<=nx&&nx<n&&0<=ny&&ny<n) {
				//사과먹기 -> 머리부분에 추가
				if(map[nx][ny]==1) {
					map[nx][ny]=2;
					snake.addFirst(new int[] {nx,ny});
				}
				//평상시 이동 꼬리위치변경
				else if(map[nx][ny]==0) {
					map[nx][ny]=2;
					snake.addFirst(new int[] {nx,ny});
					int tmp[]=snake.pollLast();
					map[tmp[0]][tmp[1]]=0;
				}
				//자기자신과 부딪힘
				else if(map[nx][ny]==2)
					break;
				x=nx;
				y=ny;
				//이동 
				if(move.size()>0) {
					if(stoi(move.get(0)[0])==time) {
						String temp[]=move.get(0);
						d=changed(d, temp[1]);
						move.remove(0);
					}
				}
			}else //맵밖으로 나간경우
				break;
		}
		System.out.println(time);
		in.close();
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int [] changed(int[] d,String L) {
		int x=d[0];
		int y=d[1];
		if(x==0) {
			if(L.equals("D")) {
				if(y>0)
					return new int[] {1,0};
				else
					return new int[] {-1,0};
			}else {
				if(y>0)
					return new int[] {-1,0};
				else
					return new int[] {1,0};
			}
		}else if(y==0) {
			if(L.equals("D")) {
				if(x>0)
					return new int[] {0,-1};
				else
					return new int[] {0,1};
			}else {
				if(x>0)
					return new int[] {0,1};
				else
					return new int[] {0,-1};
			}
		}
		return null;
	}
}
