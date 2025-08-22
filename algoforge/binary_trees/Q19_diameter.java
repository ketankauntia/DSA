//  imp : sort of dp concept.. so that we do not fire 2 recusive call 

public class Q19_diameter {
    
    static class DiaPair{
        int ht;     //height
        int dia;    //diameter
    }

    public static DiaPair diameter2(Node node){
        if(node == null){
            DiaPair bp = new DiaPair(); // b ase pair
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int fes = lp.ht + rp.ht + 2;
        mp.dia = Math.max(fes, Math.max(lp.dia, rp.dia));

        return mp;
    }
}

//  same , lc solution -------------------

class Solution {
    class Dpair{
        int ht;
        int dia;    // diameter
    }

    public Dpair d_helper(TreeNode root){
        if(root == null){
            Dpair bp = new Dpair(); // base pair
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        Dpair lp = d_helper(root.left);
        Dpair rp = d_helper(root.right);

        Dpair mp = new Dpair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int fes = lp.ht + rp.ht + 2;
        mp.dia = Math.max(fes, Math.max(lp.dia, rp.dia));

        return mp;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        Dpair ans = d_helper(root);

        return ans.dia;
    }
}