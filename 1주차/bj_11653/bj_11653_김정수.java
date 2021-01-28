import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 일반 반복문
		int num = 2;
		while(num <= N) {
			if(N%num == 0) {
				System.out.println(num);
				N /= num;
			}else {
				num ++;
			}
		}
	}

}
