import java.util.*;

public class Q4_connected_components {
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
