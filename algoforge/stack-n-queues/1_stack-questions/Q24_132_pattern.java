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

        Stack<Integer> possibleKValue = new Stack<>();
        possibleKValue.push(nums[n-1]);

        for(int j=n-2; j>=0; j--){
            int min = minSoFar[j];

            while(possibleKValue.size()>0 && min >= possibleKValue.peek()){
                possibleKValue.pop();
            }

            if(possibleKValue.size()>0 && nums[j] > possibleKValue.peek()){
                return true;
            }

            possibleKValue.push(nums[j]);
        }

        return false;
    }
    
}
