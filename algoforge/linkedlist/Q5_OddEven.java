package algoforge.linkedlist;

   // Unfold Linkedlist (Undo leetcode 143) ======================================

// https://leetcode.com/problems/odd-even-linked-list/description/
// HW : LC 328.

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

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode o = head;
        ListNode e = head.next;
        ListNode tempE = head.next;
        while(e!=null && e.next!=null){
            ListNode o1 = o.next.next;
            ListNode e1 = e.next.next;
            
            o.next = o1;
            e.next = e1;

            o=o1;
            e=e1;
        }
        o.next = tempE;
        return head;
    }
}