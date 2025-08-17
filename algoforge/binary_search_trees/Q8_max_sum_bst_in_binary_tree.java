// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/

import java.util.*;

public class Q8_max_sum_bst_in_binary_tree {
    class BSTPair {
        int max;
        int min;
        boolean isBST;
        int sum;
        int maxSum;

        public BSTPair(){}

        public BSTPair(int max, int min, boolean isBST, int sum, int maxSum){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.maxSum = maxSum;
        }
    }

    public BSTPair validateBST(TreeNode root){
        if(root == null){
            return new BSTPair(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }

        if(root.left == null && root.right == null){
            return new BSTPair(root.val, root.val, true, root.val, root.val);
        }

        BSTPair left = validateBST(root.left);
        BSTPair right = validateBST(root.right);

        int currentMaxSum = Math.max(left.maxSum, right.maxSum);
        
        if(!left.isBST || !right.isBST || left.max >= root.val || right.min <= root.val){
            return new BSTPair(1,2,false,0,currentMaxSum); // max min garbage, isBST = false, sum = 0 but maxSum should be maximum
        }
        
        BSTPair ansPair = new BSTPair();
        ansPair.max = Math.max(root.val, right.max);
        ansPair.min = Math.min(root.val, left.min);
        ansPair.isBST = true;
        ansPair.sum = left.sum + right.sum + root.val;
        ansPair.maxSum = Math.max(currentMaxSum, ansPair.sum);

        return ansPair;
    }

    public int maxSumBST(TreeNode root) {
        int maxSum = validateBST(root).maxSum;

        return Math.max(maxSum, 0);
    }

}

//  2:26:53 ========================