// https://leetcode.com/problems/balance-a-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class Q2_balance_a_BST {

    public void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public TreeNode build(List<Integer> nums, int l, int r){
        if(l>r){
            return null;
        }

        int mid = (l+r)/2;

        TreeNode root = new TreeNode(nums.get(mid));
        
        root.left = build(nums, l, mid-1);
        root.right = build(nums, mid+1, r);
        
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return build(inorder,0,inorder.size()-1);
    }
}
