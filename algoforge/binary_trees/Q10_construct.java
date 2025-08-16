// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/6458109/beats-100-construct-binary-tree-from-preorder-and-postorder-traversal-dfs-solution/


import java.util.*;

import javax.swing.tree.TreeNode;

public class Q10_construct {


    // leetcode 105, build from preorder and inorder =======================
    public TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei){
        //  base case.. li<ri
        if(psi > pei){
            return null;
        }

        // pre ka 0th position is the root node of the tree.
        TreeNode root = new TreeNode(preorder[psi]);
        
        // we find left subtree me kitne elements hai..
        // finding index of root inorder to divide left and right subtrees
        int leftElements = 0;
        int rootIdx = isi;
        while(rootIdx <= iei && inorder[rootIdx] != root.val){
            rootIdx++;
            leftElements++;
        }

        // then we tell to build the left and right sub trees
        root.left = buildTree(preorder, psi + 1, psi + leftElements, inorder, isi, rootIdx-1);
        root.right = buildTree(preorder, psi + leftElements + 1, pei, inorder, rootIdx + 1, iei);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }


    // construct BT from inorder and postorder ===========================

    public TreeNode inpost_helper(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei){
        
        //basecase
        if(isi>iei){
            return null;
        }

        //root node will be post ka last index
        TreeNode rootNode = new TreeNode(postorder[pei]);

        // we need to calculate left and right subtree elements
        int idx = isi;      // dont keep idx = 0 else arrayOutofbounds..
        while(inorder[idx] != rootNode.val){
            idx++;
        }

        int leftSize = idx - isi;

        rootNode.left = inpost_helper(inorder, isi, idx-1, postorder, psi, psi+leftSize-1);

        rootNode.right = inpost_helper(inorder, idx+1, iei, postorder, psi+leftSize, pei-1);

        return rootNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return inpost_helper(inorder, 0, n-1, postorder, 0, n-1);
    }



    // construct BT from preorder and postorder ===========================

    
    // root of the entire tree is pre[0]..
    // root of left subtree is pre[1].. obviously.. think carefully..
    // now we find this value in post[] and we get no of elements in left subtree
    // we can now cal. right subtree elements as well..
    // and now put it accordingly in root.left and root.right ka calls me.

    public TreeNode prepost_helper(int[] preorder, int prsi, int prei, int[] postorder, int posi, int poei){

        if(prsi > prei){
            return null;
        }

        if(prsi == posi){
            return new TreeNode(preorder[prsi]);
        }

        TreeNode root = new TreeNode(preorder[prsi]);
        int idx = posi;

        // looking for root of left tree in post..
        while(postorder[idx] != preorder[prsi + 1]){
            idx++;
        }

        int subTreeElements = idx - posi + 1;
        
        root.left = prepost_helper(preorder, prsi+1, prsi+subTreeElements, postorder, posi, poei+subTreeElements-1);

        root.right = prepost_helper(preorder, prsi+subTreeElements+1, prei, postorder, posi+subTreeElements, poei-1);

        return root;
    }


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return prepost_helper(preorder, 0, n-1, postorder, 0, n-1);
    }
}
