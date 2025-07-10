// https://leetcode.com/problems/find-median-from-data-stream/

// package algoforge.hashmap-n-heaps.2_heap_questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q3_median_from_data_stream {
    
}


// what we can do is, break the incoming data into 2 halves.
// 1st half stores the smaller elements
//  2nd half stores the larger elements
// when we need to give the median, we take last + first of both.
class MedianFinder {
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || left.peek()>=num){
            left.add(num);
        } else{
            right.add(num);
        }
        if(left.size()>right.size()+1){
            right.add(left.remove());
        } else if(right.size() > left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {

        if(left.size()>right.size()){
            return (double)left.peek();
        }
        return (left.peek()+right.peek())/2.0;
        
    }
}


// 1:59:54--------

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
/*
 *
 1
 2

 
 
 * 
 */
 
