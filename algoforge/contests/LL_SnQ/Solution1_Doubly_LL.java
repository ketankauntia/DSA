/* 
Reorder doubly LinkedList =========================

You are given the head of a doubly linked list. The list can be represented as:

L0 ⇄ L1 ⇄ L2 ⇄ ... ⇄ Ln-1 ⇄ Ln
Reorder the list to be in the following form:

L0 ⇄ Ln ⇄ L1 ⇄ Ln-1 ⇄ L2 ⇄ Ln-2 ⇄ ...

====================================================
*/
import java.io.*;
import java.util.*;

public class Solution1_Doubly_LL {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node head = null;
    static Node tail = null;

    // Add node at end of doubly linked list
    public static void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Print linked list
    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" ");
            head = head.next;
        }
    }

    // Find middle node of linked list
    public static Node middleOfLL(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse doubly linked list starting from head
    public static Node reverseLL(Node node) {
        Node curr = node;
        Node temp = null;

        while (curr != null) {
            // swap prev and next
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next (originally prev)
            curr = curr.prev;
        }

        // temp is at previous of null, so move to actual new head
        if (temp != null) {
            return temp.prev;
        }

        return null;
    }

    // Merge first and reversed second part
    public static Node merge2LL(Node first, Node second) {
        Node ptr1 = first;
        Node ptr2 = second;

        while (ptr1 != null && ptr2 != null) {
            Node ptr1Next = ptr1.next;
            Node ptr2Next = ptr2.next;

            // link ptr1 -> ptr2
            ptr1.next = ptr2;
            ptr2.prev = ptr1;

            // link ptr2 -> ptr1Next if exists
            if (ptr1Next != null) {
                ptr2.next = ptr1Next;
                ptr1Next.prev = ptr2;
            }

            // move forward
            ptr1 = ptr1Next;
            ptr2 = ptr2Next;
        }

        return first;
    }

    public static void reorderLL() {
        if (head == null || head.next == null) return;

        // Step 1: find middle
        Node middle = middleOfLL(head);
        Node secondHalf = middle.next;
        middle.next = null;
        if (secondHalf != null) secondHalf.prev = null;

        // Step 2: reverse second half
        Node reversed = reverseLL(secondHalf);

        // Step 3: merge two halves
        head = merge2LL(head, reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            addLast(sc.nextInt());
        }

        reorderLL();        // modifies head in-place
        display(head);      // print result
    }
}
