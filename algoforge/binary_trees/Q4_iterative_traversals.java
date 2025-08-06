import java.util.*;

public class Q4_iterative_traversals {
    public static void iterativeTraversals(Node node){

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> st = new Stack<>();

        Pair rootPair = new Pair(node, 1);
        st.push(rootPair);

        while(st.size()>0){
            Pair top = st.peek();

            if(top.state == 1){
                // matlab, pre me h, state++ and push left node
                pre.add(top.node.data);
                top.state++;
                
                if(top.node.left != null){
                    Pair leftNode = new Pair(top.node.left, 1);
                    st.push(leftNode); 
                }
                
            } else if(top.state == 2){
                // matlab, pre ho gya h, state++ and push right node
                in.add(top.node.data);
                top.state++;
                
                if(top.node.right != null){
                    Pair rightNode = new Pair(top.node.right, 1);
                    st.push(rightNode); 
                }

            } else{ // state is 3
                // pre nd in ho gya h, post me h, put in post and pop
                post.add(top.node.data);

                st.pop();
            }
        }
        System.out.println(pre +" \n"+ in +" \n"+ post);
    }
}
