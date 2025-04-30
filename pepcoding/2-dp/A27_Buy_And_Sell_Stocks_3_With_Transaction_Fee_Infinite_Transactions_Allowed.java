// ###### Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed #######

// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are give a number fee, representing the transaction fee for every transaction.
// 4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

// Sample Input
// 12
// 10
// 15
// 17
// 20
// 16
// 18
// 22
// 20
// 22
// 20
// 23
// 25
// 3
 
// Sample Output
// 13




// explanation bilkul nai samajh aa ri.
// mind blocked for 3-4 hours. literally frustrated.




import java.io.*;
import java.util.*;

public class A27_Buy_And_Sell_Stocks_3_With_Transaction_Fee_Infinite_Transactions_Allowed {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int charges = sc.nextInt();



    }

}