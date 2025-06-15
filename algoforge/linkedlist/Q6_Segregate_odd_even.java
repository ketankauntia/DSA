package algoforge.linkedlist;

// https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1


class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    
    Node divide(Node head) {
        // code here
        Node evenDummy = new Node(-1);
        Node oddDummy = new Node(-1);

        Node evenCurr = evenDummy;
        Node oddCurr = oddDummy;

        Node curr = head;

        while(curr != null){
            Node currKaNext = curr.next;
            curr.next = null;
            
            if(curr.data % 2 == 0){
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
            
            curr = currKaNext;
        }
        
        evenCurr.next = oddDummy.next;
        return evenDummy.next;
    }
}