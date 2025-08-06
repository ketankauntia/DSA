// https://leetcode.com/problems/binary-tree-preorder-traversal/

public class Q1_preorder {
    
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preHelper(root, ans);

        return ans;
    }

    public void preHelper(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        preHelper(node.left, list);
        preHelper(node.right, list);
    }
}