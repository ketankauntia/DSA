// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.  You can of-course fewer number of steps in the move.
// 4. You are required to print the number of minimum moves in which you can reach the top of staircase.
// Note -> If there is no path through the staircase print null.

import java.io.*;
import java.util.*;

public class A4_Climb_Stairs_With_Minimum_Moves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = sc.nextInt();
        }
        int ans = minMovesPath(n, moves);
        System.out.println(ans);
        sc.close();
    }

    public static int minMovesPath(int n, int[] moves) {

        // why Integer[] and not int[]? -> Integer[] has default null vs 0 in int.
        Integer[] dp = new Integer[n + 1];

        // step 2 : direction from n to 0.
        // how? 10 to 10 is small vs 0 to 10.. so small to big will be the direction so, 10 to 0.
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (moves[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= moves[i] && i + j < dp.length; j++) {

                    if (dp[i + j] != null) { 
                        // edge case here is that null will also participate.. we cannot allow that.. since it will be the least but will never lead to the final 10th index.hence,

                        min = Math.min(min, dp[i + j]);
                    }

                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1; // 1 step to go to the next cell and from that cell to 10th is min. so 1+min
                }

            }
        }

        return dp[0];
    }

}