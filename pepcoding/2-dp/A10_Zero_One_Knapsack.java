// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//      overflowing it's capacity.

// Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
//                again and again.


// Sample Input
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7

// Sample Output
// 75


import java.io.*;
import java.util.*;

public class A10_Zero_One_Knapsack {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int value[]=new int[n];
        int weight[]=new int[n];
        for(int i=0;i<n;i++){
            value[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        int capacity = sc.nextInt();
        int[][] dp = new int [n+1][capacity+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                if(j>=weight[i-1])
                {
                    int remCapacity = j - weight[i-1];
                    if(dp[i-1][remCapacity]+value[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][remCapacity]+value[i-1];
                    } else{
                        dp[i][j]=dp[i-1][j];
                    }
                } else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][capacity]);
        sc.close();
    }
}