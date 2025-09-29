// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class Q27_populating_next_right_pointer_in_each_node {

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        Node curr = root;
        Node first = root.left; //first node of next level

        while(first != null){
            
            
            curr.left.next = curr.right;    // parent making next of left = right;
            
            if(curr.next == null){   // if curr is at the last node of curr level
                curr = first;
                first = first.left;
            } else{
                Node next = curr.next;
                curr.right.next = next.left;    //setting next of right child

                curr = next;
            }
        }
        return root;
    }

}
