// https://leetcode.com/problems/distribute-coins-in-binary-tree/ 

public class Q29_distribute_coins_BT {

    // helper
    public int coinsRequired(TreeNode root, int[] moves){
        if(root == null){
            return 0;
        }

        int leftTreeRequirement = coinsRequired(root.left, moves);
        int rightTreeRequirement = coinsRequired(root.right, moves);

        moves[0] += Math.abs(leftTreeRequirement)+Math.abs(rightTreeRequirement);

        return leftTreeRequirement+rightTreeRequirement+root.val-1;
    }


    // main fn.
    public int distributeCoins(TreeNode root) {
        int[] moves = new int[1];

        coinsRequired(root, 0);
        return moves[0];
    }
}
