package a_5weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//참고 https://kwoncorin.tistory.com/54
public class Main_bj_5904_Moo게임 {
	//S(X-1)+m+o가 K+2개 +S(X-1)
	public static void main(String[] args) throws Exception{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		
		call(n);
		in.close();
	}
	static void call(int num)
	{
		int size=3;
		int index=0;//m의 위치표시
		if(num==1)
		{
			System.out.println("m");
			return;
		}
		else if(num<=3) {
			System.out.println("o");
			return;
		}
		else {
			while(size<num) {
				size=size+index+4+size;
				index++;
			}
			int sx_1=(size-index-3)/2; //sx_1의 길이 3은 o의 개수
			
			if(size-sx_1+1<=num) { //뒤의 S(X-1)에서 n번째의 문자를 찾기
				call(num-size+sx_1);
			}else if(num==sx_1+1)//m의 위치
			{
				System.out.println("m");
				return;
			}else {
				System.out.println("o");
				return;
			}
		}
		
	}
}
