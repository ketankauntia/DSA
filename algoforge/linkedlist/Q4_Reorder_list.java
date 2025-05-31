package algoforge.linkedlist;

// https://leetcode.com/problems/reorder-list/description/
// LC 143

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

        ListNode ptr1 = head;
        ListNode ptr2 = head2;
        while(ptr1!=null){
            ptr1.next = ptr2;
            ptr2.next = ptr1;
        }
        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}