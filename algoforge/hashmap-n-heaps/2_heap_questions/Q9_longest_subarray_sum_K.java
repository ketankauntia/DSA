// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

// store sum,index of each postiton in hashmap
// calculate the sum at each position
// sum-k, if present in the hashmap, gives the starting point of the subarray.
// so max of that index - current postion vs old count is the new ans.
// if hashmap doesnt contain the key, we'll put that key with ith index. ( current index )

import java.util.*;

public class Q9_longest_subarray_sum_K {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);  // <sum,index>

        int sum = 0;
        int longest = 0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];

            if(map.containsKey(sum-k)){
                longest = Math.max(longest, i - map.get(sum-k));
            }

            if(map.containsKey(sum)==false){
                map.put(sum,i);
            }
        }
        return longest;
    }
}
