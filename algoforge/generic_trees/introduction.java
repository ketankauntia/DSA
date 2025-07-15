package algoforge.generic_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class introduction {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){}

        Node(int data){
            this.data = data;
        }
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
    // (A : using Queue)
    public static void levelOrderTraversalQueue(Node node){

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(q.size()>0){
            node = q.remove();
            System.out.println(node.data);
            for(Node child: node.children){
                q.add(child);
            }
        }
        System.out.print(".");
    }

    // (B : linewise)
    // we'll use 2 queues here. main queue for parent nodes
    // 2nd queue for child nodes.
    // when parent queue is empty, we move all child nodes to parent queue and fill up child queue with new child nodes..
    public static void levelOrderTraversalLinewise(Node node){
        Queue<Node> mq = new ArrayDeque<>(); // main queue
        mq.add(node);
        
        Queue<Node> cq = new ArrayDeque<>(); // child queue
        while(mq.size()>0){
            node = mq.remove();
            System.out.print(node.data + " ");

            for(Node child: node.children){
                cq.add(child);
            }

            if(mq.size()==0){ // matlab ek level khatam ho gya.
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }

    }

    // (C: linewise - zigzag : right to left then, left to right printing..)
    public static void levelOrderTraversalZigZag(Node node){
        Stack<Node> ms = new Stack<>(); //main stack
        ms.push(node);

        Stack<Node> cs = new Stack<>(); //child stack
        int level=1;

        while(ms.size()>0){
            node = ms.pop();
            System.out.println(node.data + " ");
            
            if(level % 2 == 1){
                for(int i=0; i<node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                } 
            } else{
                for(int i=node.children.size()-1; i>=0; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ms.size()==0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }


    // Level Order Linewise Approach2.
    // push all from a level and add a null.
    public static void levelOrderLineWise2(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));

        while(mq.size()>0){
            // we remove the element from the queue and check,
            node = mq.remove();
            // jab tak null nai mil ra, print the parent(node) and add the children nodes
            if(node.data != -1){
                System.out.println(node.data + " ");
                for(Node child: node.children){
                    mq.add(child);
                }
            } else{
                // when we get a null, we will check if there is any other element, if there, we push a null to teh end
                if(mq.size()>0){
                    mq.add(null);
                    System.out.println();
                }
            }
        }
    }

    // mirror a generic tree
    public static void mirror(Node node){
        for(Node child: node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    // remove leaf nodes from a generic tree
    public static void removeLeaf(Node node){
        for(int i=node.children.size()-1; i>=0; i++){
            Node child = node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(child);
            }
        }

        for(Node child: node.children){
            removeLeaf(child);
        }
    }

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
