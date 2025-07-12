// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

import java.util.*;
import java.util.HashMap;
public class Q5_check_if_array_pair_divisble_by_k {
    public boolean canArrange(int[] arr, int k) {

        // remainder freq map
        HashMap<Integer,Integer> rfmap = new HashMap<>();

        for(int val: arr){
            int rem = val%k;

            int oldfreq = rfmap.getOrDefault(rem, 0);
            rfmap.put(rem,oldfreq+1);
        }

        for(int val: arr){

            // int rem = val%k; // -1 % 5 will give -ve remainder
            int rem = ((val % k) + k) % k;

            if(rem == 0){
                int freqOf0 = rfmap.get(rem);
                if(freqOf0 % 2 == 1){
                    return false;
                }
            } else if(2*rem == k){  // why not k/2?
                int freqofhalfK = rfmap.get(rem);
                if(freqofhalfK % 2 == 1){
                    return false;
                }
            } else{
                int freq = rfmap.get(rem);
                int otherfreq = rfmap.getOrDefault(k - rem, 0);     // imp, i missed this. what if val is null.

                if(freq != otherfreq){
                    return false;
                }
            }
        }
        return true;
    }
}