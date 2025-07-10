// https://leetcode.com/problems/kth-largest-element-in-an-array/

// package algoforge.hashmap-n-heaps.2_heap_questions;

import java.util.PriorityQueue;

public class Q1_Kth_largest_elem {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }

        return pq.peek();
    }
}
