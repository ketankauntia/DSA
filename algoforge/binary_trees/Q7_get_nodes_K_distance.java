import java.util.*;


public class Q7_get_nodes_K_distance {
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode target){
        if(root == null){
            return new ArrayList<>();
        }

        if(root.equals(target)){
            ArrayList<TreeNode> bans = new ArrayList<>();
            bans.add(target);
            return bans;
        }

        ArrayList<TreeNode> left = nodeToRootPath(root.left, target);
        if(left.size() > 0){
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath(root.right, target);
        if(right.size() > 0){
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    public static void getKLevelDown(TreeNode node, TreeNode blocker, int k, List<Integer> res){
        if(node == null || k<0){
            return;
        }

        if(node.equals(blocker)){
            return;
        }

        if(k == 0){
            res.add(node.val);
            return;
        }

        getKLevelDown(node.left, blocker, k-1, res);
        getKLevelDown(node.right, blocker, k-1, res);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> ntr = nodeToRootPath(root, target);

        List<Integer> res = new ArrayList<>();

        for(int i=0; i<ntr.size(); i++){
            TreeNode currentNode = ntr.get(i);
            TreeNode blocker = i == 0 ? null : ntr.get(i-1);
            getKLevelDown(currentNode, blocker, k - i, res);
        }

        return res;
    }
}
