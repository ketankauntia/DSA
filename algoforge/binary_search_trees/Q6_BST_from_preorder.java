// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

import java.util.*;

public class Q6_BST_from_preorder {

    public TreeNode bstFromPreorder_helper(int[] preorder, int[] idx, int lowerbound, int upperbound){

        if(idx[0] >= preorder.length || preorder[idx[0]] <= lowerbound || preorder[idx[0]]>=upperbound){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;

        root.left = bstFromPreorder_helper(preorder, idx, lowerbound, root.val);
        root.right = bstFromPreorder_helper(preorder, idx, root.val, upperbound);

        return root;
    }


    public TreeNode bstFromPreorder(int[] preorder) {

        int idx[] = new int[1];
        return bstFromPreorder_helper(preorder, idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
