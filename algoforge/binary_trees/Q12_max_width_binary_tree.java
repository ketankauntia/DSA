// https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.*;


//  horizontal level should be the same.. and max width between 2 nodes..
public class Q12_max_width_binary_tree {

    public static class pair{
        TreeNode node = null;
        int idx = 0;

        pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        
        LinkedList<pair> que = new LinkedList<>();
        int max = 0;

        que.addLast(new pair(root,0));
        while(que.size() != 0){
            int size = que.size();
            int lm = que.getFirst().idx;
            int rm = que.getFirst().idx;
            while(size -- > 0){
                pair rp = que.removeFirst();
                rm = rp.idx ;
                if(rp.node.left != null){
                    que.addLast(new pair(rp.node.left,rp.idx*2 + 1));
                } 
                if(rp.node.right != null){
                    que.addLast(new pair(rp.node.right, rp.idx*2 + 2));
                }
            }
            max = Math.max(max, rm - lm +1);
        }
        return max;
    }
}

//  find width vertically ( max width, irrespective of the levels..)

    public void findWidth(Node root, int VerticalLevel, int[] maxMin){
        if(root == null){
            return;
        }

        maxMin[0] = Math.max(maxMin[0], VerticalLevel);
        maxMin[1] = Math.min(maxMin[1], VerticalLevel);

        findWidth(root.left, VerticalLevel - 1, maxMin);
        findWidth(root.right, VerticalLevel + 1, maxMin);
    }

    public int findWidth(Node root){
        int[] maxMin = new int[2];

        findWidth(root, 0, maxMin);

        int widthOfTree = maxMin[0] - (maxMin[1]) + 1;

        return widthOfTree;
    }