// https://leetcode.com/problems/sliding-window-maximum/

import java.util.Stack;

public class Q11_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];    //next greater element

        st.push(nums.length-1);
        nge[nums.length-1] = nums.length;
        
        // pop, ans, pushes

        for(int i = nums.length-2; i>=0; i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()]){
                st.pop();
            }

            if(st.size()==0){
                nge[i] = nums.length;
            } else{
                nge[i]=st.peek();
            }
            st.push(i);
        }

        int[] res = new int[nums.length - k + 1];
        int j=0;
        for(int i=0; i<=nums.length-k; i++){
            //enter the loop to find the maximum of window starting at i
            if(j<i){
                j=i;
            }

            while(nge[j]< i+k){
                j=nge[j];
            }
            res[i]=nums[j];
        }
        return res;
    }
}
