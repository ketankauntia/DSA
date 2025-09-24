// https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1

import java.util.*;

public class Q24_BT_to_doubly_LL {
    Node prev = null;
    Node head = null;
    
    Node bToDLL(Node root) {
        // code here
        
        if(root == null){
            return null;
        }

        // inorder me traversal karenge
        bToDLL(root.left);

        if(prev == null){
            prev = root;
            head = root;
        } else{
            prev.right = root;
            root.left = prev;

            prev = root;
        }

        bToDLL(root.right);

        return head;
    }
}
