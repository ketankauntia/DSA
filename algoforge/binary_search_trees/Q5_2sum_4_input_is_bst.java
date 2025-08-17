// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.*;

public class Q5_2sum_4_input_is_bst {

    public boolean findEleInBST_helper2(TreeNode root, int ele, TreeNode blocker){
        if(root == null){
            return false;
        }

        if(root != blocker && root.val == ele){
            return true;
        }

        if(root.val < ele){
            return findEleInBST_helper2(root.right, ele,blocker);
        } else{
            return findEleInBST_helper2(root.left, ele, blocker);
        }
    }

    public boolean findPairSum_helper(TreeNode curr, TreeNode root, int k){
        if(curr == null){
            return false;
        }

        int secondEle = k - curr.val;

        if(findEleInBST_helper2(root, secondEle, curr)){  //logN
            return true;
        }

        return findPairSum_helper(curr.left, root, k) || findPairSum_helper(curr.right, root, k);
    }

    //main fn.
    public boolean findTarget(TreeNode root, int k) {
        return findPairSum_helper(root, root, k);
    }
}
