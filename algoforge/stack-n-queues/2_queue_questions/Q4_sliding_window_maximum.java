// https://leetcode.com/problems/sliding-window-maximum/submissions/1691565905/

// package algoforge.stack-n-queues.2_queue_questions;

import java.util.LinkedList;

public class Q4_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        LinkedList<Integer> que = new LinkedList<>();

        int[] ans = new int[n-k];
        int ansIndex=0;
        //we are storing index in the queue.

        for(int i=0;i<n;i++){

            // agar queue me values h already, and queue ke start me jo index h, agar wo k ke range me nai h, remove that.
            // i-k gives the last k elements ka limit
            if(que.size()>0 && que.getFirst() <= i-k){
                que.removeFirst();
            }

            // agar pehle jo values h, wo current value se kam h,
            // to unko nikal denge.. and sirf bada wala value rakhenge.
            while(que.size()>0 && nums[que.getLast()] < nums[i]){
                que.removeLast();
            }

            // current iteration ka index add kr diye
            que.addLast(i);

            // when do we start printing? when we reach k-1 indexes ( 0 is the starting index so.. )
            if(i>=k-1){
                ans[ansIndex++] = nums[que.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
