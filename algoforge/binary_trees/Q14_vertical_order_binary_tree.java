// https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

import java.util.*;


public class Q14_vertical_order_binary_tree {
    
    public static class vPair{
        Node node = null;
        int h1 = 0;

        vPair(Node node, int h1){
            this.node = node;
            this.h1 = h1;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrder(Node root){
        
        LinkedList<vPair> que = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int maxhl = 0;  // max horizontal level
        int minhl = 0;  // min horizontal level

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        que.addLast(new vPair(root, 0));

        while (que.size()!=0){
        
            int size = que.size();
        
            while(size-- > 0){
                vPair rp = que.removeFirst();   // remove pair

                map.putIfAbsent(rp.h1, new ArrayList<>());
                map.get(rp.h1).add(rp.node.data);

                maxhl = Math.max(maxhl, rp.h1);
                minhl = Math.min(minhl, rp.h1);

                if(rp.node.left != null){
                    que.addLast(new vPair(rp.node.left, rp.h1-1));
                }

                if(rp.node.right != null){
                    que.addLast(new vPair(rp.node.right, rp.h1+1));
                }
            }

            for(int i = minhl; i<=maxhl; i++){
                ans.add(map.get(i));    // shallow copy kiye h idhar me..
            }
        }

        return ans;
    }
}
