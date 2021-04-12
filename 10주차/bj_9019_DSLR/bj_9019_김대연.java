import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[] opName = {'D', 'S', 'L', 'R'};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int[] min = new int[10000];
			int[] prev = new int[10000];
			int[] op = new int[10000];
			Arrays.fill(min, -1);
			Arrays.fill(prev, -1);
			Queue<State> q = new ArrayDeque<State>();
			q.offer(new State(from,0));
			while(!q.isEmpty()) {
				State tmp = q.poll();
				int curr = tmp.getCurr();
				int depth = tmp.getDepth();
				int p = tmp.getPrev();
				int pOp = tmp.getOper();
				if(min[curr]==-1) {
					min[curr]=depth;
					prev[curr] = p;
					op[curr] = pOp;
				}
				else if(min[curr] <= depth) {
					continue;
				}
				else {
					min[curr] = depth;
					prev[curr] = p;
					op[curr] = pOp;
				}
				if(curr==to) {
					StringBuilder localAns = new StringBuilder();
					int revCurr = to;
					while(revCurr != from) {
						char revOp = opName[op[revCurr]];
						localAns.append(revOp);
						revCurr = prev[revCurr];
					}
					sb.append(localAns.reverse().append("\n"));
					break;
				}
				q.offer(new State(dOper(curr),depth+1, curr, 0));
				q.offer(new State(sOper(curr),depth+1, curr, 1));
				q.offer(new State(lOper(curr),depth+1, curr, 2));
				q.offer(new State(rOper(curr),depth+1, curr, 3));	
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int dOper (int x) {
		return (x*2)%10000;
	}
	static int dInverseOper1 (int x) {
		return x/2;
	}
	static int dInverseOper2 (int x) {
		return (x+10000)/2;
	}
	
	static int sOper (int x) {
		return (10000+x-1)%10000;
	}
	static int sInverseOper (int x) {
		return (x+1)%10000;
	}
	
	
	static int lOper (int x) {
		int tmp = x/1000;
		return (x * 10) % 10000 + tmp;
	}
	static int rOper (int x) {
		int tmp = x % 10;
		return (x / 10) + tmp*1000;
	}
	
	static class State{
		int curr;
		int depth;
		int prev;
		int oper;
		public State(int curr, int depth, int prev, int oper) {
			super();
			this.curr = curr;
			this.depth = depth;
			this.prev = prev;
			this.oper = oper;
		}
		public int getOper() {
			return oper;
		}
		public void setOper(int oper) {
			this.oper = oper;
		}
		public State(int curr, int depth, int prev) {
			super();
			this.curr = curr;
			this.depth = depth;
			this.prev = prev;
		}
		public int getPrev() {
			return prev;
		}
		public void setPrev(int prev) {
			this.prev = prev;
		}
		public int getCurr() {
			return curr;
		}
		public void setCurr(int curr) {
			this.curr = curr;
		}
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		public State(int curr, int depth) {
			super();
			this.curr = curr;
			this.depth = depth;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("State [curr=").append(curr).append(", depth=").append(depth).append(", prev=").append(prev)
					.append("]");
			return builder.toString();
		}
		
	}

}
