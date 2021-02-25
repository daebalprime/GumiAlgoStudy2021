import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수_봉대현 {
	static int map[][];
	static int a,b,c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());// 종이의 크기
		map=new int[n][n];
		for(int i=0;i<n;i++)
		{
			StringTokenizer st=new StringTokenizer(in.readLine()," ");
			for(int j=0;j<n;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		cal(0,0,n);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	private static void cal(int x,int y,int n) {
		int num=map[x][y];
		if(n==1) {
			if(num==-1)
				a++;
			else if(num==0)
				b++;
			else
				c++;
			return;
		}
		else {
			boolean check=false;
			//범위 내 종이 체크
			loop:for(int i=x;i<x+n;i++)
			{
				for(int j=y;j<y+n;j++) {
					if(num !=map[i][j]) {
						check=true;
						break loop;
					}
				}
			}
			if(check) { //분할
				cal(x,y,n/3);//1번
				cal(x,y+n/3,n/3);//2번
				cal(x,y+n/3*2,n/3);//3번
				cal(x+n/3,y,n/3);//4번
				cal(x+n/3,y+n/3,n/3);//5번
				cal(x+n/3,y+n/3*2,n/3);//6번
				cal(x+n/3*2,y,n/3);//7번
				cal(x+n/3*2,y+n/3,n/3);//8번
				cal(x+n/3*2,y+n/3*2,n/3);//9번
			}
			else {
				if(num==-1)
					a++;
				else if(num==0)
					b++;
				else
					c++;
				return;
			}
		}
	}

}
