// https://leetcode.com/problems/binary-search-tree-iterator/
// morris traversal

public class Q11_BST_iterator {
    
}



class BSTIterator {

    TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        this.curr = root;
    }
    
    private TreeNode getRightMost(TreeNode node){
        while(node.right!=null && node.right!= this.curr){
            node = node.right;
        }
        return node;
    }

    private TreeNode morrisTraversal(){

        TreeNode res = null;

        while(this.curr!=null){
            TreeNode leftNode = this.curr.left;
            
            if(curr.left == null){
                res = this.curr;
                this.curr = this.curr.right;
                break;
            } else{
                //left side find right most, check if linked or not, break-unbreak
                TreeNode rightMost = getRightMost(this.curr.left);
                
                if(rightMost.right == null){
                    // no prev. connection, we make one.
                    rightMost.right = this.curr;
                    curr = curr.left;
                } else{
                    //prev conn. present, need to remove this.
                    res = this.curr;
                    rightMost.right = null;
                    this.curr = this.curr.right;
                    break;
                }
            }
        }
        return res;
    }

    public int next() {
        TreeNode res = morrisTraversal();
        return res.val;
    }
    
    public boolean hasNext() {
        return this.curr != null;
    }
}