// https://leetcode.com/problems/next-greater-element-ii/description/

import java.util.Arrays;
import java.util.Stack;

public class Q17_next_greater_right_2_on_circular_array {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();  // storing indexes
        int[] ngr = new int[n];

        Arrays.fill(ngr, -1);

        // now we loop twice over the circular array
        // i % n gives us the circular index
        for(int i =0; i<n*2;i++){

            // agar stack ke top pe jo index h, uss position ki value, next value se choti h,
            while(st.size()>0 && nums[st.peek()] < nums[i%n] ){

                // pehle to wo greater value ans array me dal do and fir usko pop kardo
                ngr[st.pop()] = nums[i%n];
            }

            // adding values to the stack
            if(i<n){
                st.push(i);
            }
        }
        return ngr;
    }
    public static void main(String[] args) {
        
    }    
}
