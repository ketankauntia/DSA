package algoforge.linkedlist.construction;

class Node{
    int data;   // stores data
    Node next = null;  // stores address of next Node

    public Node(int data){
        this.data = data;
    }
}

public class Introduction {
    public static void main(String[] args){

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(5);
        n1.next = n2;
        n2.next = n3;        
    }
}
