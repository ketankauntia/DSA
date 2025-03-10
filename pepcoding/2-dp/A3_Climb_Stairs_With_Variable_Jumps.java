// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  
//      You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.

// Sample Input
// 10
// 3
// 3
// 0
// 2
// 1
// 2
// 4
// 2
// 0
// 0

// Sample Output
// 5

import java.io.*;
import java.util.*;

public class A3_Climb_Stairs_With_Variable_Jumps {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] jumps=new int[n];
        for(int i=0;i<jumps.length;i++){
            jumps[i]=sc.nextInt();
        }
        int ans = climbWithJumpsTabulation(n,jumps);
        System.out.println(ans);
        sc.close();
    }

    public static int climbWithJumpsTabulation(int n, int jumpsAllowed[]){

        //step 1 storage
        int[] dp=new int[n+1];

        dp[n]=1;
        //direction :left to right n to 0

        //travel and solve
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=jumpsAllowed[i] && (i+j)<dp.length;j++){
                dp[i]+=dp[i+j];
            }
        }

        return dp[0];
    }

}