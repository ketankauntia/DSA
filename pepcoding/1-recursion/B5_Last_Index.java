// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number x. 
// 4. You are required to find the last index at which x occurs in array a.
// 5. If x exists in array, print the last index where it is found otherwise print -1.

import java.io.*;
import java.util.*;

public class B5_Last_Index {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(lastIndex(arr, 0, x));
        sc.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){

        // faith : 1 - n-1 pre order index if found
        //expec : compare 0th and faith in pre

        if(idx == arr.length){
            return -1;
        }

        int lastIndexInSmallerArray = lastIndex(arr, idx+1, x);
        if(lastIndexInSmallerArray == -1){  // couldn't find in the rest of array
            //so we compare it with the current index, 0th index.
            if(arr[idx]==x){
                return idx;
            } else{ //if no not in even the 0th index, number not present.
                return -1;  
            }
        } else{ // else if number was already found in the smaller array, we simply return the index from smaller array
            return lastIndexInSmallerArray;
        }

    }

}