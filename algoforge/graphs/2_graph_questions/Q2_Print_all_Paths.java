import java.util.*;

//  in lexiographic order : dictionary order...

public class Q2_Print_all_Paths {
    
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int des){
        boolean[] visited = new boolean[graph.length];
        printAllPaths_helper(graph, src, des, visited, src+"");
    }
    
    public static void printAllPaths_helper(ArrayList<Edge>[] graph, int src, int des, boolean[] visited, String psf){

        if(src == des){
            System.out.println(psf);    // psf = path so far.
            return;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            int nbr = edge.v;
            if(visited[nbr]==false){
                printAllPaths_helper(graph, nbr, des, visited, psf + nbr);
            }
        }
        visited[src] = false;
    }
}
