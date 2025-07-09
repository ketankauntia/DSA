// https://www.lintcode.com/problem/642/

// package algoforge.stack-n-queues.2_queue_questions;

import java.util.*;

public class MovingAverage {

    int size;
    int total=0;
    // LinkedList<Integer> que;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        this.size = size;
        // que = new LinkedList<>();
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        total+=val;
        return (total *1.0)/size;

    }
}

public class Q3_moving_avg_data_stream {
    public static void main(String[] args) {
        
    }
}
