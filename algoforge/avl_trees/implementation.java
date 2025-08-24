package algoforge.avl_trees;

class Node{
    int data;
    Node left;
    Node right;

    int height;
    int balanceFactor;

    public Node(){}
    public Node(int data){
        this.data = data;
    }
}

public class Implementation {

    // AVL Utils ========================

    public static void updateHeightAndBF(Node root){
        int leftHeight = -1;
        int rightHeight = -1;

        if(root.left != null){
            leftHeight = root.left.height;
        }

        if(root.right != null){
            rightHeight = root.right.height;
        }

        root.height = Math.max(leftHeight, rightHeight) + 1;
        root.balanceFactor = leftHeight - rightHeight;
    }

    public static Node rightRotate(Node A){
        Node B = A.left;
        Node BKaRight = B.right;

        B.right = A;
        A.left = BKaRight;

        updateHeightAndBF(A);
        updateHeightAndBF(B);

        return B;   // new root
    }

    public static Node leftRotate(Node A){
        Node B = A.right;
        Node BkaLeft = B.left;

        B.left = A;
        A.right = BkaLeft;

        updateHeightAndBF(A);
        updateHeightAndBF(B);

        return B;   // new root
    }

    public static Node balanceBST(Node root){
        updateHeightAndBF(root);

        if(root.balanceFactor == 2){    // left-left, left-right
            if(root.left.balanceFactor == 1){   // left-left
                return rightRotate(root);   // right rotate
            } else {    // left-right
                root.left = leftRotate(root.left); //left rotate(root.left)
                return rightRotate(root); // right rotate root
            }
        } else if(root.balanceFactor == -2){    // right-right, right-left
            if(root.right.balanceFactor == -1){ //right-right
                return leftRotate(root); // left rotate
            } else{ // right-left
                root.right = rightRotate(root.right); // right roatate(root.right)
                return leftRotate(root); // left rotate root
            }
        }

        return root;
    }

    // =====================

    public static Node addData(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data < val){
            root.right = addData(root.right, val);
        } else{
            root.left = addData(root.right, val);
        }

        return balanceBST(root);
    }

    public int findLeftMost(Node root){
        Node temp = root;

        while(temp.left != null){
            temp = temp.left;
        }
        return temp.val;
    }

    public static Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }

        if(root.data > key){
            root.left = deleteNode(root.left, key);
        } else if(root.data < key){
            root.right = deleteNode(root.right, key);
        } else{
            if(root.left == null && root.right == null){ // leaf node
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else{
                // both child present
                // finding just the greater
                int justGreaterVal = findLeftMost(root.right);
                root.data = justGreaterVal;

                root.right = deleteNode(root.right, justGreaterVal);
            }
        }

        return balanceBST(root);
    }

    public static void display(Node root){
        if( root == null ) return;

        // ...
    }

    public static void main(String[] args) {
        
    }
}
