// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

class Q9_remove_duplicates_from_sorted_list{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                ListNode currKaNext = curr.next;

                curr.next = currKaNext.next;

                currKaNext.next = null;
            } else {    
                curr = curr.next;
            }
        }

        return head;
    }
}


//  my code ----------------

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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null){
            return head;
        }

        ListNode templeft = head;
        ListNode tempright = head;

        while(tempright!=null){
            if(tempright.val != templeft.val){
                templeft.next = tempright;
                templeft = tempright;
                tempright = tempright.next;
            }else{
                tempright = tempright.next;
            }
        }
        templeft.next =null;
        return head;
    }
}