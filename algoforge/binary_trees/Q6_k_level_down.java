//  get all nodes k level down from a target node that is given

// directly taget node pe jo, left & right jao K-1 level,
//  when K=0, we reached K levels,
// sab nodes ko ans [] me dal do..


import java.util.ArrayList;

public class Q6_k_level_down {

    public static ArrayList<Integer> getKlevelDown(Node root, Node target, int K){
        ArrayList<Integer> ans = new ArrayList<>();

        gkld_helper(target, K, ans);

        return ans;
    }

    public static void gkld_helper(Node node, int K, ArrayList<Integer> ans){
        if(K == 0){
            ans.add(node.data);
            return;
        }

        gkld_helper(node.left, K-1, ans);
        gkld_helper(node.right, K-1, ans);
    }
    
}
