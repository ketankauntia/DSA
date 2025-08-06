import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Q8_LCA {

    // O(N), O(N) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
        ArrayList<TreeNode> ntrp = nodeToRootPath(root, p);
        ArrayList<TreeNode> ntrq = nodeToRootPath(root, q);
        
        int i = ntrp.size() - 1;
        int j = ntrq.size() - 1;
        
        while(i>=0 && j>=0 && ntrp.get(i) == ntrq.get(j)){
            i--;
            j--;
        }
        j++;
        
        return ntrq.get(j);
    }
    
    // LCA better

    // we'll do the recursive approach,
    // if we find either p or q, we return that, else null from the leaf nodes.
    // when we get p & null or q & null, we return the p or q..
    // but when we get p & q on a node, it means, it covers both the nodes and is the common node. therefore, the lowest common ancestor..

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        } else if(right == null){
            return left;
        } else{     // when we get both left & right together on a common node
            return root;
        }
        
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode target) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root == target) {
            ArrayList<TreeNode> baseAns = new ArrayList<>();
            baseAns.add(root);
            return baseAns;
        }

        ArrayList<TreeNode> left = nodeToRootPath(root.left, target);
        if (!left.isEmpty()) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath(root.right, target);
        if (!right.isEmpty()) {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

}
