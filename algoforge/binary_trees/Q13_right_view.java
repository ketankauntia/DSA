// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

// Ek inner loop chalate hain har level ke liye.
// Har node ko queue se nikal kar: 
    // Agar uska left child hai to queue me daal dete hain.
    // Agar uska right child hai to queue me daal dete hain.
// prev variable me current level ka last node store hota rehta hai.
// Har level complete hone ke baad, jo prev node bacha hai wo us level ka sabse rightmost node hoga.

public class Q13_right_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        if(root == null) return new ArrayList<>();
        
        que.addLast(root);

        while(que.size()>0){
            int size = que.size();
            TreeNode prev = null;

            while(size -- > 0){
                TreeNode currNode = que.removeFirst();

                if(currNode.left!= null){
                    que.addLast(currNode.left);
                }
                if(currNode.right!= null){
                    que.addLast(currNode.right);
                }

                prev = currNode;
            }
            ans.add(prev.val);
        }
        return ans;
    }
}
