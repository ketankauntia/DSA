// https://leetcode.com/problems/validate-binary-search-tree/

import javax.swing.tree.TreeNode;

public class Q7_validate_bst {
    
}
class BSTPair {
        long max;
        long min;
        boolean isBST;

        BSTPair(long max, long min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public BSTPair isTreeBST(TreeNode root) {
        if (root == null) {
            return new BSTPair(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        BSTPair left = isTreeBST(root.left);
        BSTPair right = isTreeBST(root.right);

        if (!left.isBST || !right.isBST || left.max >= root.val || right.min <= root.val) {
            return new BSTPair(0, 0, false);
        }

        long minVal = Math.min(left.min, root.val);
        long maxVal = Math.max(right.max, root.val);

        return new BSTPair(maxVal, minVal, true);
    }

    public boolean isValidBST(TreeNode root) {
        return isTreeBST(root).isBST;
    }