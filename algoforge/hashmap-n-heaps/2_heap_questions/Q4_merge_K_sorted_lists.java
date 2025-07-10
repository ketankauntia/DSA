// https://leetcode.com/problems/merge-k-sorted-lists/
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // for sorthing the minPQ based on the ListNode values.
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode tthis, ListNode other)->{
            return tthis.val - other.val;
        });
        
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(pq.size()>0){
            ListNode top = pq.remove();
            ListNode topKaNext = top.next;  // to keep a track of that list..
            top.next = null;
            
            // current apne me next element ko dal lega and next pe chale jayega
            // basically linking to the next node and then moving the pointer to that new node.
            curr.next = top;
            curr = curr.next;
            
            // checking if, jiss list ka next node ko save kiye the, wo agar value hold krta h, to usko PQ me daal diya, and we can then again use this topKaNext wala variable since wo node jisko PQ me push kiye, that has the addresses of the next nodes of its own list.
            if(topKaNext != null){
                pq.add(topKaNext);
            }
        }
        return dummy.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Q4_merge_K_sorted_lists {
    public static void main(String[] args) {
        
    }
}