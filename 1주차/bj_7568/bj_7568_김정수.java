import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for(int i=0;i<N;i++) {
			arr[i][0] = i;
			for(int j=1;j<3;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int [] rank = new int[N];
		
		for(int i=0;i<N;i++) {
			int betterScore = 1;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(arr[j][1] > arr[i][1] && arr[j][2] > arr[i][2]) {
					betterScore ++;
				}
			}
			rank[i] = betterScore;
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(rank[i] + " ");
		}
		
	}

}