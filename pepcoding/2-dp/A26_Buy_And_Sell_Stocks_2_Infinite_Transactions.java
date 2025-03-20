// ########  Buy And Sell Stocks - Infinite Transactions Allowed  ##########


// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)


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
// 30



import java.io.*;
import java.util.*;

public class A26_Buy_And_Sell_Stocks_2_Infinite_Transactions {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int bd=0;
        int sd=0;
        int profit =0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                sd++;
            } else{
                profit+=arr[sd]-arr[bd];
                sd=bd=i;
            }
        }
        System.out.println(profit);
        sc.close();
    }

}