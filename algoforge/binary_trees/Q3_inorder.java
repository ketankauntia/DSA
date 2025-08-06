// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Q3_inorder {
    
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inHelper(root, list);
        return list;
    }

    public void inHelper(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }

        inHelper(node.left, ans);
        
        ans.add(node.val);
        
        inHelper(node.right, ans);

    }
}