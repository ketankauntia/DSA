// https://leetcode.com/problems/number-of-recent-calls/

// package algoforge.stack-n-queues.2_queue_questions;

import java.util.*;
class RecentCounter {

    LinkedList<Integer> que;
    public RecentCounter() {
        que = new LinkedList<>();
    }
    
    public int ping(int t) {
        // agar starting walve current time ke 3 sec pehle se h, to remove that. and only keep value for the prev 3 sec
        while(!que.isEmpty() && que.getFirst() < t-3000){
            que.removeFirst();
        }
        que.addLast(t);

        return que.size();
    }
}



public class Q1_recentCounter {
    public static void main(String[] args) {
        
    }
}
