package algoforge.linkedlist.construction;

// Skimmed through the later half of the vod.

class Node{
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}

class LinkedList{
    Node head;
    Node tail;

    public void addLast(int data){
        Node nn = new Node(data);

        if(head == null){ // size can be 0
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }

        this.size++;
    }
}

public class Main {
    
}
