// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void attachCopyNodesInBetween(Node head) {
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);

            Node currKaNext = curr.next;
            curr.next = copy;
            copy.next = currKaNext;

            curr = currKaNext;
        }
    }

    public Node detachInBetweenList(Node head) {
        Node copyHead = head.next;

        Node curr = head;
        while (curr != null) {
            Node currKaNext = curr.next.next; // originalNext

            Node copy = curr.next;
            if (currKaNext != null) {
                copy.next = currKaNext.next;
            }

            curr.next = currKaNext;
            curr = currKaNext;
        }

        return copyHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        attachCopyNodesInBetween(head);

        Node curr = head;

        // assign random node values
        while (curr != null) {
            Node copy = curr.next;

            if (curr.random != null) {
                copy.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        return detachInBetweenList(head);
    }
}