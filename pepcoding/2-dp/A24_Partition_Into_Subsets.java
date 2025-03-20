// 1. You are given a number n, representing the number of elements.
// 2. You are given a number k, representing the number of subsets.
// 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
// E.g.
// For n = 4 and k = 3 total ways is 6
// 12-3-4
// 1-23-4
// 13-2-4
// 14-2-3
// 1-24-3
// 1-2-34

// Sample Input
// 4
// 3

// Sample Output
// 6


import java.io.*;
import java.util.*;

public class A24_Partition_Into_Subsets {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here

        if(n==0 || k==0 || n<k){
            return 0;
        }

        long[][] dp= new long[k+1][n+1];
        for(int t=1;t<=k;t++){
            for(int p=1;p<=n;p++){
                if(p<t){
                    dp[t][p]=0;
                } else if(p==t){
                    dp[t][p]=1;
                } else{
                    dp[t][p] = dp[t][p-1]*t + dp[t-1][p-1];
                }
            }
        }
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
        scn.close();
    }
}