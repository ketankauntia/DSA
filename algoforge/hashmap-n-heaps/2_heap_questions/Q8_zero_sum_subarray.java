// https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1

import java.util.*;
import java.util.HashMap;
public class Q8_zero_sum_subarray {
    public int findSubarray(int[] arr) {
        // code here.
        
        // we store the sum and freq in the hashmap
        // caculate sum and check if its there in map.
        // if there, we cal diff of freq to get maxlength
        // if new maxlength greater, we update it
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);     // < sum , freq >

        int sum=0;
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            sum += arr[i];

            if(map.containsKey(sum)){
                count += map.get(sum); // add frequency of this sum seen so far
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        return count;
    }
}
