// 1. You are given a number n.
// 2. You are required to print the nth element of fibonnaci sequence.

// Note -> Notice precisely how we have defined the fibonnaci sequence
// 0th element -> 0
// 1st element -> 1
// 2nd element -> 1
// 3rd element -> 2
// 4th element -> 3
// 5th element -> 5
// 6th element -> 8

import java.io.*;
import java.util.*;

public class A1_Fibonacci_dp{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = fibMemoized(n,new int[n+1]);
        System.out.println(ans);
        sc.close();
    }
    //qb = question bank or dp[]
    public static int fibMemoized(int n, int qb[]){

        if(n==1 || n==0){
            return n;
        }

        //checking if the value is already calculated,
        // then dont calculate and give from the question bank
        if(qb[n]!=0){
            return qb[n];
        }

        int fibnm1 = fibMemoized(n-1, qb);
        int fibnm2 = fibMemoized(n-2, qb);
        int fibn = fibnm1+fibnm2;
        
        qb[n]=fibn; // when ans found, add it to question bank
        
        return fibn;
    }

}