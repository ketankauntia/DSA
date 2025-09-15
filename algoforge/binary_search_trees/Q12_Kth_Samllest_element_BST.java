// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
//  didnt understand the stack approach.

class Q12_Kth_Samllest_element_BSTs{

    public void addAllLeft(TreeNode curr, Stack<TreeNode> st){
        while(curr!=null){
            st.add(curr);
            curr = curr.left;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        addAllLeft(root, st);

        while(k-- > 1){
            TreeNode top = st.pop();

            addAllLeft(top.right, st);  //putting next greater value on top
        }

        return st.peek().val;
    }
}

// morris approach =====================================
public TreeNode getRightMost(TreeNode root, TreeNode parent){

        TreeNode temp = root;
        while(temp.right != null && temp.right != parent){
            temp = temp.right;
        }
        return temp;
    }


public int kthSmallest(TreeNode root, int k) {
    TreeNode curr = root;

    while(curr != null){

        if(curr.left == null){
            // we visit curr
            if(--k == 0){
                return curr.val;
            }
            curr = curr.right;
        } else{

            TreeNode rightmost = getRightMost(curr.left, curr);

            if(rightmost.right == null){
                rightmost.right = curr; // created thread
                curr = curr.left;
            } else{ // removing thread and visiting curr
                rightmost.right = null;
                if( --k == 0){
                    return curr.val;
                }
                curr = curr.right;
            }
        }
    }
    return -1; 
}