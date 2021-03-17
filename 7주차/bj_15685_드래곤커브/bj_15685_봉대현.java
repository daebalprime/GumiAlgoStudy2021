package a_7weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_15685_드래곤커브 {
	static boolean map[][];
	static int x,y,d,g;
	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		map=new boolean[101][101];
		int n=Integer.parseInt(in.readLine());
		//드래곤 커브
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			y=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			g=Integer.parseInt(st.nextToken());
			//시작점
			map[y][x]=true;

			ArrayList<int []>glist=new ArrayList<>();
			//0세대 생성
			updated(d);
			map[y][x]=true;
			glist.add(new int[] {y,x,d});
			for(int j=1;j<=g;j++) {
				generation(glist);
			}
		}
		int ans=0;
		//정사각형 개수세기
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(i+1>=101|| j+1>=101)continue;
				if(map[i][j]&&map[i][j+1]&&map[i+1][j]&&map[i+1][j+1])
					ans++;
			}
		}
		System.out.println(ans);
		in.close();
	}
	//시계회전-> 방향이 +1인걸로 된다. 끝점에서 부터 시작된리스트부터
	static void generation(ArrayList<int []>glist) {
		//끝점부터 
		int size=glist.size();
		for(int i=size-1;i>=0;i--) {
			int next_d=glist.get(i)[2]+1;
			updated(next_d);
			map[y][x]=true;
			glist.add(new int [] {y,x,next_d});
		}

	}
	//격자밖으로안나간다.
	static void updated(int d) {
		d%=4;
		if(d==0) {
			y+=1;
		}
		else if(d==1) {
			x-=1;
		}
		else if(d==2) {
			y-=1;
		}else {
			x+=1;
		}
	}
}
