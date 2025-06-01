package algoforge.linkedlist;

// https://leetcode.com/problems/reorder-list/description/
// LC 143

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

    public ListNode middleOfLL(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode ptr3 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ptr3;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleOfLL(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head2 = reverseLL(head2);

        ListNode ptr1 = head;
        ListNode ptr2 = head2;
        ListNode ptr1next = head;
        ListNode ptr2next = head2;
        while(ptr1!=null && ptr2!=null){
            ptr1next = ptr1next.next;
            ptr1.next = ptr2;
            ptr1=ptr1next;

            ptr2next = ptr2next.next;
            ptr2.next = ptr1;
            ptr2=ptr2next;
        }
        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}