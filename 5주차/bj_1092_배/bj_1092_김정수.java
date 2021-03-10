package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1092 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st= new StringTokenizer(in.readLine());
		ArrayList <Integer>crane = new ArrayList<>();
		for(int i=0;i<N;i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(in.readLine());
		ArrayList <Integer>arr = new ArrayList<>();
		st= new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crane, (o1, o2)->{return o2-o1;});
		Collections.sort(arr, (o1, o2)->{return o2-o1;});
		
		int time = 1;
		int remain = M;
		loop: while(true) {
			boolean flag = false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<arr.size();j++) {
					if(arr.get(j) <= crane.get(i)) {
						flag = true;
						arr.remove(j);
						remain--;
						if(remain == 0) break loop;
						break;
					}
					
				}
			}
			
			if(!flag) {
				time = -1;
				break;
			}
			if(remain == 0) break;
			
			time++;
		}
		
		System.out.println(time);
	}

}
