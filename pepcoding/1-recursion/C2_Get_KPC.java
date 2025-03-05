// 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
// 2. The following list is the key to characters map :
//     0 -> .;
//     1 -> abc
//     2 -> def
//     3 -> ghi
//     4 -> jkl
//     5 -> mno
//     6 -> pqrs
//     7 -> tu
//     8 -> vwx
//     9 -> yz
// 3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
// Use sample input and output to take idea about output.

import java.io.*;
import java.util.*;

public class C2_Get_KPC {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList <String> words = getKPC(str);
        System.out.println(words);
        sc.close();
    }

    static String[] codes =  {".;", "abc", "def","ghi","jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {

        if(str.length()==0){
            ArrayList<String> s1 = new ArrayList<>();
            s1.add("");
            return s1;
        }

        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        ArrayList <String> kpcFromSmallerWord = getKPC(restOfString);
        ArrayList <String> finalKpc = new ArrayList<>();

        //every ch is a number (2) which has 3-4 characters.
        String chLetters = codes[ch-'0'];   // "abc"
        for(int i=0;i<chLetters.length();i++){  // for each character of "abc"
            char extractedLetter = chLetters.charAt(i);
            for(String s : kpcFromSmallerWord){
                finalKpc.add(extractedLetter+s);
            }
        }
        return finalKpc;
    }

}