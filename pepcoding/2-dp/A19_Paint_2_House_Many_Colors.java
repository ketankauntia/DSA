// 1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
// 2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.


import java.io.*;
import java.util.*;

public class A19_Paint_2_House_Many_Colors {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int arr[][] = new int[n][c];
        for(int i=0;i<n;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[arr.length][arr[0].length];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for(int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];

            if(arr[0][j] <= least){
                sleast = least;
                least = arr[0][j];
            } else if(arr[0][j] <= sleast){
                sleast = arr[0][j];
            }
        }

        for(int i = 1; i < dp.length; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
        
            for(int j = 0; j < dp[0].length; j++){
                if(least == dp[i - 1][j]){
                    dp[i][j] = sleast + arr[i][j];
                } else {
                    dp[i][j] = least + arr[i][j];
                }
        
                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        System.out.println(least);
        sc.close();
    }
}

// ----------- THis is in n^3 ------------------

// import java.io.*;
// import java.util.*;

// public class A_19_Paint_2_House_Many_Colors {

//     public static void main(String[] args) throws Exception {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int c = sc.nextInt();

//         int arr[][] = new int[n][c];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<c;j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }

//         int dp[][]=new int[n][c];

//         for(int i=0;i<c;i++){   //for 0th row, same vals
//             dp[0][i] = arr[0][i];
//         }

//         for(int i=1;i<n;i++){
//             for(int j=0;j<c;j++){
//                 int minVal = Integer.MAX_VALUE;
//                 for(int k=0;k<c;k++){
//                     if(j==k){ //same col, skip
//                         continue;
//                     }
//                     minVal = Math.min(minVal, dp[i-1][k]);
//                 }
//                 dp[i][j] = minVal+arr[i][j];
//             }
//         }

//         int minAns = dp[n-1][0];
//         for(int i=1;i<c;i++){
//             minAns = Math.min(minAns,dp[n-1][i]);
//         }
//         System.out.println(minAns);
//         sc.close();
//     }
// }