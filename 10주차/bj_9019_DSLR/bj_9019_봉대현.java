package a_10weeks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

//시간초과
public class Main_bj_9019_DSLR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String []result=new String[10000];
			Arrays.fill(result,"");
			ArrayDeque<Integer> q = new ArrayDeque<>();
			boolean visited[]=new boolean[10000];
			
			visited[a]=true;
			q.add(a);
			while (!q.isEmpty()) {
				int cnt = q.poll();
				int D=(2*cnt)%10000;
				int S=(cnt==0)?9999:cnt-1;
				int L=(cnt%1000)*10+cnt/1000;
				int R=(cnt%10)*1000+cnt/10;
				
				if(!visited[D]) {
					q.add(D);
					visited[D]=true;
					result[D]=result[cnt]+"D";
				}
				if(!visited[S]) {
					q.add(S);
					visited[S]=true;
					result[S]=result[cnt]+"S";
				}
				if(!visited[L]) {
					q.add(L);
					visited[L]=true;
					result[L]=result[cnt]+"L";
				}
				if(!visited[R]) {
					q.add(R);
					visited[R]=true;
					result[R]=result[cnt]+"R";
				}
			}
			
			System.out.println(result[b]);
		}
		sc.close();
	}

}
