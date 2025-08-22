// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

//  same as prev. just added null instead of 0.. and in loop, checked if null, then added value else continues..

import java.util.ArrayList;
import java.util.LinkedList;

public class Q17_top_view {

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static class vPair {
        Node node;
        int h1;

        vPair(Node node, int h1) {
            this.node = node;
            this.h1 = h1;
        }
    }

    public static void width(Node root, int hl, int[] minMax) {
        if (root == null) return;

        minMax[0] = Math.max(minMax[0], hl); // maxHL
        minMax[1] = Math.min(minMax[1], hl); // minHL

        width(root.left, hl - 1, minMax);
        width(root.right, hl + 1, minMax);
    }

    public static ArrayList<Integer> topView(Node root) {
        if (root == null) return new ArrayList<>();

        int[] minMax = new int[2];
        minMax[0] = Integer.MIN_VALUE; // maxHL
        minMax[1] = Integer.MAX_VALUE; // minHL

        width(root, 0, minMax);

        int maxHL = minMax[0], minHL = minMax[1];
        int len = maxHL - minHL + 1;

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) ans.add(null);    // did a change here..

        int shift = -minHL; // to make indices non-negative

        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, 0 + shift));

        while (!que.isEmpty()) {
            vPair rp = que.removeFirst();
            Node node = rp.node;
            int hl = rp.h1;

            if(ans.get(hl) == null){
                ans.set(hl, node.data);
            }

            if (node.left != null)
                que.addLast(new vPair(node.left, hl - 1));
            if (node.right != null)
                que.addLast(new vPair(node.right, hl + 1));
        }
        return ans;
    }
}
