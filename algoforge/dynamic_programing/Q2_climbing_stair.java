package algoforge.dynamic_programing;

public class Q2_climbing_stair {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        climbStairs_helper(n, dp);

        return dp[n];
    }

    public int climbStairs_helper(int n, int[] dp){
        // v.imp i missed again : 0 steps chadne ke bhi 1 step h. kuch nai krna...
        if(n==0){   
            return 1;
        }
        if(n<0){    
            return 0;
        }
        
        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = climbStairs_helper(n-1,dp) + climbStairs_helper(n-2,dp);
        return dp[n];
    }
}
