import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Star[] stars = new Star[N];
		parents = new int[N];
		
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		ArrayList<Comparator<Star>> cmp = new ArrayList<Comparator<Star>>();
		cmp.add((o1,o2)-> Integer.compare(o1.x, o2.x));
		cmp.add((o1,o2)-> Integer.compare(o1.y, o2.y));
		cmp.add((o1,o2)-> Integer.compare(o1.z, o2.z));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			stars[i] = new Star(x,y,z,i);
		}
		for(int i = 0; i < 3; i++) {
			Arrays.sort(stars, cmp.get(i));
			for(int j = 0; j < stars.length-1; j++) {
				pq.offer(new int[] {stars[j].id, stars[j+1].id, stars[j].distance(stars[j+1])});
			}
		}
		int count = 0;
		long answer = 0;
		while(!pq.isEmpty() && count != N) {
			int[] curr = pq.poll();
			int a = curr[0];
			int b = curr[1];
			int weight = curr[2];
			if(union(a,b)) {
				answer += weight;
			}
		}
		System.out.println(answer);
		
		br.close();
	}
	
	static int findSet(int i) {
		if(parents[i] == i) return i;
		return parents[i] = findSet(parents[i]);
	}
	
	static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa==pb) return false;
		parents[pb] = pa;
		return true;
	}
	
	static class Star{
		final int x;
		final int y;
		final int z;
		final int id;
		public Star(int x, int y, int z, int id) {
			super();
			this.x = 1000000000+x;
			this.y = 1000000000+y;
			this.z = 1000000000+z;
			this.id = id;
		}
		
		public int distance(Star b) {
			return Math.min(Math.abs(x-b.x),Math.min(Math.abs(y-b.y), Math.abs(z-b.z)));
		}
	}
}