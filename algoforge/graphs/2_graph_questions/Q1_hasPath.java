import java.util.*;

// Q1: has path =====================================
public class Q1_hasPath {

    public static boolean hasPath(int src,int des, ArrayList<Edge>[] graph, int N){
        // write your code here.
        boolean[] vis = new boolean[N]; // visited []
        return hasPath_helper(src, des, graph, vis);
    }
    
    public static boolean hasPath_helper(int src, int des, ArrayList<Edge>[] graph, boolean[] vis){
        if(src == des){
            return true;
        }
        
        vis[src]=true;
        boolean hasPath = false;
        
        for(Edge e: graph[src]){
            int nbr = e.v;
            
            if(vis[nbr] == false){
                hasPath = hasPath || hasPath_helper(nbr, des, graph, vis);
            }
        }
        // vis[src] = false; //not req as its undirected graph.
        return hasPath;
    }
    
}