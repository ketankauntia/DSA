// package algoforge.stack-n-queues.2_queue_questions;

import java.util.LinkedList;

public class Q5_shortest_subarray_with_sum_k {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n];

        LinkedList<Integer> dq = new LinkedList<>();

        //first we need to calc the prefix array
        prefix[0]=nums[0];
        for(int i=1; i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }


        // agar hume -ve value exclude karake sum nai mila,
        // to -ve value include karake kaise mil jayega?
        // pre(i) <= pre(dq.last())

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            //agar kisi bhi samay, prefix ki value target K se badi ho gyi, to save positions to ans.
            if(prefix[i]>=k){
                ans = Math.min(i+1, ans);
            }

            //que ke aage se kab value ko nikalna h?
            // agar current value se starting ka value minus karne ke baad bhi we get a value >=k, then we should remove the first value from que, coz we need minimum index to get the ans.

            while(!dq.isEmpty() &&  prefix[i]-prefix[dq.getFirst()]>=k){
                ans = Math.min(ans, i-dq.getFirst());
                dq.pop();
            }

            // ye part nai samajh aya :( ============================
            // agar abhi jo values dal re h, wo -ve aa re, to unko bhi nikalenge..
            while(!dq.isEmpty() && prefix[i] <= prefix[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return ans == Integer.MAX_VALUE? -1:ans;
    }
}