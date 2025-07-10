// package algoforge.hashmap-n-heaps.1_hashmap_questions;

import java.util.HashMap;

public class Q1_most_freq_char {
    // Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int maxFeq=0;
        char maxFeqChar = '&';

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)==false){
                map.put(ch,1);
            } else{
                int curr_freq = map.get(ch);
                map.put( ch , curr_freq+1 );
            }
        }

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(map.get(ch)>maxFeq){
                maxFeq = map.get(ch);
                maxFeqChar = ch;
            } else if(map.get(ch)==maxFeq && ch<maxFeqChar){
                maxFeqChar=ch;
            }
        }
        return maxFeqChar;
    }
}
// 1:20:15 ----------------- bye