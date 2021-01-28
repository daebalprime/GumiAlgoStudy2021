package bj_3052;

import java.util.Scanner;

class bj_3052_윤동현 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] remainder = new int[42];
        int N=10;
        int cnt=0;

        while(N-->0) {
            remainder[sc.nextInt()%42]++;
        }

        for(int i=0; i<remainder.length; i++) {
            if(remainder[i] != 0) cnt++;
        }

        System.out.println(cnt);
        sc.close();
    }//end main
}//end class