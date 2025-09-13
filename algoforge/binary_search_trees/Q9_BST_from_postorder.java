// https://www.geeksforgeeks.org/problems/construct-bst-from-post-order/1

import java.util.*;

public class Q9_BST_from_postorder {

    public static Node buildBSTFromPostorder(int[] post, int[] idx, int lowerbound, int upperbound){
        if(idx[0]<0 || post[idx[0]] <= lowerbound || post[idx[0]]>=upperbound){
            return null;
        }
        
        Node root = new Node(post[idx[0]]);
        idx[0]--;

        root.right = buildBSTFromPostorder(post, idx, root.data, upperbound);
        root.left = buildBSTFromPostorder(post, idx, lowerbound, root.data);

        return root;
    }

    public static Node constructTree(int post[], int n) {
        // Add your code here.

        int[] idx = new int[1];
        idx[0] = n-1;

        return buildBSTFromPostorder(post,idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
