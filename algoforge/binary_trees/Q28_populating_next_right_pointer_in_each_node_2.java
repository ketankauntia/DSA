// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

public class Q28_populating_next_right_pointer_in_each_node_2 {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null;
        Node prev = null;
        
        while(curr != null){
            // travelling on next level

            while(curr != null){
                if(curr.left != null){
                    if(prev == null){
                        head = curr.left;
                    } else{
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                
                if(curr.right != null){
                    if(prev == null){
                        head = curr.right; 
                    } else{
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }

                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
