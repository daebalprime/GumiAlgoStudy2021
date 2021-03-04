import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

	static ArrayList<String> ans = new ArrayList<>();
	static boolean[] visited = new boolean[10];
	static char[] str = new char[10];
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) str[i] = st.nextToken().charAt(0);

		dfs("",0);
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));

		br.close();
	}

	static void dfs(String s, int cnt) {
		if(cnt == k+1) {
			ans.add(s);
			return;
		}
		for(int i=0; i<10; i++) {
			if(visited[i]) continue;
			if(cnt == 0 || chk(s.charAt(cnt-1), (char)(i+'0'), str[cnt-1])) {
				visited[i] = true;
				dfs(s+Integer.toString(i), cnt+1);
				visited[i] = false;
			}
		}
	}

	static boolean chk(char a, char b, char c) {
		if (c == '<') {
			if (a > b) {
				return false;
			}
		}
		if (c == '>') {
			if (a < b) {
				return false;
			}
		}
		return true;
	}
}//end class