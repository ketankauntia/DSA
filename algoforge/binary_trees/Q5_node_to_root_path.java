import java.util.ArrayList;

public class Q5_node_to_root_path {
    public static ArrayList<Integer> nodeTORootPath(Node root, int target){

        if(root == null){
            return new ArrayList<>();
        }

        if(root.data == target){
            ArrayList<Integer> baseAns = new ArrayList<>();
            baseAns.add(root.data);
            return baseAns;
        }

        ArrayList<Integer> leftAns = nodeTORootPath(root.left, target);
        if(leftAns.size() > 0){
            leftAns.add(root.data);
            return leftAns;
        }

        ArrayList<Integer> rightAns = nodeTORootPath(root.right, target);
        if(rightAns.size() > 0){
            rightAns.add(root.data);
            return rightAns;
        }
        return new ArrayList<>();
    }

}
