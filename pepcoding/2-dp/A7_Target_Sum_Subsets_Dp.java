// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add 
//      up to "tar" or not.


// Sample Input
// 5
// 4
// 2
// 7
// 1
// 3
// 10

// Sample Output
// true


import java.io.*;
import java.util.*;

public class A7_Target_Sum_Subsets_Dp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();

        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){

                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=true;
                }
                else if(j==0){
                    dp[i][j]=true;
                }
                else{
                    if(dp[i-1][j]==true ){
                        dp[i][j]=true;
                    }else{
                        int val = arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[arr.length][target]);

        // if(dp[n][target]==true){
        //     System.out.println(true);
        // } else{
        //     System.out.println(false);
        // }
        sc.close();
    }
}
