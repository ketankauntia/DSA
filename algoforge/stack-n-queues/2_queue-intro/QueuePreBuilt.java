// package algoforge.stack-n-queues.2_queue-intro;

import java.util.LinkedList;

public class QueuePreBuilt {
    public static void main(String[] args) {
        LinkedList<Integer> que = new LinkedList<>();

        // ading to queue
        que.addLast(10);
        que.addLast(20);
        que.addLast(30);

        //peek for queue
        System.out.println(que.getFirst());

        // remove from the queue
        System.out.println(que.removeFirst());
        System.out.println(que.removeFirst());
        System.out.println(que.removeFirst());
        System.out.println(que.removeFirst());
    }
}
