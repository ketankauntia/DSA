package algoforge.linkedlist.construction;


class Node{
    int data;
    Node next=null;
    public Node(int data){
        this.data = data;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
    }
}
