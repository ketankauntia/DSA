import java.util.Collections;
import java.util.PriorityQueue;

public class introduction {
    public static void main(String[] args) {
        
        // minimum priority queue =======================
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // these are costly operations.
        pq.add(5);  // log(N)
        pq.remove();  // log(N)
        pq.peek();  // O(1)
        pq.size();  // O(1)


        // maximum priortity queue ======================
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }
}
