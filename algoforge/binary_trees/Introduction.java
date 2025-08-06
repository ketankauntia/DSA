// 

import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

class Pair{
    Node node;
    int state;

    public Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

public class Introduction {

    // ==================== size of binary tree
    public static int size(Node root){
        if(root == null){
            return 0;
        }

        int leftSize = size(root.left);
        int rigthSize = size(root.right);

        return leftSize + rigthSize + 1;
    }

    public static int sum (Node node){
        if(node == null){
            return 0;
        }

        int leftKaSum = sum(node.left);
        int rightKaSum = sum(node.right);
        int totalSum = leftKaSum+rightKaSum+node.data;

        return totalSum;
    }

    public static int maxOfBinaryTree (Node node){

        if(node==null){
            return Integer.MIN_VALUE;
        }

        int leftKaMax = maxOfBinaryTree(node.left);
        int rightKaMax = maxOfBinaryTree(node.right);

        int finalMax = Math.max(Math.max(leftKaMax, rightKaMax), node.data);

        return finalMax;
    }
    
    public static int height (Node node){
        if(node == null){
            return -1;  // -1 for edges, 0 for nodes
        }

        int leftKaHeight = height(node.left);
        int rightKaHeight = height(node.right);

        int totalHeight = Math.max(leftKaHeight,rightKaHeight)+1;

        return totalHeight;
    }


    // ========================= display tree
    public static void display(Node root){
        if(root == null){
            return;
        }

        String currNodeStucture = (root.left == null ? "." : root.left.data) + " <- " + root.data + " -> " + (root.right == null ? "." : root.right.data);
        // String currNodeStucture = "";
        // if(root.left != null){
        //     currNodeStucture += root.left.data + " <- ";
        // }

        // currNodeStucture += root.data;

        // if(root.right != null){
        //     currNodeStucture += " -> " + root.right.data;
        // }

        System.out.println(currNodeStucture);

        display(root.left);
        display(root.right);
    }

    // ====================== making a binary tree
    public static Node constructTree(Integer[] arr){
        Node root = null;
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            Integer ele = arr[i];
            Node newNode = null;

            if(ele!= null){
                newNode = new Node(ele);
            }

            if(st.size()==0){
                root = newNode;
            } else if(st.peek().state == 1){
                st.peek().node.left = newNode;
                st.peek().state++;
            } else{
                st.peek().node.right = newNode;
                st.pop();
            }
            if(newNode != null){
                st.push(new Pair(newNode, 1));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {10,20,11,null,15,null,null,12,14,null,null,null,30,null,13,16,null,null,17,null,null};

        Node root = constructTree(arr);
        // display(root);
    }
}
