
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_13458_시험감독_봉대현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());//응시장 수
		long ans=0; //100만개라서 int 형으로 할때 오버플로우가 발생할수 있다.
		int []plist=new int[N];
		StringTokenizer st=new  StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) //응시장 명 수 입력
			plist[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(in.readLine());
		int b=Integer.parseInt(st.nextToken());//총감독 감시 명 수
		int c=Integer.parseInt(st.nextToken());// 부감독 감시 명 수
		
		for(int i=0;i<N;i++) {
			long num=plist[i];
			if(num>0) {//총감독관은 1명은 필수
				num-=b;
				ans+=1;
			}
			if(num>0) {//부감독관 여러명
				ans+=num/c;
				if(num%c!=0)
					ans+=1;
			}
		}
		System.out.println(ans);
		in.close();
	}
}
