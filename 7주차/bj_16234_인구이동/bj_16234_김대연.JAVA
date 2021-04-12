import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0};
	static int[] dj = {0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		int mark = 1;
		HashMap<Coord, LinkedList<Coord>> hm = new HashMap<>();
		Queue<Coord> q = new LinkedList<Coord>();
		LinkedList<Coord> ll = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		boolean flag = false;
		do {
			flag = false;
			for(int j = 0; j < N; j++) {
				for(int i = 0; i < N; i++) {
					int point = map[j][i];
					for(int k = 0; k < 2; k++) {
						int nx = i + di[k];
						int ny = j + dj[k];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
							int nPoint = map[ny][nx];
							int diff = Math.abs(point-nPoint);
							if(diff >= L && diff <= R) {
								flag = true;
								Coord nc = new Coord(nx,ny);
								Coord pc = new Coord(i,j);
								if(!hm.containsKey(nc)) {
									hm.put(nc, new LinkedList<>());
								}
								if(!hm.containsKey(pc)) {
									hm.put(pc, new LinkedList<>());
								}
								hm.get(nc).offer(pc);
								hm.get(pc).offer(nc);
							}
						}
					}
				}
			}
			while(!hm.isEmpty()) {
				Coord curr = hm.keySet().iterator().next();
				mark(visited, curr, mark);
				q.offer(curr);
				ll.offer(curr);
				int total = getPop(map, curr);
				int count = 1;
				while(!q.isEmpty()) {
					LinkedList<Coord> next = hm.get(q.peek());
					hm.remove(q.poll());
					for(Coord c : next) {
						if(!isVisited(visited, c, mark)) {
							mark(visited, c, mark);
							total += getPop(map, c);
							count++;
							q.offer(c);
							ll.offer(c);
						}
					}
				}
				
				int avg = total/count;
				while(!ll.isEmpty()) {
					setPop(map, ll.poll(), avg);
				}
			}
			mark++;
			if(flag)answer++;
		} while(flag);
		System.out.println(answer);
		br.close();
	}
	
	static int getPop(int[][] map, Coord c) {
		return map[c.getY()][c.getX()];
	}
	static void setPop(int[][] map, Coord c, int population) {
		map[c.getY()][c.getX()] =  population;
	}
	
	static void mark(int[][] visited, Coord c, int mark) {
		visited[c.getY()][c.getX()] = mark;
	}
	static boolean isVisited(int[][] visited, Coord c, int mark) {
		return visited[c.getY()][c.getX()] == mark;
	}
}

class Coord{
	private int x, y;
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coord)) {
			return false;
		}
		Coord other = (Coord) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coord [x=").append(x).append(", y=").append(y).append("]");
		return builder.toString();
	}
	
}
