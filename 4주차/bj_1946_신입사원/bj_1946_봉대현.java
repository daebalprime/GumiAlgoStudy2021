import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946_신입사원_봉대현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());// 테케
		for (int p = 0; p < t; p++) {
			int n = Integer.parseInt(in.readLine());// 신입사원 수
			People []plist=new People[n]; 
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				plist[i]= new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(plist);// 서류 성적으로 오름차순 정렬 -> 맨앞은 서류 1등은 무조건 패스
			int ans=1;
			int big=plist[0].y;
			//통과한 사람의 면접 성적을 가지고 비교해가면서 높은 성적이면 교체
			for(int i=1;i<n;i++) {
				if(big>plist[i].y) {
					big=plist[i].y;
					ans+=1;
				}
			}
			System.out.println(ans);
		}
		in.close();
	}

	static class People implements Comparable<People>{//신입사원 서류성적 및 면접성적
		int x;
		int y;

		public People(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(People o) {
			return this.x-o.x;
		}

	}
}
