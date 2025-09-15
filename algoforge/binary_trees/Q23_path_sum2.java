// https://leetcode.com/problems/path-sum-ii/

import java.util.*;

public class Q23_path_sum2 {


    public void getAllPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                currentPath.add(root.val);

                allPaths.add(new ArrayList<>(currentPath));

                currentPath.remove(currentPath.size()-1);
            }
            return;
        }

        currentPath.add(root.val);
        getAllPaths(root.left, targetSum-root.val, currentPath, allPaths);
        getAllPaths(root.right, targetSum-root.val, currentPath, allPaths);

        currentPath.remove(currentPath.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        getAllPaths(root, targetSum, currentPath, allPaths);
        return allPaths;
    }
}
