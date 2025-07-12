// https://leetcode.com/problems/contiguous-array/

import java.util.*;
public class Q12_contiguous_array {
   public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0,-1);
        
        int ans = 0;
        int sum = 0;

        // we'll treat 0's as -1.
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0){
                sum+=-1;
            } else{
                sum+=1;
            }

            // kya ye sum pehle aa chuka h?
            // agar aa chuka h, to pehle kab aya tha, get index.
            // compare with ans and update max length ( ans )
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int len = i - idx;
                if(len>ans){
                    ans = len;
                }
            } else{ // agar hashmap me nai h, to put krde.
                map.put(sum,i);
            }
        }
        return ans;
    } 
}

