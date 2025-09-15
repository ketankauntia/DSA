// https://www.geeksforgeeks.org/problems/predecessor-and-successor/1

import java.util.*;

public class Q13_predecessor_and_successor {
    Node pred;
    Node succ;
    Node prev;
    public boolean traverseInorder(Node root, int key){
        if(root == null) return false;

        if(traverseInorder(root.left, key)) return true;

        if(root.data < key){
            pred = root;
        } else if(prev != null && root.data > key && prev.data <= key){
            succ = root;
            return true;
        }

        prev = root;
        if(traverseInorder(root.right, key)) return true;

        return false;
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        pred = null;
        succ = null;
        prev = null;

        ArrayList<Node> ans = new ArrayList<>();
        traverseInorder(root, key);
        
        ans.add(pred);
        ans.add(succ);
        return ans;
    }
}
