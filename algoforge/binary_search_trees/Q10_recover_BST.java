// https://leetcode.com/problems/recover-binary-search-tree/description/
//  used morris traversal in this.

import java.util.*;

import javax.swing.tree.TreeNode;

public class Q10_recover_BST {

    public TreeNode getRightMostNode(TreeNode root, TreeNode curr){
        TreeNode temp = root;
        while(temp.right!=null && temp.right != curr){
            temp = temp.right;
        }
        return temp;
    }

    public void recoverTree(TreeNode root) {
        TreeNode curr = root, a = null, b = null, prev = null;

        while(curr != null){

            TreeNode leftNode = curr.left;

            if(leftNode == null){
                if(prev != null && prev.val > curr.val){
                    if(a==null){
                        a = prev;
                    }
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            } else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);

                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else{
                    rightMostNode.right = null;
                    if(prev.val > curr.val){
                        if(a == null){
                            a = prev;
                        }
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        if(a != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }    
}
