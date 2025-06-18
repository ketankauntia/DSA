// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

// NEED TO RE-VISIT this!!!! [=======IMP=======]

public class Q18_reverse_nodes_in_even_length_groups {
    ListNode ohead;
    ListNode otail;
    ListNode thead;
    ListNode ttail;

    public int getSize(ListNode head) {
        int size = 0;

        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

    public void addLast(ListNode node) {
        if (thead == null) {
            thead = node;
            ttail = node;
        } else {
            ttail.next = node;
            ttail = node;
        }
    }

    public void addFirst(ListNode node) {
        if (thead == null) {
            thead = node;
            ttail = node;
        } else {
            node.next = thead;
            thead = node;
        }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ohead = null;
        otail = null;
        thead = null;
        ttail = null;

        int size = getSize(head);
        ListNode curr = head;

        int curr_grp_size = 1;

        while (size > curr_grp_size) {
            int K = curr_grp_size;

            while (K-- > 0) {
                ListNode currKaNext = curr.next;
                curr.next = null;
                if (curr_grp_size % 2 == 0) {
                    addFirst(curr);
                } else {
                    addLast(curr);
                }
                curr = currKaNext;
            }

            if (ohead == null) {
                ohead = thead;
                otail = ttail;
            } else {
                otail.next = thead;
                otail = ttail;
            }

            thead = null;
            ttail = null;

            size -= curr_grp_size;
            curr_grp_size++;
        }

        while (curr != null) {
            ListNode currKaNext = curr.next;
            curr.next = null;

            if (size % 2 == 0) {
                addFirst(curr);
            } else {
                addLast(curr);
            }

            curr = currKaNext;
        }

        if (ohead == null) {
            ohead = thead;
            otail = ttail;
        } else {
            otail.next = thead;
            otail = ttail;
        }

        return ohead;
    }
}
