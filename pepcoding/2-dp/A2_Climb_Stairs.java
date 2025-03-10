// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
// 4. You are required to print the number of different paths via which you can climb to the top.

import java.io.*;
import java.util.*;

public class A2_Climb_Stairs {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int ans = climbStarsMemoized(n,new int[n+1]);
        int ans= climbStairsTabulized(n);
        System.out.println(ans);
        sc.close();
    }
    
    //memozied approach
    public static int climbStarsMemoized(int n, int qb[]){

        if(n==0){
            return 1;
        } else if(n<0){
            return 0;
        }

        if(qb[n]>0){
            return qb[n];
        }
        
        //finding all possible paths
        int pathnm1 = climbStarsMemoized(n-1, qb);
        int pathnm2 = climbStarsMemoized(n-2, qb);
        int pathnm3 = climbStarsMemoized(n-3, qb);
        int totalCount = pathnm1+pathnm2+pathnm3;

        qb[n]=totalCount;

        return totalCount;
    }


    //tabulation approach
    public static int climbStairsTabulized(int n){
        //step 1 : create storage
        int[] dp = new int [n+1];

        //step 2 : identify direction of problem
        // 0 to n

        //step 3 : travel and solve
        dp[0] = 1;

        for(int i=1;i<n+1;i++){
            if(i==1){
                dp[i]=dp[i-1];
            } else if(i==2){
                dp[i]=dp[i-1]+dp[i-2];
            } else{
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        
        return dp[n];
    }
}