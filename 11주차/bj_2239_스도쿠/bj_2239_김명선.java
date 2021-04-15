import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠 {
	static int[][] map;
	static boolean[][][] visited;
	static int selected_size,size=9;
	static ArrayList<int[]> selected = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2239.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		map=new int[size][size];
		visited=new boolean[size][size][10];
		for(int i=0;i<size;i++) {
			tmp=br.readLine();
			for(int j=0;j<size;j++) {
				map[i][j]=tmp.charAt(j)-'0';
				if(map[i][j]==0) selected.add(new int[] {i,j});
			}
		}
		selected_size=selected.size();
		select(0);
	}
	
	static void select(int cnt) {
		if(cnt==selected_size) {//기저조건
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					sb.append(map[i][j]);
				}
				if(i!=size-1) sb.append('\n');
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		int[] cur = selected.get(cnt);
		
		for(int i=1;i<10;i++) {
			if(check(cur[0],cur[1],i) && !visited[cur[0]][cur[1]][i]) {				
				map[cur[0]][cur[1]]=i;
				visited[cur[0]][cur[1]][i]=true;
				select(cnt+1);
				visited[cur[0]][cur[1]][i]=false;
				map[cur[0]][cur[1]]=0;
			}
		}
	}
	
	static boolean check(int x,int y, int number) {//주어진 수가 가능한지
		int x_range=x/3;
		int y_range=y/3;
		for(int i=0;i<size;i++) {//행,열 체크
			if(map[x][i]==number || map[i][y]==number) {
				return false;//현재 숫자 있는 경우
			}
		}
		for(int i=3*x_range;i<3*(x_range+1);++i) {//3x3 체크
			for(int j=3*y_range;j<3*(y_range+1);++j) {
				if(map[i][j]==number) return false;
			}
		}
		return true;
	}
}
