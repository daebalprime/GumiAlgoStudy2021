import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_s1_14891_톱니바퀴 {

	static LinkedList<Integer>[] gear = new LinkedList[4];
	static int[] direction;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) {
			gear[i] = new LinkedList<>();
		}

		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<8; j++) {
				gear[i].add(stoi(str[j]));
			}
		}
		
		StringTokenizer st = null;
		int k = Integer.parseInt(br.readLine());
		
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int index = stoi(st.nextToken())-1;
			int dir = stoi(st.nextToken());
			direction = new int[4];
			rotationCheck(index, dir);
			rotation();
		}

		int res = 0;
		int idx = 1;
		for(int i=0; i<4; i++) {
			if(gear[i].peekFirst() == 1) {
				res += idx;
			}
			idx *= 2;
		}
		System.out.println(res);
		br.close();
	}

	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void rotationCheck(int index, int dir) {
		direction[index] = dir;
		
		int prev = index-1;
		int next = index+1;
		
		if(prev >= 0 && direction[prev] == 0) {
			if(gear[prev].get(2) != gear[index].get(6)) {
				rotationCheck(prev, dir*-1);
			}
		}
		
		if(next <= 3 && direction[next] == 0) {
			if(gear[next].get(6) != gear[index].get(2)) {
				rotationCheck(next, dir*-1);
			}
		}
	}
	
	static void rotation() {
		for(int i=0; i<4; i++) {
			if(direction[i] == 0) continue;
			if(direction[i] == 1) {
				gear[i].addFirst(gear[i].removeLast());
			} else {
				gear[i].addLast(gear[i].removeFirst());
			}
		}
	}

}