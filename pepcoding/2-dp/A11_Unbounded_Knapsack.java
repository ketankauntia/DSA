// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//     overflowing it's capacity.
// Note -> Each item can be taken any number of times. You are allowed to put the same item again 
//                   and again.

// Sample Input
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7

// Sample Output
// 100

import java.io.*;
import java.util.*;

public class A11_Unbounded_Knapsack {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int vals[] = new int[n];
        for(int i=0;i<n;i++){
            vals[i]=sc.nextInt();
        }
        int weights[] = new int[n];
        for(int i=0;i<n;i++){
            weights[i]=sc.nextInt();
        }
        int capacity = sc.nextInt();

        int[] dp = new int[capacity+1];
        dp[0]=0;

        for(int bagCapacity=1; bagCapacity<=capacity; bagCapacity++){
            
            int max = 0;
            for(int j=0;j<n;j++){
                if(weights[j]<=bagCapacity){
                    int remBagCap = bagCapacity-weights[j];
                    int remBagVal = dp[remBagCap];

                    int totalBagVal = remBagVal+vals[j];

                    if(totalBagVal>max){
                        max = totalBagVal;
                    }
                }
            }
            dp[bagCapacity] = max;
        }
        System.out.println(dp[capacity]);
        sc.close();
    }
}