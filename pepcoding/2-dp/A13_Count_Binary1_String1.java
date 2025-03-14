// 1. You are given a number n.
// 2. You are required to print the number of binary strings of length n with no consecutive 0's.

import java.io.*;
import java.util.*;

public class A13_Count_Binary1_String1{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();

    int[] dp0 = new int[n+1];
    int[] dp1 = new int[n+1];

    dp0[1]=1;
    dp1[1]=1;

    for(int i=1; i<=n; i++){
        dp1[i] = dp1[i-1] + dp0[i-1];
        dp0[i] = dp1[i-1];
    }
    System.out.println(dp1[n]+dp0[n]);
    sc.close();
 }

}