// bfs with priority queue(of weight)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P7_prims {
    
}

class Prims{

    class Pair{
        int par;
        int vtx;
        int wt;

        public Pair(int par, int vtx, int wt){
            this.par = par;
            this.vtx = vtx;
            this.wt = wt;
        }
    }

    public ArrayList<Edge>[] getMST_ByPrims(ArrayList<Edge>[] graph, int N){
        
        ArrayList<Edge>[] mst = new ArrayList[N];
        for(int i=0;i<N;i++){
            mst[i] = new ArrayList<>();
        }

        boolean[] vis = new boolean[N];

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wt - b.wt;
        });

        pq.add(new Pair(-1, 0, 0));

        while(){
            Pair top = pq.remove();
            if(vis[top.vtx]) continue;
            vis[top.vtx] = true;

            if(top.par != -1){
                addEdge(mst, top.par, top.vtx, top.wt);
            }

            for(Edge e: graph[top.vtx]){
                int nbr = e.v;
                if(!vis[nbr]){
                    pq.add(new Pair(top.vtx, nbr, e.w));
                }
            }
        }
        return mst;
    }
}