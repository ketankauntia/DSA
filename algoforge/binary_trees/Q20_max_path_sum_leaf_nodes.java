// https://www.geeksforgeeks.org/problems/maximum-path-sum/1

public class Q20_max_path_sum_leaf_nodes {

    int maxLeafToNode(Node root, int[] maxLeafToLeaf){
        if(root == null){
            return -(int)(1e8);
        }

        if(root.left == null && root.right == null){
            return root.data;
        }

        int maxLeftLTN = maxLeafToNode(root.left, maxLeafToLeaf);
        int maxRightLTN = maxLeafToNode(root.right, maxLeafToLeaf);

        if(root.left != null && root.right != null){
            maxLeafToLeaf[0] = Math.max(maxLeafToLeaf[0], maxLeftLTN+maxRightLTN+root.data);
        }
        return Math.max(maxLeftLTN, maxRightLTN) + root.data;
    }

    int maxPathSum(Node root) {
        // code here
        int[] maxLeafToLeaf = new int[1];
        maxLeafToNode(root, maxLeafToLeaf);
        return maxLeafToLeaf[0];
    }
}
