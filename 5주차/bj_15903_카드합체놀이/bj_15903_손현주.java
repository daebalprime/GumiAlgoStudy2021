package BJ;
import java.io.*;
import java.util.*;
public class bj_15903_S3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;++i) arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		for(int i=0;i<M;++i) {
			// 맨앞, 맨앞다음거를 더한다.
			long tmp = arr[0] + arr[1];
			// 더한 값을 오버라이트한다.
			arr[0] = tmp;
			arr[1] = tmp;
			// 다시 소팅한다.
			Arrays.sort(arr);
		}
		long sum =0;
		for(int i=0;i<N;++i) sum+=arr[i];
		System.out.println(sum);
	}

}
