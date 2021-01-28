import java.util.Scanner;

public class bj_2675_서권우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스
		int tc = sc.nextInt();
		for(int i = 0; i<tc; i++) {
			int R = sc.nextInt(); // 반복할 횟수
			String S = sc.next(); // 문자열
			//S의 문자열 추출
			for(int j = 0; j < S.length(); j++) {
				String C = S.substring(j,j+1);
				//추출된 문자열을 R만큼 반복
				for (int k = 0; k < R; k++) {
					System.out.print(C);	
				}
			}
			System.out.println();
			
			
		}
		
		sc.close();
	}

}
