// https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q11_delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {

        //better approach ----------------
        node.val = node.next.val;
        node.next = node.next.next;

        // old approach -==================
        while(node.next!=null){
            node.val = node.next.val;
            if(node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;            
        }
        node.next = null;
    }
}

