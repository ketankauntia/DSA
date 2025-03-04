// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the elements of array from beginning to end each in a separate line.
// 4. For the above purpose complete the body of displayArr function. Don't change the signature.

import java.io.*;
import java.util.*;

public class B1_Display_Array {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        //since n=4, but arr index starts from 0 to n-1
        // displayArr(arr, n-1);   

        // or
        displayArr(arr, 0);

        sc.close();
    }

    public static void displayArr(int[] arr, int idx){
        
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
        
        // if(idx==-1){
        //     return;
        // }

        // displayArr(arr, idx-1);
        // System.out.println(arr[idx]);
    }

}