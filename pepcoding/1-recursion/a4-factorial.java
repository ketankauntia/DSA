// 1. You are given a number n.
// 2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
    }

    public static int factorial(int n){
        
        //this will give f(4) on its own.
        int factNminus1 = factorial(n-1);   
        
        // to get f(5) = 5*F(4)
        int factN = n* factNminus1; 

        return factN;

        // or 
        // return n*factorial(n-1);
    }

}