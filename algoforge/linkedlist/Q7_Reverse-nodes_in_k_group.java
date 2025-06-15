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
    ListNode ohead; // original head
    ListNode otail; // original tail
    ListNode thead; //temp head;
    ListNode ttail; //temp tail;

    public int getLLSize(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void addFirst(ListNode node) {
        if (thead == null) {
            thead = node;
            ttail = node;
        } else {
            node.next = thead;
            thead = node;
            // node.next = ttail;
            // ttail = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ohead = null;
        otail = null;
        thead = null;
        ttail = null;

        int size = getLLSize(head);

        ListNode curr = head;
        while (size >= k) { // makes the temp. list
            int K = k;

            while (K-- > 0) {
                ListNode currKaNext = curr.next;
                curr.next = null;

                addFirst(curr);
                curr = currKaNext;
                size--;
            }

            if (ohead == null) {
                ohead = thead;
                otail = ttail;
            } else {
                otail.next = thead;
                otail = ttail;
            }
            thead =null;
            ttail = null;
        }

        otail.next = curr;
        return ohead;
    }
}