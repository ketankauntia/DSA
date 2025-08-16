// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import javax.swing.tree.TreeNode;

public class Q2_LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else{ //  jis moment pe p & q ke liye left and right jaana pade, wo lca ho jayega.. think..
            return root;
        }
    }
    
}
