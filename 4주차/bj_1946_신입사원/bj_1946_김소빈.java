import java.io.*;
import java.util.*;
public class Main {
	public static class node{
		private int idx, doc, inter;
		public node(int d, int i){
			this.doc = d;
			this.inter = i;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			node [] per = new node[N];
			for(int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				per[i] = new node(Integer.parseInt(tmp[0]) , Integer.parseInt(tmp[1]));
			}
			Arrays.sort(per, (o1, o2)->o1.doc-o2.doc);
			int ans = N;
			int cmp = per[0].inter;
			for(int i = 1; i < N; i++) {
				if(cmp < per[i].inter) ans--;
				else cmp = per[i].inter;
			}
			System.out.println(ans);
		}
		
	}
}