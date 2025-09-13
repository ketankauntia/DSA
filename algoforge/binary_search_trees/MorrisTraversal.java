import java.util.*;
import javax.swing.tree.TreeNode;

class MorrisTraversal {

    public Node findRightMost(Node root, Node curr){

        Node temp = root;

        while(temp.right!=null && temp.right != curr){
            temp = temp.right;
        }
        return temp;
    }

    public void MorrisTraversal(Node root){
        Node curr = root;

        while(curr!=null){
            if(curr.left == null){
                curr = curr.right;  // thread travel, edge travel
            } else{
                Node rightMost = findRightMost(curr.left, curr);

                // no thread yet, create one.
                if(rightMost.right == null){ 
                    rightMost.right = curr; // thread creation
                    curr = curr.left;
                } else{
                    rightMost.right = null; //thread deletion
                    curr = curr.right;
                }
            }
        }
    }



    //  IN-ORDER morris traversal

    //  agar right parent ko access kr pa raha hai means ki thread banaya gaya hai. else how will right node point to its grandfather node?

    public TreeNode getRightMostELe(TreeNode root, TreeNode parent){
        TreeNode temp = root;
        // checking for parent so that we know we are not taking the thread node
        while(temp.right != null && temp.right != parent){
            temp = temp.right;
        }
        return temp;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        TreeNode currEle = root;

        if(currEle == null) return ans;
        

        while (currEle != null) {
            // left side nai hai, right side visit krenge.
            if(currEle.left == null){
                ans.add(currEle.val);
                currEle = currEle.right;
            } else{ //if left side is there, we visit left side first.
                
                //rightmost element nikalna h
                TreeNode rightMostEle = getRightMostELe(currEle.left, currEle);
                
                if(rightMostEle.right == null){
                    //thread banana h
                    rightMostEle.right = currEle;
                    currEle = currEle.left;
                    
                } else{
                    // thread already exists, remove krna h.
                    rightMostEle.right = null;
                    ans.add(currEle.val);
                    currEle = currEle.right;
                }
            }
        }
        return ans;
    }


    // Pre-order morris traversal ==========================================
    // https://leetcode.com/problems/binary-tree-preorder-traversal/

   public List<Integer> preorderTraversal(TreeNode root) {
        
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        if(curr==null) return ans;

        while(curr!=null){

            if(curr.left == null){
                // left empty h, right jana h.
                ans.add(curr.val);
                curr = curr.right;
            } else{
                //left side me ja rahe h.
                
                //rightmost find krke make link then update.
                TreeNode rightMostNode = getRightMostELe(curr.left, curr);


                //right is null then create thread link
                if(rightMostNode.right == null){  
                    ans.add(curr.val);  
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else{         // else remove thread
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}


