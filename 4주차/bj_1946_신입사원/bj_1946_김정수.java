package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1946 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[N][2];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());

				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			Arrays.sort(arr, (o1, o2)->{
				return o1[0]==o2[0] ? (o1[1]-o2[1]): (o1[0]-o2[0]);
			});
			
			int limit1 = arr[0][0];
			int limit2 = arr[0][1];
			for(int i=0;i<N;i++) {
				if(arr[i][0] > limit1 && arr[i][1] > limit2) {
					continue;
				}else {
					if(arr[i][0]<limit1) {
						limit1 = arr[i][0];
						
					}
					if(arr[i][1]<limit2) {
						limit2 = arr[i][1];
					}
					count++;
				}
			}
			
			System.out.println(count);
		}
	}

}
