// https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

import java.util.ArrayList;

public class Q18_diagonal_view {

    public void findDiagonalWidth(Node root, int[] min, int diagLevel){
        if(root == null) return;

        min[0] = Math.min(min[0], diagLevel);

        findDiagonalWidth(root.left, min, diagLevel - 1);
        findDiagonalWidth(root.right, min, diagLevel);
    }

    public void traverseDiagonally(Node root, ArrayList<ArrayList<Integer>> ans, int diagLevel){
        if(root == null) return;

        ans.get(diagLevel).add(root.data);

        traverseDiagonally(root.left, ans, diagLevel - 1);
        traverseDiagonally(root.right, ans, diagLevel);
    }

    public ArrayList<Integer> diagonal(Node root) {
        int[] min = new int[1];
        findDiagonalWidth(root,min,0);
        int diagonalWidth = -(min[0]) + 1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<diagonalWidth; i++){
            ans.add(new ArrayList<>());
        }

        traverseDiagonally(root,ans,-min[0]);

        // converting 2d arraylist to 1d
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=ans.size()-1; i>=0; i--){
            for(int e: ans.get(i)){
                res.add(e);
            }
        }

        return res;
    }
}
