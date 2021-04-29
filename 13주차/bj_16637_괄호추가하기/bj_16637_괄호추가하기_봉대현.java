package a_13weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_bj_16637_괄호추가하기 {
	static int ans;
	static ArrayList<Integer>nums;
	static ArrayList<Character>oper;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		nums=new ArrayList<>();
		oper=new ArrayList<>();
		char s[]=in.readLine().toCharArray();
		for(int i=0;i<n;i++) {
			if(s[i]=='+' ||s[i]=='-'||s[i]=='*')
				oper.add(s[i]);
			else
				nums.add(s[i]-'0');
		}
		ans=Integer.MIN_VALUE;
		solve(0,nums.get(0));
		System.out.println(ans);
		in.close();
	}
	static void solve(int opidx,int sum) {
		if(opidx>=oper.size()) {
			ans=Math.max(ans, sum);
			return;
		}
		
		//괄호가 없는 경우
		int temp=cal(sum,oper.get(opidx),nums.get(opidx+1));
		solve(opidx+1, temp);
		
		//괄호가 있는 경우
		if(opidx+1<oper.size()) {
			//오른쪽부터 계산
			int temp1=cal(nums.get(opidx+1),oper.get(opidx+1),nums.get(opidx+2));
			
			//왼쪽 +오른쪽
			solve(opidx+2,cal(sum,oper.get(opidx),temp1));
		}
	}
	static int cal(int a,char op,int b) {
		if(op=='+') {
			return a+b;
		}
		else if(op=='-')
			return a-b;
		else
			return a*b;
	}
}
