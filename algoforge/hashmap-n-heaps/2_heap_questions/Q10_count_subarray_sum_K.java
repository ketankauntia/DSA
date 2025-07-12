// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.*;
public class Q10_count_subarray_sum_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum = 0 has 1 occurrence

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // if there sum-k is present previosuly means, we found a subarray.
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}