import java.util.*;

public class Q5_isGraph_Connected {

    public static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, int N){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis = new boolean[N];
        
        for(int vertex=0; vertex<N; vertex++){
            if(vis[vertex]==false){
                ArrayList<Integer> currComponent = new ArrayList<>();
                dfs(vertex,vis,currComponent,graph);
                
                components.add(currComponent);
            }
        }
        return components;
    }

    public static void dfs(int vtx, boolean[] vis, ArrayList<Integer> currComponent, ArrayList<Edge>[] graph){
        vis[vtx] = true;
        currComponent.add(vtx);

        for(Edge e: graph[vtx]){
            int nbr = e.v;

            if(!vis[nbr]){
                dfs(nbr,vis,currComponent,graph);
            }
        }
    }

}



// ============================== gfg ka questions
// https://www.geeksforgeeks.org/problems/ connected-components-in-an-undirected-graph/1

class gfgQuestion{
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges){
        ArrayList<Integer>[] graph = new ArrayList[V];

        // got a 2d array, so need to make a graph first.
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // get connected componenets ka logic.

        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int vertex=0; vertex<V; vertex++){
            if(vis[vertex]==false){
                ArrayList<Integer> currComponent = new ArrayList<>();
                dfs(vertex,vis,currComponent,graph);
                
                components.add(currComponent);
            }
        }
        return components;
    }

    public static void dfs(int vtx, boolean[] vis, ArrayList<Integer> currComponent, ArrayList<Integer>[] graph){
        vis[vtx] = true;
        currComponent.add(vtx);

        for(Integer nbr: graph[vtx]){

            if(!vis[nbr]){
                dfs(nbr,vis,currComponent,graph);
            }
        }
    }
}