// 1. You are given a string str.
// 2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
// Use sample input and output to take idea about permutations.

// Sample Input
// abc

// Sample Output
// abc
// acb
// bac
// bca
// cab
// cba


import java.io.*;
import java.util.*;

public class D4_Print_Permutations {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutations(str,"");
        sc.close();
    }

    public static void printPermutations(String str, String asf) {

        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        for(int i=0;i<str.length();i++){    //abcde
            char ch = str.charAt(i);    //b

            String restOfWord = str.substring(0,i)+str.substring(i+1);  // a + cde

            printPermutations(restOfWord, asf+ch);  // acde, ""+b 
        }

    }

}