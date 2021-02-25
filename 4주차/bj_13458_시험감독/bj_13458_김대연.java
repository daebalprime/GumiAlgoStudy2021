package bj_13458;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long answer = N;
		for(int i = 0; i < N; i++) {
			int ai = Integer.parseInt(st2.nextToken()) - main;
			if(ai > 0 ) {
				answer += Math.ceil((double)(ai - main) / sub);
			}
		}
		System.out.println(answer);
		br.close();
	}

}
