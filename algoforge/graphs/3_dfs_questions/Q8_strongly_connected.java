// kosaraju algorithm : didn't do properly.. revise again + dry run.

// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

import java.util.*;
import java.util.Stack;
public class Q8_strongly_connected {
    
    public static void dfs_fill_stack(int src,boolean[] vis,ArrayList<ArrayList<Integer>> graph,Stack<Integer> st){
        vis[src] = true;

        for(int nbr: graph.get(src)){
            if(!vis[nbr]){
                dfs_fill_stack(nbr,vis,graph,st);
            }
        }

        st.push(src);
    }
    // just traverse through the component
    public static void dfs(int src, boolean[] vis,ArrayList<Integer>[] reversedGraph){
        vis[src] = true;

        for(int nbr: reversedGraph[src]){
            if(!vis[nbr]){
                dfs(nbr,vis,reversedGraph);
            }
        }
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int N = adj.size();
        boolean[] vis = new boolean[N];

        for(int i=0; i<N; i++){
            if(!vis[i]){
                dfs_fill_stack(i,vis,adj,st);
            }
        }

        ArrayList<Integer>[] reversedGraph = new ArrayList[N];
        for(int i=0; i<N; i++){
            reversedGraph[i] = new ArrayList<>();
        }

        for(int u=0; u<N; u++){
            for(int i=0; i<adj.get(u).size(); i++){
                int v = adj.get(u).get(i);
                reversedGraph[v].add(u);
            }
        }

        int num_scc = 0;
        vis = new boolean[N];
        while(st.size() > 0){
            int vtx = st.pop();

            if(!vis[vtx]){
                dfs(vtx,vis,reversedGraph);
                num_scc++;
            }
        }

        return num_scc;
    }   
}
