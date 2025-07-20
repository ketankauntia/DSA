import java.util.ArrayList;

public class Q6_Hamiltonian_Path {
    public static boolean checkIfEdge(int a, int b, ArrayList<Edge>[] graph){
        for(Edge e: graph[a]){
            if(e.v == b){
                return true;
            }
        }

        return false;
    }

    public static void dfs_hamiltonian(int currVtx, int osrc, int edgesVisited,ArrayList<Edge>[] graph,String cpath,boolean[] vis,int N){
        if(edgesVisited == N-1){
            if(checkIfEdge(currVtx, osrc, graph) == true){
                System.out.println("Hamiltonian Cycle: " + cpath);
            } else {
                System.out.println("Hamiltonian Path: " + cpath);
            }
            return;
        }

        vis[currVtx] = true;

        for(Edge e: graph[currVtx]){
            int nbr = e.v;
            if(!vis[nbr]){ 
                dfs_hamiltonian(nbr,osrc,edgesVisited+1,graph,cpath+"->"+nbr,vis,N);
            }
        }

        vis[currVtx] = false;
    }

    public static void printHamiltonianPathCycle(ArrayList<Edge>[] graph, int src, int N){
        dfs_hamiltonian(src,src,0,graph,""+src,new boolean[N],N);
    }
}
