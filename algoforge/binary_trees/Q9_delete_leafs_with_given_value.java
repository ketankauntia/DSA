// https://leetcode.com/problems/delete-leaves-with-a-given-value/

import java.util.*;

public class Q9_delete_leafs_with_given_value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        //  we'll remove the leaf nodes in postfix order...

        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}
