// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of permutations of the n coins using which the 
//      amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
//                   used for many installments in payment of "amt"
// Note2 -> You are required to find the count of permutations and not combinations i.e.
//                   2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
//                   combination. You should treat them as 3 and not 1.


// Sample Input
// 4
// 2
// 3
// 5
// 6
// 7

// Sample Output
// 5


import java.io.*;
import java.util.*;

public class A9_Coin_Change_Permutation {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i]=sc.nextInt();
        }
        int targetAmt = sc.nextInt();

        int dp[] = new int[targetAmt+1];
        dp[0]=1;

        for(int i=1;i<=targetAmt;i++){    // for each amount level in dp
            for(int coin: coins){  //each coin
                // jo coin hum istemal kar re wo target se kam ho.. usko hi use krenge.
                if(coin <= i){  // i is amount of that level here
                    int remainingAmt = i - coin;
                    dp[i]+=dp[remainingAmt];
                }
            }
        }
        System.out.println(dp[targetAmt]);
        sc.close();
    }
}