package bj_2346;

import java.util.LinkedList;
import java.util.Scanner;

public class bj_2346_윤동현 {
    static class Point {
        int index;
        int move;
        Point(int index,int move) {
            this.index = index;
            this.move = move;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        LinkedList<Point> deque = new LinkedList<Point>();
        for(int i=1; i<=N; i++) {
            int move = sc.nextInt();
            deque.add(new Point(i, move));
        }
        int now = 0;
        int val = 0;
        for(int i=0; i<N; i++) {
            if(val > 0) {
                for(int j=0; j<val-1; j++) {
                    ++now;
                    if(now >= deque.size()) now = 0;
                }
            } else if(val < 0) {
                val *= -1;
                for(int j=0; j<val; j++) {
                    --now;
                    if(now < 0) now = deque.size()-1;
                }
            }
            Point p = deque.get(now);
            val = p.move;
            System.out.print(p.index + " ");
            deque.remove(now);
            if(now == deque.size()) now=0;
        }
        sc.close();
    }
}
