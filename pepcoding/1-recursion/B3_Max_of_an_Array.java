// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to find the maximum of input. 
// 4. For the purpose complete the body of maxOfArray function. Don't change the signature.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.io.*;
import java.util.*;

public class B3_Max_of_an_Array {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println( maxOfArray(arr, 0) );
        sc.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        

        //faith : we get max of smaller array (1 to n-1) in value variable

        //expec : we compare value and 0th index value to find which one is bigger and return that.

        // if(idx==arr.length-1){
        //     return arr[idx];
        // }

        // int maxInSmallerArray = maxOfArray(arr, idx+1);
        // if(maxInSmallerArray>arr[idx]){
        //     return maxInSmallerArray;
        // } else{
        //     return arr[idx];
        // }

        if(idx==arr.length){
            return 0;
        }

        int value = maxOfArray(arr, idx+1); 
        int max = (value > arr[idx]) ? value  : arr[idx];

        return max;
    }

}