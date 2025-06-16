// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

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
class Q10_remove_duplicates_from_sorted_list_ii {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr!=null && curr.next!=null && curr.next.next!=null){

            if(curr.next.val == curr.next.next.val){
                ListNode temp = curr.next;
                int duplicateValue = temp.val;

                while(temp!=null && temp.val== duplicateValue){
                    temp = temp.next;
                }
                curr.next = temp;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}