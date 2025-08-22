// https://leetcode.com/problems/binary-tree-maximum-path-sum/

//  pura sai se samajh nai aya.. need to revisit and understand as well.

public class Q21_max_path_sum_node_2_node {

    public int[] maxNodeToNode(TreeNode root){
        if(root == null){
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        int[] leftPair = maxNodeToNode(root.left);
        int[] rightPair = maxNodeToNode(root.right);

        int maxLeftChildSum = leftPair[0];
        int maxRightChildSum = rightPair[0];

        int maxLeftNodeToNode = leftPair[1];
        int maxRightNodeToNode = rightPair[1];

        int maxPathSum = Math.max(Math.max(maxLeftChildSum + root.val, maxRightChildSum + root.val), root.val);
        // 3 Scenarios -> left Path + current node, right path + current node, current node

        int maxNodeToNode = Math.max(maxPathSum, Math.max(maxLeftChildSum + maxRightChildSum + root.val, Math.max(maxLeftNodeToNode, maxRightNodeToNode)));
        // all the above 3 scenariors, leftNTN one, rightNTN one, leftPathSum + rightPathSum + root.val

        return new int[]{maxPathSum, maxNodeToNode};
    }

    public int maxPathSum(TreeNode root) {
        return maxNodeToNode(root)[1];
    }
}
