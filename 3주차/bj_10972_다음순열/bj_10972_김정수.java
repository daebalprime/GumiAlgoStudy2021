package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b10972 {
	static int[] arr;
	static int N;
	static boolean[] isSelected;
	static int[] numbers;
	static int check = 0;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0, 0);
		
		if(check == 1)
			System.out.println("-1");
	}
	
	static void permutation(int cnt, int same) {
		if(cnt == N) {
			if(check == 1) {
				for(int i=0;i<N;i++) {
					System.out.print(numbers[i]+" ");
				}
				System.out.println();
			}
				
			check ++;
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!isSelected[i]) {
				if(arr[cnt] == i) {
					numbers[cnt] = i;
					isSelected[i] = true;
					permutation(cnt+1, same+1);
					isSelected[i] = false;
				}
				else if(check == 1) {
					numbers[cnt] = i;
					isSelected[i] = true;
					permutation(cnt+1, same+1);
					isSelected[i] = false;
				}
				
			}
		}
	}

}
