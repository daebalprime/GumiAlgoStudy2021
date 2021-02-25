import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//재귀로 했을때 뭔가 함수의 호출이 많아져서 시간초과 날거같은데?
public class Main_bj_1010_다리놓기 {
	//전역 쓸때는 초기화 잘하자.
	static int n,m;
	
	static void ncr() {
		long ms=1;
		long ns=1;
		int k=n;
		if(n>m/2) {
			k=m-n;
			n=k;
		}

		
		for(int i=0;i<k;i++) {
			ms*=m;
			ns*=n;
			m--;
			n--;
		}
		System.out.println(ms/ns);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			String s[]=in.readLine().split(" ");
			//서
			n=Integer.parseInt(s[0]);
			//동
			m=Integer.parseInt(s[1]);
			ncr();
			
		}
		in.close();
	}
}
