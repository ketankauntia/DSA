// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class Q25_flatten_BT_to_LL {

    TreeNode prev=null;

    public void flatten(TreeNode root) {
        
        // right side first then left side.   

        if(root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
