// ######## Buy And Sell Stocks - One Transaction Allowed ##########

// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed a single transaction.


// Sample Input
// 9
// 11
// 6
// 7
// 19
// 4
// 1
// 6
// 18
// 4

// Sample Output
// 17


import java.io.*;
import java.util.*;

public class A25_Buy_And_Sell_Stocks_1 {

    // ## Buy And Sell Stocks - One Transaction Allowed ##
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price[] = new int[n];
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }

        int leastSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profitForDay = 0;
        for(int i=0;i<n;i++){
            if(price[i]<leastSoFar){
                leastSoFar=price[i];
            }

            profitForDay = price[i]-leastSoFar;

            if(profitForDay>maxProfit){
                maxProfit=profitForDay;
            }
        }
        System.out.println(maxProfit);
        sc.close();
    }

}