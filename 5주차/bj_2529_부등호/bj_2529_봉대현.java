package a_5weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2529_부등호 {
	static String [] sign;
	static int k,maxv,minv;
	static int []max_list;
	static int []min_list;
	static boolean []issel;
	static int [] pick;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(in.readLine());
		sign=in.readLine().split(" ");
		issel=new boolean[10];
		max_list=new int[k+1];
		min_list=new int[k+1];
		pick=new int[k+1];
		maxv=Integer.MIN_VALUE;
		minv=Integer.MAX_VALUE;
		combi(0);
		for(int i=0;i<k+1;i++) {
			System.out.print(max_list[i]);
		}
		System.out.println();
		for(int i=0;i<k+1;i++) {
			System.out.print(min_list[i]);
		}
		in.close();
	}
	static void combi(int cnt) {
		if(cnt==k+1) {
			if(!check(pick))
				return;
			
			int sum=0;
			for(int i=0;i<k+1;i++)
				sum+=pick[i];
			
			if(maxv<=sum) {
				maxv=sum;
				for(int i=0;i<k+1;i++) {
					max_list[i]=pick[i];
				}
			}
			if(minv>sum) {
				minv=sum;
				for(int i=0;i<k+1;i++) {
					min_list[i]=pick[i];
				}
			}
			return;
		}
		for(int i=0;i<=9;i++) {
			if(issel[i]) continue;
			pick[cnt]=i;
			issel[i]=true;
			combi(cnt+1);
			issel[i]=false;
		}
	}
	//대소관계 적절한지
	static boolean check(int [] pick) {
		for(int i=0;i<k;i++) {
			if(sign[i].equals("<")) {
				if(pick[i]>=pick[i+1])
					return false;
			}else {
				if(pick[i]<=pick[i+1])
					return false;
			}
		}
		return true;
	}
}
