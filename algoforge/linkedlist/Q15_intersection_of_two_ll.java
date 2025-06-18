// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Q15_intersection_of_two_ll {
    public ListNode findMerge(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                break;
            }
        }

        if(fast != slow){
            return null;
        }

        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = headB;
        
        ListNode ans = findMerge(headA);
        temp.next = null;
        return ans;
    }
}
