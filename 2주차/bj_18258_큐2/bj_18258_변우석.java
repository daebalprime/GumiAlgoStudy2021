package com.ssafy.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_18258_변우석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		String str = null;
		String command = null;
		int last = 0;

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			command = st.nextToken();

			switch (command) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				q.add(value);
				last = value;
				break;

			case "pop":
				if (q.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(q.poll() + "\n");
				}

				break;

			case "size":
				bw.write(q.size() + "\n");
				break;

			case "empty":
				if (q.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;

			case "front":
				if (q.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(q.peek() + "\n");
				}
				break;

			case "back":
				if (q.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(last + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
