// https://leetcode.com/problems/binary-tree-postorder-traversal/

public class Q2_postorder {
    
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        postHelper(root, list);
        return list;
    }

    public void postHelper(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }

        postHelper(node.left, ans);
        postHelper(node.right, ans);

        ans.add(node.val);
    }
}