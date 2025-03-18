// 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.

// Sample Input
// 8
// 3

// Sample Output
// 3672

import java.io.*;
import java.util.*;

public class A20_Paint_Fence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k= sc.nextInt();

        long same = k*1;
        long diff = k * (k-1);
        long total = same+diff;

        for(int i=3;i<=n;i++){
            same = diff*1;
            diff = total*(k-1);
            total = same+diff;
        }
        System.out.println(total);
        sc.close();
    }
}