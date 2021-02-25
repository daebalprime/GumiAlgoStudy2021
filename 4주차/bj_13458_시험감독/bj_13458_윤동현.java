import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] site = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) site[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long cnt=0;
		for(int i=0; i<N; i++) {
			if(site[i] <= B) cnt++;
			else {
				site[i] -= B; cnt++;
				cnt += ((site[i])%C == 0)?(site[i])/C:((site[i])/C+1);
			}
		}
		System.out.println(cnt);
		br.close();
	}
}