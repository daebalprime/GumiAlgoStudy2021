
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16967_배열복원하기_봉대현 {
	private static int[][]b;

	//배열 B와 X,Y를 주어졌을때 배열 A를 복원하라
	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int H=stoi(st.nextToken());
		int W=stoi(st.nextToken());
		int X=stoi(st.nextToken());
		int Y=stoi(st.nextToken());
		b=new int[H+X][W+Y]; //배열 B
		for(int i=0;i<H+X;i++) { //배열 B입력
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<W+Y;j++)
				b[i][j]=stoi(st.nextToken());
		}
		//배열 b에서 배열 a추출
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(i>=X&&j>=Y)
					b[i][j]-=b[i-X][j-Y];
			}
		}
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++)
				System.out.print(b[i][j]+" ");
			System.out.println();
		}
		in.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
