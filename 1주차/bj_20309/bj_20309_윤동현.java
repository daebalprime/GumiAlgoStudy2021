package bj_20309;

import java.util.Scanner;

public class bj_20309_윤동현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1; i<=N; i++) {
            int num = sc.nextInt();
            if(i%2 != num%2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}