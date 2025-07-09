// https://www.lintcode.com/problem/3662/

import java.util.LinkedList;

public class HitCounter {
    
    LinkedList<Integer> que;
    public HitCounter() {
        que = new LinkedList<>();
    }

    /**
     * @param timestamp: the timestamp
     * @return: nothing
     */
    public void hit(int timestamp) {
        que.addLast(timestamp);
    }

    /**
     * @param timestamp: the timestamp
     * @return: the count of hits in recent 300 seconds
     */
    public int getHits(int timestamp) {
        while(!que.isEmpty() && que.getFirst() <= timestamp-300){
            que.removeFirst();
        }
        // que.addLast(timestamp);

        return que.size();
    }
}

public class Q2_design_hit_counter {
    public static void main(String[] args) {
        
    }
}
