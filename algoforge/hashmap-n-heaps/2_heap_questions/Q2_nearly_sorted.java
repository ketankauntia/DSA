// package algoforge.hashmap-n-heaps.2_heap_questions;

import java.util.PriorityQueue;

public class Q2_nearly_sorted {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int j=0;
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                arr[j++]=pq.remove();
            }
        }
        while(pq.size()>0){
            arr[j++]=pq.remove();    
        }
    }
}