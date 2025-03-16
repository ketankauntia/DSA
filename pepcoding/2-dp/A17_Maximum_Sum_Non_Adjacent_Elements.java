// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers, representing n elements.
// 3. You are required to find the maximum sum of a subsequence with no adjacent elements.

// Sample Input
// 6
// 5
// 10
// 10
// 100
// 5
// 6

// Sample Output
// 116

import java.io.*;
import java.util.*;

public class A17_Maximum_Sum_Non_Adjacent_Elements {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        int include = arr[0];
        int exclude = 0;

        for(int i=1;i<arr.length;i++){
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(exclude, include);

            include = newInclude;
            exclude = newExclude;
        }

        int ans = Math.max(include, exclude);
        System.out.println(ans);
        sc.close();
    }
}