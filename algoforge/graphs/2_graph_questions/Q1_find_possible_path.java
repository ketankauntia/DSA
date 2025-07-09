// package algoforge.graphs.2_graph_questions;

import java.util.ArrayList;

public class Q1_find_possible_path {

    public static boolean hasPath_rec(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;    // marking this as visited to avoid stack overflow

        boolean hasPath = false;

        // we start from source, so arr[source] ke bacho me, i.e, arraylist of edges 
        // me check krenge iterate kr krke
        for(Edge edge : graph[src]){
            int nbr = edge.v;   // neighbour edge
            if(visited[nbr] == false){
                hasPath = hasPath || hasPath_rec(nbr, des,graph,visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
