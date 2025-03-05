// 1. You are given a string str.
// 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
// Use sample input and output to take idea about subsequences.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.io.*;
import java.util.*;

public class C1_Get_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList <String> s = gss(str);
        System.out.println(s);
        sc.close();
    }   

    public static ArrayList<String> gss(String str) {

        if(str.length() == 0){
            ArrayList<String> s1 = new ArrayList<>();
            s1.add("");
            return s1;
        }

        char ch =str.charAt(0); // a
        String restOfString = str.substring(1); // [bc]
        ArrayList <String> restOfSeq = gss(restOfString); // [--,-c, b-,bc]

        ArrayList <String> finalSeq = new ArrayList<>();
        for(String s : restOfSeq){
            finalSeq.add(""+s);
            finalSeq.add(ch+s);
        }
        return finalSeq;
    }

}