// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

// < solved on my own >

import java.util.ArrayList;
import java.util.LinkedList;

public class Q11_left_view {
    ArrayList<Integer> leftView(Node root) {
        // code here

        if (root == null) return new ArrayList<>();

        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Node> childque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        que.add(root);

        while(que.size()>0){
            ans.add(que.peekFirst().data);
            
            // adding all childern nodes
            while(que.size()!=0){
                Node currNode = que.removeFirst();
                if(currNode.left != null) childque.addLast(currNode.left);
                if(currNode.right != null) childque.add(currNode.right);
            }

            que = childque;
            childque = new LinkedList<>();
        }
        return ans;
    }
}
