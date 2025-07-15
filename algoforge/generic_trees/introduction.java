package algoforge.generic_trees;

import java.util.ArrayList;
import java.util.Stack;

public class introduction {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // display a generic tree ===============================
    private static void display(Node node){
        String str = node.data+" -> ";
        for(Node child: node.children){
            str =+ child.data+", ";
        }
        str+=".";
        System.out.println(str);

        for(Node childNode: node.children){
            display(childNode);
        }
    }


    // calculate size of a generic tree =====================
    private static int size(Node node){
        int s = 0;

        // counting nodes of all the children
        for(Node child: node.children){
            int countOfChild = size(child);
            s = s + countOfChild;
        }
        s=s+1;  // for root node
        return s;
    }


    //maximum of a generic tree ==============================
    private static int maxValue(Node node){
        int max = Integer.MIN_VALUE;

        // getting max from children nodes
        for(Node child: node.children){ 
            int maxValueFromChild = maxValue(child);
            max = Math.max(max, maxValueFromChild);
        }
        // child values vs root node
        max = Math.max(max, node.data);
        return max;
    }


    //height of a generic tree ===============================
    public static int height(Node node){
        int height = -1;
        
        for(Node child: node.children){
            int heightFromChild = height(child);
            height = Math.max(heightFromChild, height);
        }
        height+=1;
        
        return height;
    }


    //traversal in a generic tree ============================
    public static void traversals(Node node){

        //node pre area
        System.out.println("Node pre : " + node.data);
        for(Node child: node.children){
            //edge pre
            System.out.println("Edge pre: "+child.data);
            traversals(node);    
            //edge post
            System.out.println("Edge post: "+child.data);
        }
        //node post area
        System.out.println("Node post : " + node.data);

    }

    // level order traversal in generic trees ===============
    


    public static void main(String[] args) {
        
        int[] arr = {};

        Node root = null;
        Stack<Node> st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            } else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size()>0){
                    st.peek().children.add(t);
                } else{
                    root = t;
                }

                st.push(t);
            }
        }

        display(root);
    }
}
