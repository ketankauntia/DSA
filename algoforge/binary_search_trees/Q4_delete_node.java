import javax.swing.tree.TreeNode;

public class Q4_delete_node {

    public TreeNode findLeftMost(TreeNode root){
        TreeNode temp = root;

        while( temp.left != null){
            temp = temp.left;
        }

        return temp.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null){
            return null;
        }

        if(root.val>key){
            root.left = deleteNode(root.left, key);
        } else if(root.val<key){
            root.right = deleteNode(root.right, key);
        } else{

            if(root.left == null && root.right == null){ // leaf node
                return null;
            } else if( root.left == null){  // 1 child
                return root.right;
            } else if(root.right == null){  // 1 child
                return root.left;
            } else{ // 2 child

                // finding the just greater value
                int justGreaterVal = findLeftMost(root.right);
                root.val = justGreaterVal;

                root.right = deleteNode(root.right, justGreaterVal);
            }
        }

        return root;
    }
}
