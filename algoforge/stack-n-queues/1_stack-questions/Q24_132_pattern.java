// https://leetcode.com/problems/132-pattern/description/

import java.util.Stack;

public class Q24_132_pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] minSoFar = new int[n];
        minSoFar[0] = nums[0];

        for(int i=1; i<n; i++){
            minSoFar[i] = Math.min(minSoFar[i-1], nums[i]);
        }

        // iske baad ka kuch ni samajh aya :|
    }
    
}
