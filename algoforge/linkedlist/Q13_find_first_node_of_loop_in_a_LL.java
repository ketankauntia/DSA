// https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
// https://leetcode.com/problems/linked-list-cycle-ii/description/

/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

public static Node findFirstNode(Node head) {
    if(head == null || head.next==null){
        return null;
    }

    Node slow = head;
    Node fast = head;

    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            break;
        }
    }

    if(slow != fast){ // no cycle
        return null;
    }

    slow = head;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}

// my code ===========================
public class Q13_find_first_node_of_loop_in_a_LL {
    
    public static Node findFirstNode(Node head) {
        // code here
        if(head==null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=null){
                    if(slow==fast){
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }
}
