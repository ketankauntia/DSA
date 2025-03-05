// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number x. 
// 4. You are required to find the all indices at which x occurs in array a.
// 5. Return an array of appropriate size which contains all indices at which x occurs in array a.


import java.io.*;
import java.util.*;

public class B6_All_Indices_Of_Array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here

        if(idx == arr.length){
            return new int [fsf];
        }

        // on the way to end (pre-traversal)
        // we count the no of occurences of x (found so far is increased)

        // when reached at end, we create [] of fsf to store all indexes of the occurences of x.


        if(arr[idx]==x){    
            int iarr[] = allIndices(arr, x, idx+1, fsf+1);
            //post-traversal (found): add index to ans[]'s fsf index
            iarr[fsf]=idx;
            return iarr;
            
        }else{
            int iarr[]=allIndices(arr, x, idx+1, fsf);
            // post-traversal(not-found) : simply return the ans[], since nothing to add
            return iarr;
        }

    }

}