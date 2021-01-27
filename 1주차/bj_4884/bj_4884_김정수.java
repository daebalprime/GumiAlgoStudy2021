// ㅠㅠ
import java.util.Scanner;

class Main
{
	public static int facto(int num) {
		int result = 0;
		for(int i=2;i<=num;i++) {
			result *= i;
		}
		return result;
	}
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			long G = sc.nextLong();
			long T = sc.nextLong();
			long A = sc.nextLong();
			long D = sc.nextLong();
			
			if(G==-1 && T == -1 && A == -1 && D == -1) {
				break;
			}
			
			long teams = (G * A) + D; // 토너먼트 진출 팀
			long game =  G*((T*(T-1))/2); // 조별 게임
			long i=1;

			while(i < teams) {
				game += i;
				i *= 2;
			}
		
			
			System.out.printf("%d*%d/%d+%d=%d+%d\n", G, A, T, D, game , i - teams);

			
		}
	}
}
