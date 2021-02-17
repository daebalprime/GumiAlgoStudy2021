import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_5582_공통부분문자열 {
	// 다시 깃허브에 재업로드 해야됨 빈코드로 올라감
	// 슬라이딩 윈도우 or LCS 알고리즘 dp
	//LCS에는 공통 부분 문자열 or 공통 부분 순열이 존재한다.
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char [] s = in.readLine().toCharArray();
		char []s1 = in.readLine().toCharArray();
		int res=0;
		
		int dp[][]=new int[s.length+1][s1.length+1];
		
		for(int i=1;i<=s.length;i++) {
			for(int j=1;j<=s1.length;j++) {
				if(s[i-1]==s1[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				res=Math.max(res, dp[i][j]);
			}
		}
		
		System.out.println(res);

	}
}
