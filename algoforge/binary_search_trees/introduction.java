//  left me saare chote elements, right me sare bade elements

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

public class introduction {
    public static Node buildBST(int[] arr, int si, int ei){

        if(si>ei){
            return null;
        }

        int mid = (si+ei)/2;

        Node root = new Node(arr[mid]);

        root.left = buildBST(arr, si, mid-1);
        root.right = buildBST(arr, mid+1, ei);

        return root;
    }

    public static void display(Node root){
        if(root == null){
            return;
        }

        String currNodeStucture = (root.left == null ? "." : root.left.data) + " <- " + root.data + " -> " + (root.right == null ? "." : root.right.data);
        System.out.println(currNodeStucture);

        display(root.left);
        display(root.right);

    }

    public static int sumOfBST(Node root){
        if(root == null){
            return 0;
        }

        int sumOfLeftSubtree = sumOfBST(root.left);
        int sumOfRightSubtree = sumOfBST(root.right);

        return sumOfLeftSubtree + sumOfRightSubtree + root.data;
    }

    public static int minOfBST(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null){
            return root.data;
        }

        return minOfBST(root.left);
    }

    public static int maxOfBST(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        if(root.right == null){
            return root.data;
        }

        return maxOfBST(root.right);
    }

    public static int min_iterative(Node root){
        Node temp = root;

        while(temp.left != null){
            temp = temp.left;
        }

        return temp.data;
    }

    public static int max_iterative(Node root){
        Node temp = root;

        while(temp.right != null){
            temp = temp.right;
        }

        return temp.data;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,11,34,45,55,61,69,71,85};

        Node root = buildBST(arr, 0, arr.length-1);

        // display(root);
        // System.out.println(minOfBST(root));
        // System.out.println(minOfBST_iterative(root));
        // System.out.println(maxOfBST(root));
        // System.out.println(maxOfBST_iterative(root));
    }
}
