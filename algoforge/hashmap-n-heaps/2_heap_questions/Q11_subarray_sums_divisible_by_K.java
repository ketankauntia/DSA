// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

import java.util.*;
public class Q11_subarray_sums_divisible_by_K {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count =0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = ((sum%k) + k) %k; //normalized negative nos
            
            if(map.containsKey(rem)){
                count+= map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}
