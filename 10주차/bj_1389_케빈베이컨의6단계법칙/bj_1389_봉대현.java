package a_10weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1389_케빈베이컨의6단계 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Person>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(new Person(to, 1));
			graph[to].add(new Person(from, 1));
		}
		int[] distance = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ArrayDeque<Person> q = new ArrayDeque<>();
			boolean visited[] = new boolean[n + 1];
			visited[i] = true;
			q.offer(new Person(i, 1));

			while (!q.isEmpty()) {
				Person cnt = q.poll();

				for (Person t : graph[cnt.to]) {
					if (!visited[t.to]) {
						distance[i] += cnt.d;
						q.offer(new Person(t.to, cnt.d + 1));
						visited[t.to] = true;
					}
				}
			}
		}
		//System.out.println(Arrays.toString(distance));
		int min=distance[1];
		int idx=1;
		for(int i=1;i<=n;i++) {
			if(distance[i]<min) {
				idx=i;
				min=distance[i];
			}
			else if(distance[i]==min&&idx>i) {
				idx=i;
			}
		}
		System.out.println(idx);
		in.close();

	}

	static class Person {

		int to;
		int d;

		public Person(int to, int d) {
			super();
			this.to = to;
			this.d = d;
		}

	}
}
