// https://leetcode.com/problems/is-graph-bipartite/

// NAI samjh aya.. Need to dry run this.

// acyclical ( non-cyclical ) graphs are bipartite.
// cyclical even length are bipartite.
// cyclical ODD length are not bipartite.

import java.util.Arrays;
import java.util.LinkedList;

public class Q7_is_graph_bipartite {
    // All acyclic and even length cycle graph are bipartite
    public boolean isCycleEven(int[][] graph, int src, int[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        int color = 0; // even level, color = 0, odd level, color = 1
        
        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                int vtx = que.removeFirst();

                if(vis[vtx] != -1 && vis[vtx] != color){ // already but not equal to current level
                    return false; // odd cycle
                }

                vis[vtx] = color;

                for(int nbr: graph[vtx]){
                    if(vis[nbr] == -1){
                        que.addLast(nbr);
                    }
                }
            }
            color = (color + 1) % 2; // color = 0->1, 1->0
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1); // not visited = -1

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                if(isCycleEven(graph,i,vis) == false){
                    return false;
                }
            }
        }

        return true;
    }
}
