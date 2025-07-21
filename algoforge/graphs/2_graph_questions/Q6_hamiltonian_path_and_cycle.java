//  path that visits each vertex exactly one time.

import java.util.ArrayList;

// how are we finding cycle? -> we reach n-1 vertex. NOw, if it is cycle, then,
// we are at the last of the path. and if 1st vtx & last vtx have a route (checkIFEdge) then there is a cycle.

public class Q6_hamiltonian_path_and_cycle{

    public static void printHamiltonianPathCycle(ArrayList<Edge>[] graph, int src, int N){
        dfs_hamiltonian(src,src,0,graph,""+src, new boolean[N], N);
    }

    public static boolean checkIfEdge(int a, int b, ArrayList<Edge>[] graph){
        for(Edge e: graph[a]){
            if(e.v == b){
                return true;
            }
        }
        return false;
    }

    public static void dfs_hamiltonian(int currVtx, int osrc, int edgesVisited, ArrayList<Edge>[] graph, String cpath, boolean[] visited, int N){

        if(edgesVisited == N-1){
            if(checkIfEdge(currVtx,osrc, graph)==true){
                System.out.println("Hamilton Cycle" + cpath);
            } else{
                System.out.println("Hamiltonian Path: " + cpath);
            }
            return;
        }

        visited[currVtx] = true;

        for(Edge e: graph[currVtx]){
            int nbr = e.v;
            if(!visited[nbr]){
                dfs_hamiltonian(nbr, osrc, edgesVisited+1, graph, cpath+nbr, visited, N);
            }
        }
        visited[currVtx] = false;

    }
}