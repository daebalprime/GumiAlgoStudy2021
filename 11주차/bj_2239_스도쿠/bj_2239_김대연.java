package bj_2239;

import java.io.*;
import java.util.*;

public class Main {
	static List<HashSet<Integer>> rowCheck, colCheck, recCheck;
	static ArrayList<int[]> cand = new ArrayList<>();
	static int remained;
	static int[][] sudoku;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sudoku = new int[9][9];
		rowCheck = new ArrayList<HashSet<Integer>>();
		colCheck = new ArrayList<HashSet<Integer>>();
		recCheck = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < 9; i++) {
			rowCheck.add(new HashSet<>());
			colCheck.add(new HashSet<>());
			recCheck.add(new HashSet<>());
		}
		remained = 0;
		for(int j = 0; j < 9; j++) {
			String tmp = br.readLine();
			for(int i = 0; i < 9; i++) {
				int t = tmp.charAt(i) - '0';
				if(t != 0) {
					sudoku[j][i] = t;
					rowCheck.get(j).add(t);
					colCheck.get(i).add(t);
					recCheck.get(i/3+(j/3)*3).add(t);
				}
				else {
					++remained;
					cand.add(new int[] {i,j});
				}
			}
		}
		recur(0);
		br.close();
		bw.close();
	}
	static void recur(int idx) {
		if(idx == remained) {
			//print;
			StringBuilder result = new StringBuilder();
			for(int[] ia : sudoku) {
				for(int i : ia) {
					result.append(i);
				}
				result.append("\n");
			}
			System.out.println(result.toString());
			System.exit(0);
		}
		int x = cand.get(idx)[0];
		int y = cand.get(idx)[1];
		for(int i = 1; i <= 9; i++) {
			if(!rowCheck.get(y).contains(i) && !colCheck.get(x).contains(i) && !recCheck.get(x/3+(y/3)*3).contains(i)) {
				rowCheck.get(y).add(i);
				colCheck.get(x).add(i);
				recCheck.get(x/3+(y/3)*3).add(i);
				sudoku[y][x] = i;
				recur(idx+1);
				sudoku[y][x] = 0;
				rowCheck.get(y).remove(i);
				colCheck.get(x).remove(i);
				recCheck.get(x/3+(y/3)*3).remove(i);
			}
		}
	}

}
